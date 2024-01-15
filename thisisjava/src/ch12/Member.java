package ch12;

import lombok.*;

@Data
@AllArgsConstructor	//	모든 요소를 생성자의 파라미터로 받게 만든다.
@NoArgsConstructor	//	기본 생성자를 만든다.
@Getter	//	getter만 만들어준다.
@Setter //	setter만 만들어준다.
//@RequiredArgsConstructor	//	final을 붙인 필드가 파라미터로 필요한 생성자를 만들어준다.
@EqualsAndHashCode //	equals와 hashcode를 만든다.
@ToString	// tostring을 만든다.
public class Member {
	private String id;	//	getter setter를 사용하기 때문에 private로 설정
	private String name;
	private int age;
}
