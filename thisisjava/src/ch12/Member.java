package ch12;

import lombok.*;


@AllArgsConstructor	//	모든 요소를 생성자의 파라미터로 받게 만든다.
@NoArgsConstructor	//	기본 생성자를 만든다.
//@RequiredArgsConstructor	//	final을 붙인 필드를 파라미터로 받는 생성자를 만들어준다.

//@Data //	아래 다섯개를 만들어준다. 만약 전부 다 쓸거라면 data를 사용. 아니라면 세부 항목만 사용
@Getter	//	getter만 만들어준다.
@Setter //	setter만 만들어준다.
@EqualsAndHashCode //	equals와 hashcode를 만든다.
@ToString	// tostring을 만든다.
public class Member {
	private String id;	//	getter setter를 사용하기 때문에 private로 설정
//	@NonNull	//	final과 같은 점: null상태로 둬서는 안되고 초기값을 설정해야 한다. 따라서 RequiredArgsConstructor에 영향 받음 final과 다른 점:초기화는 강제지만 불변인 값은 아니다.
	private String name;
	private int age;
}