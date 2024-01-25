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
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainProcess {

	private static final Scanner scan = new Scanner(System.in);
	private static List<Person> people = new ArrayList<>();
	private static JSONObject root = new JSONObject();
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		int select = 0;
		String id;
		String name;
		String age;
		String student;
		String telHome;
		String telMobile;
		String skill1;
		String skill2;
		String skill3;

		// 파일로부터 JSON 읽기
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Temp2/people.json", Charset.forName("UTF-8")))) {
			String json = br.readLine();

			// JSON 파싱
			JSONObject obj = new JSONObject(json);
			JSONArray arr = obj.getJSONArray("people");

			for (int i = 0; i < arr.length(); i++) {
				JSONObject person = arr.getJSONObject(i);
				people.add(parsePerson(person));
			}
		} catch (IOException e) {
			System.err.println("IOException 발생: " + e.getMessage());
		}

		while (select != 5) {
			System.out.println("----------------------------------------------");
			System.out.println("              인원 관리 프로그램");
			System.out.println("----------------------------------------------");
			System.out.println("| 1.조회 | 2.추가 | 3.수정 | 4.삭제 | 5.종료 |");
			System.out.println("----------------------------------------------");
			System.out.println("원하시는 메뉴를 선택하십시오 > ");
			select = Integer.parseInt(scan.nextLine());

			switch (select) {
				case 1 -> { // 조회
					if (people.size() == 0) {
						System.out.println("인원이 없습니다.");
						break;
					}
					for (Person p : people) {
						System.out.println(p);
					}
				}
				case 2 -> { // 추가
					Person p = new Person();
					if(!valId(p))break;
					if(!valName(p))break;
					if(!valAge(p))break;
					if(!valStudent(p))break;
					if(!valTel(p))break;
					if(!valSkill(p))break;
					people.add(p);
					System.out.println("데이터가 추가되었습니다");
				}
				case 3 -> { // 수정
					System.out.print("수정할 member의 id를 입력해주세요 > ");
					id = scan.nextLine();
					boolean isTrue = false;
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i).getId().equals(id)) {
							isTrue = true;
							System.out.println("해당 학생의 정보\n" + people.get(i));
							System.out.print("수정할 필드를 선택해주세요 >");
							String input = scan.nextLine();
							if (input.equals("id")) {
								System.out.println("변경할 데이터를 입력해주세요 >");
								id = scan.nextLine();
								if (id.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								} else {
									people.get(i).setId(id);
									System.out.println("정상 처리 되었습니다");
									break;
								}
							} else if (input.equals("name")) {
								System.out.println("변경할 데이터를 입력해주세요 >");
								name = scan.nextLine();
								if (name.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								} else {
									people.get(i).setName(name);
									System.out.println("정상 처리 되었습니다");
									break;
								}
							} else if (input.equals("age")) {
								System.out.println("변경할 데이터를 입력해주세요 >");
								try {
									age = scan.nextLine();
								} catch (Exception e) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								people.get(i).setAge(age);
								System.out.println("정상 처리 되었습니다");
	
								break;
							} else if (input.equals("student")) {
								System.out.println("변경할 데이터를 입력해주세요 >");
								try {
									student = scan.nextLine();
								} catch (Exception e) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								people.get(i).setStudent(student);
								System.out.println("정상 처리 되었습니다");
	
								break;
							} else if (input.equals("tel")) {
								System.out.print("tel-home을 입력하십시오 >");
								telHome = scan.nextLine();
								if (telHome.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								System.out.print("tel-mobile을 입력하십시오 >");
								telMobile = scan.nextLine();
								if (telMobile.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								people.get(i).setTel(new Tel(telHome, telMobile));
								System.out.println("정상 처리 되었습니다");
								break;
	
							} else if (input.equals("skill")) {
								System.out.print("skill-1을 입력하십시오 >");
								skill1 = scan.nextLine();
								if (skill1.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								System.out.print("skill-2을 입력하십시오 >");
								skill2 = scan.nextLine();
								if (skill2.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								System.out.print("skill-3을 입력하십시오 >");
								skill3 = scan.nextLine();
								if (skill3.equals("")) {
									System.out.println("입력한 데이터가 올바르지 않습니다");
									break;
								}
								people.get(i).setSkill(new String[] { skill1, skill2, skill3 });
								System.out.println("정상 처리 되었습니다");
								break;
							}
						}
					}
					if (!isTrue) {
						System.out.println("입력한 데이터가 올바르지 않습니다");
						break;
					}
				}
				case 4 -> { // 삭제
					System.out.print("삭제할 member의 id를 입력해주세요 > ");
					id = scan.nextLine();
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i).getId().equals(id)) {
							people.remove(i);
							System.out.println("정상 처리 되었습니다");
							break;
						}
					}
					System.out.println("입력한 데이터가 올바르지 않습니다");
				}
				default -> {
					if (select != 5)
						System.out.println("잘못 선택하였습니다.");
				}
			}
		}
		stopMain(); // 종료
	}
	private static void stopMain() { // 멀티스레드로 프로그램 종료하는 메소드
		Thread thread = new Thread() {
			@Override
			public void run() {
				executorService.execute(() -> {
					MyTask task = new MyTask();
					Timer timer = new Timer();
					// 0.5초 간격으로 반복
					timer.schedule(task, 0, 500);
					try {
						// 1초후에 스레드를 멈춘다.
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						timer.cancel();
					}
					// 타이머 취소
					timer.cancel();
					fileWrite();
					executorService.shutdown();
				});
			}
		};
		thread.start();
	}

	private static Person parsePerson(JSONObject obj) { // 객체 정보 읽어오는 메소드
		// 객체 속성 정보 읽기
		JSONObject tel = obj.getJSONObject("tel");

		// 배열 속성 정보 읽기
		JSONArray skill = obj.getJSONArray("skill");
		String[] arr = new String[skill.length()];

		for (int i = 0; i < skill.length(); i++) {
			arr[i] = skill.getString(i);
		}

		// 속성 정보 읽기
		return new Person(obj.getString("id"), obj.getString("name"), obj.getString("age"), obj.getString("student"),
				new Tel(tel.getString("home"), tel.getString("mobile")), arr);
	}

	private static JSONObject createJSON(Person person) { // JSONObject 생성하는 메소드
		JSONObject obj = new JSONObject();
		obj.put("id", person.getId()); // put으로 데이터 입력 가능. 처음이 키, 뒤가 밸류.
		obj.put("name", person.getName());
		obj.put("age", person.getAge());
		obj.put("student", person.getStudent());

		JSONObject inner = new JSONObject();
		inner.put("home", person.getTel().getHome());
		inner.put("mobile", person.getTel().getMobile());

		obj.put("tell", inner); // 객체도 객체에 넣을 수 있다.

		JSONArray skill = new JSONArray();
		skill.put(person.getSkill()[0]);
		skill.put(person.getSkill()[1]);
		skill.put(person.getSkill()[2]);

		obj.put("skill", skill);

		return obj;
	}

	private static void fileWrite() { // JSON 파일 저장하는 메소드
		try {
			root.put("people", people);
			Writer writer = new FileWriter("C:/Temp2/people.json", Charset.forName("UTF-8"));
			writer.write(root.toString()); // 내용물을 파일로 쓰고 싶다면 toString 사용.
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean valId(Person p) {
		System.out.print("id를 입력하십시오 >");
		String id = scan.nextLine();
		if (id.equals("")) {
			System.out.println("입력한 데이터가 올바르지 않습니다");
			return false;
		}else {
			p.setId(id);
			return true;
		}
	}
	private static boolean valName(Person p) {
		System.out.print("name을 입력하십시오 >");
		String name = scan.nextLine();
		if (name.equals("")) {
			System.out.println("입력한 데이터가 올바르지 않습니다");
			return false;
		}else {
			p.setName(name);
			return true;
		}
	}
	private static boolean valAge(Person p) {
		System.out.print("age를 입력하십시오 >");
		String age = scan.nextLine();
		if (age.equals("")) {
			System.out.println("입력한 데이터가 올바르지 않습니다");
			return false;
		}else {
			p.setAge(age);
			return true;
		}
	}
	private static boolean valStudent(Person p) {
		System.out.print("student를 입력하십시오(true 나 false) >");
		String student = scan.nextLine();
		if (student.equals("")||!student.equals("true") && !student.equals("false")) {
			System.out.println("입력한 데이터가 올바르지 않습니다");
			return false;
		}else {
			p.setStudent(student);
			return true;
		}
	}
	private static boolean valTel(Person p) {
		System.out.print("tel-home을 입력하십시오(각 자리수마다 - 입력) >");
		String telHome = scan.nextLine();
		if (!Pattern.matches("\\d{2,3}-\\d{3,4}-\\d{4}", telHome)) {
			System.out.println("입력한 데이터가 올바르지 않습니다");
			return false;
		}
		
		System.out.print("tel-mobile을 입력하십시오(각 자리수마다 - 입력) >");
		String telMobile = scan.nextLine();
		if (!Pattern.matches("\\d{2,3}-\\d{3,4}-\\d{4}", telMobile)) {
			System.out.println("입력한 데이터가 올바르지 않습니다");
			return false;
		}
		
		p.setTel(new Tel(telHome,telMobile));
		return true;
	}
	private static boolean valSkill(Person p) {
		String[] skills = new String[3];
		for(int i=0; i<3; i++) {
			System.out.print("skill-"+(i+1)+"을 입력하십시오 >");
			String skill = scan.nextLine();
			if (skill.equals("")) {
				System.out.println("입력한 데이터가 올바르지 않습니다");
				return false;
			}
			skills[i] = skill;
		}
		p.setSkill(new String[] { skills[0], skills[1], skills[2] });
		return true;
	}

}
