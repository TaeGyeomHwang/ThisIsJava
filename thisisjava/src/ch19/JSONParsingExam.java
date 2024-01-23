package ch19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParsingExam {

	public static void main(String[] args) throws Exception {
		// ���Ϸκ��� JSON �б�
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp2/people.json", Charset.forName("UTF-8")));
		String people = br.readLine();
		br.close();

		// JSON �Ľ�
		JSONObject obj = new JSONObject(people);
		JSONArray arr = obj.getJSONArray("people");

		// �޼ҵ� ����
		Person person1 = parsePerson(arr.getJSONObject(0));
		Person person2 = parsePerson(arr.getJSONObject(1));
		System.out.println(person1);
		System.out.println(person2);
	}

	private static Person parsePerson(JSONObject obj) {
		// ��ü �Ӽ� ���� �б�
		JSONObject tel = obj.getJSONObject("tell");

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
}
