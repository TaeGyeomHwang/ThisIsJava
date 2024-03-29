package ch08;

//	tv 클래스와 audio 클래스의 사용법을 알려주는 것.
public interface RemoteControl {

	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	void turnOn();

	void turnOff();

	void setVolume(int volume);

	void getVolume();

	// 구현하는 클래스가 인스턴스를 만들었을 때 기본적으로 가지는 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}

	static void chanegBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
}
