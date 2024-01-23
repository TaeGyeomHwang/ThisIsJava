package ch19.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;

import ch19.Person;
import ch19.Tel;

public class MainProcess {

	private static final Scanner scan = new Scanner(System.in);
	private static List<Person> people = new ArrayList<>();
	private static JSONObject root = new JSONObject();
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		int select = 0;
		String id;
		String name;
		int age;
		boolean student;
		String telHome;
		String telMobile;
		String skill1;
		String skill2;
		String skill3;

		// ���Ϸκ��� JSON �б�
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Temp2/people.json", Charset.forName("UTF-8")))) {
			String json = br.readLine();

			// JSON �Ľ�
			JSONObject obj = new JSONObject(json);
			JSONArray arr = obj.getJSONArray("people");

			for (int i = 0; i < arr.length(); i++) {
				JSONObject person = arr.getJSONObject(i);
				people.add(parsePerson(person));
			}
		} catch (IOException e) {
			System.err.println("IOException �߻�: " + e.getMessage());
		}

		while (select != 5) {
			System.out.println("----------------------------------------------");
			System.out.println("              �ο� ���� ���α׷�");
			System.out.println("----------------------------------------------");
			System.out.println("| 1.��ȸ | 2.�߰� | 3.���� | 4.���� | 5.���� |");
			System.out.println("----------------------------------------------");
			System.out.println("���Ͻô� �޴��� �����Ͻʽÿ� > ");
			select = Integer.parseInt(scan.nextLine());

			switch (select) {
				case 1 -> { // ��ȸ
					if (people.size() == 0) {
						System.out.println("�ο��� �����ϴ�.");
						break;
					}
					for (Person p : people) {
						System.out.println(p);
					}
				}
				case 2 -> { // �߰�
					try {
						System.out.print("id�� �Է��Ͻʽÿ� >");
						id = scan.nextLine();
						if (id.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						System.out.print("name�� �Է��Ͻʽÿ� >");
						name = scan.nextLine();
						if (name.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						System.out.print("age�� �Է��Ͻʽÿ� >");
						age = Integer.parseInt(scan.nextLine());
	
						System.out.print("student�� �Է��Ͻʽÿ� >");
						student = Boolean.parseBoolean(scan.nextLine());
	
						System.out.print("tel-home�� �Է��Ͻʽÿ� >");
						telHome = scan.nextLine();
						if (telHome.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						System.out.print("tel-mobile�� �Է��Ͻʽÿ� >");
						telMobile = scan.nextLine();
						if (telMobile.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						System.out.print("skill-1�� �Է��Ͻʽÿ� >");
						skill1 = scan.nextLine();
						if (skill1.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						System.out.print("skill-2�� �Է��Ͻʽÿ� >");
						skill2 = scan.nextLine();
						if (skill2.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						System.out.print("skill-3�� �Է��Ͻʽÿ� >");
						skill3 = scan.nextLine();
						if (skill3.equals("")) {
							System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
							break;
						}
	
						Person p = new Person(id, name, age, student, new Tel(telHome, telMobile),
								new String[] { skill1, skill2, skill3 });
	
						people.add(p);
	
						JSONObject obj = createJSON(p);
						JSONArray jsonArr = new JSONArray();
						jsonArr.put(obj);
						root.put("member", jsonArr);
	
						System.out.println("�����Ͱ� �߰��Ǿ����ϴ�");
					} catch (Exception e) {
						System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
						break;
					}
	
				}
				case 3 -> { // ����
					System.out.print("������ member�� id�� �Է����ּ��� > ");
					id = scan.nextLine();
					boolean isTrue = false;
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i).getId().equals(id)) {
							isTrue = true;
							System.out.println("�ش� �л��� ����\n" + people.get(i));
							System.out.print("������ �ʵ带 �������ּ��� >");
							String input = scan.nextLine();
							if (input.equals("id")) {
								System.out.println("������ �����͸� �Է����ּ��� >");
								id = scan.nextLine();
								if (id.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								} else {
									people.get(i).setId(id);
									System.out.println("���� ó�� �Ǿ����ϴ�");
									break;
								}
							} else if (input.equals("name")) {
								System.out.println("������ �����͸� �Է����ּ��� >");
								name = scan.nextLine();
								if (name.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								} else {
									people.get(i).setName(name);
									System.out.println("���� ó�� �Ǿ����ϴ�");
									break;
								}
							} else if (input.equals("age")) {
								System.out.println("������ �����͸� �Է����ּ��� >");
								try {
									age = Integer.parseInt(scan.nextLine());
								} catch (Exception e) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								people.get(i).setAge(age);
								System.out.println("���� ó�� �Ǿ����ϴ�");
	
								break;
							} else if (input.equals("student")) {
								System.out.println("������ �����͸� �Է����ּ��� >");
								try {
									student = Boolean.parseBoolean(scan.nextLine());
								} catch (Exception e) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								people.get(i).setStudent(student);
								System.out.println("���� ó�� �Ǿ����ϴ�");
	
								break;
							} else if (input.equals("tel")) {
								System.out.print("tel-home�� �Է��Ͻʽÿ� >");
								telHome = scan.nextLine();
								if (telHome.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								System.out.print("tel-mobile�� �Է��Ͻʽÿ� >");
								telMobile = scan.nextLine();
								if (telMobile.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								people.get(i).setTel(new Tel(telHome, telMobile));
								System.out.println("���� ó�� �Ǿ����ϴ�");
								break;
	
							} else if (input.equals("skill")) {
								System.out.print("skill-1�� �Է��Ͻʽÿ� >");
								skill1 = scan.nextLine();
								if (skill1.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								System.out.print("skill-2�� �Է��Ͻʽÿ� >");
								skill2 = scan.nextLine();
								if (skill2.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								System.out.print("skill-3�� �Է��Ͻʽÿ� >");
								skill3 = scan.nextLine();
								if (skill3.equals("")) {
									System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
									break;
								}
								people.get(i).setSkill(new String[] { skill1, skill2, skill3 });
								System.out.println("���� ó�� �Ǿ����ϴ�");
								break;
							}
						}
					}
					if (!isTrue) {
						System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
						break;
					}
				}
				case 4 -> { // ����
					System.out.print("������ member�� id�� �Է����ּ��� > ");
					id = scan.nextLine();
					boolean isTrue = false;
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i).getId().equals(id)) {
							isTrue = true;
							people.remove(i);
	
							System.out.println("���� ó�� �Ǿ����ϴ�");
							break;
						}
					}
					if (!isTrue) {
						System.out.println("�Է��� �����Ͱ� �ùٸ��� �ʽ��ϴ�");
						break;
					}
				}
				default -> {
					if (select != 5)
						System.out.println("�߸� �����Ͽ����ϴ�.");
				}
			}
		}
		stopMain(); // ����
	}

	private static void stopMain() { // ��Ƽ������� ���α׷� �����ϴ� �޼ҵ�
		Thread thread = new Thread() {
			@Override
			public void run() {
				executorService.execute(() -> {
					MyTask task = new MyTask();
					Timer timer = new Timer();
					// 0.5�� �������� �ݺ�
					timer.schedule(task, 0, 500);
					try {
						// 1���Ŀ� �����带 �����.
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						timer.cancel();
					}
					// Ÿ�̸� ���
					timer.cancel();
					fileWrite();
					System.exit(0);
				});
			}
		};
		thread.start();
	}

	private static Person parsePerson(JSONObject obj) { // ��ü ���� �о���� �޼ҵ�
		// ��ü �Ӽ� ���� �б�
		JSONObject tel = obj.getJSONObject("tel");

		// �迭 �Ӽ� ���� �б�
		JSONArray skill = obj.getJSONArray("skill");
		String[] arr = new String[skill.length()];

		for (int i = 0; i < skill.length(); i++) {
			arr[i] = skill.getString(i);
		}

		// �Ӽ� ���� �б�
		return new Person(obj.getString("id"), obj.getString("name"), obj.getInt("age"), obj.getBoolean("student"),
				new Tel(tel.getString("home"), tel.getString("mobile")), arr);
	}

	private static JSONObject createJSON(Person person) { // JSONObject �����ϴ� �޼ҵ�
		JSONObject obj = new JSONObject();
		obj.put("id", person.getId()); // put���� ������ �Է� ����. ó���� Ű, �ڰ� ���.
		obj.put("name", person.getName());
		obj.put("age", person.getAge());
		obj.put("student", person.isStudent());

		JSONObject inner = new JSONObject();
		inner.put("home", person.getTel().getHome());
		inner.put("mobile", person.getTel().getMobile());

		obj.put("tell", inner); // ��ü�� ��ü�� ���� �� �ִ�.

		JSONArray skill = new JSONArray();
		skill.put(person.getSkill()[0]);
		skill.put(person.getSkill()[1]);
		skill.put(person.getSkill()[2]);

		obj.put("skill", skill);

		return obj;
	}

	private static void fileWrite() { // JSON ���� �����ϴ� �޼ҵ�
		try {
			root.put("people", people);
			Writer writer = new FileWriter("C:/Temp2/people.json", Charset.forName("UTF-8"));
			writer.write(root.toString()); // ���빰�� ���Ϸ� ���� �ʹٸ� toString ���.
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
