package ch19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParsingExam {

	public static void main(String[] args) throws Exception {
		// 파일로부터 JSON 읽기
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp2/people.json", Charset.forName("UTF-8")));
		String people = br.readLine();
		br.close();

		// JSON 파싱
		JSONObject obj = new JSONObject(people);
		JSONArray arr = obj.getJSONArray("people");

		// 메소드 실행
		Person person1 = parsePerson(arr.getJSONObject(0));
		Person person2 = parsePerson(arr.getJSONObject(1));
		System.out.println(person1);
		System.out.println(person2);
	}

	private static Person parsePerson(JSONObject obj) {
		// 객체 속성 정보 읽기
		JSONObject tel = obj.getJSONObject("tell");

		// 배열 속성 정보 읽기
		JSONArray skill = obj.getJSONArray("skill");
		String[] arr = new String[skill.length()];

		for (int i = 0; i < skill.length(); i++) {
			arr[i] = skill.getString(i);
		}

		// 속성 정보 읽기
		return new Person(obj.getString("id"), obj.getString("name"), obj.getInt("age"), obj.getBoolean("student"),
				new Tel(tel.getString("home"), tel.getString("mobile")), arr);
	}
}
