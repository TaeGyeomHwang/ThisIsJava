package ch08;

//	sealed를 인터페이스에 쓰면 구현을 막는게 아닌 상속을 막는 것
public sealed interface InterfaceA permits InterfaceB{
	void methodA();
}
