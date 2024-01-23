package ch19;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonExam {

	public static void main(String[] args) throws Exception {
		Person winter = new Person(
					"winter",
					"한겨울",
					25,
					true,
					new Tel("02-123-1234", "010-1234-1324"),
					new String[] { "java", "C", "C++" }
				);

		Person summer = new Person(
					"summer",
					"한여름",
					25,
					true,
					new Tel("02-123-1234", "010-1234-1324"),
					new String[] { "Python", "C", "C++" }
				);

		JSONObject obj1 = createJSON(winter);
		JSONObject obj2 = createJSON(summer);

		JSONObject root = new JSONObject();

		JSONArray people = new JSONArray();
		people.put(obj1);
		people.put(obj2);

		root.put("people", people);

		Writer writer = new FileWriter("C:/Temp2/people.json", Charset.forName("UTF-8"));
		writer.write(root.toString()); // 내용물을 파일로 쓰고 싶다면 toString 사용.
		writer.flush();
		writer.close();
	}

	private static JSONObject createJSON(Person person) {
		JSONObject obj = new JSONObject();
		obj.put("id", person.getId()); // put으로 데이터 입력 가능. 처음이 키, 뒤가 밸류.
		obj.put("name", person.getName());
		obj.put("age", person.getAge());
		obj.put("student", person.isStudent());

		JSONObject inner = new JSONObject();
		inner.put("home", person.getTel().getHome());
		inner.put("mobile", person.getTel().getMobile());

		obj.put("tel", inner); // 객체도 객체에 넣을 수 있다.

		JSONArray skill = new JSONArray();
		skill.put(person.getSkill()[0]);
		skill.put(person.getSkill()[1]);
		skill.put(person.getSkill()[2]);

		obj.put("skill", skill);

		return obj;
	}

}
