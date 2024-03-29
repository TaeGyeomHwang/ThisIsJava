package ch06.example;

public class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		if(this.isPowerOn=true) {
			this.isPowerOn = false;
		}else {
			this.isPowerOn = true;
		}
	}
	
	void volumeUp() {
		if(this.volume<MAX_VOLUME) {
			this.volume++;
		}
	}
	
	void volumnDown() {
		if(this.volume>MAX_VOLUME) {
			this.volume++;
		}
	}
	
	void channelUp() {
		if(this.channel>MAX_CHANNEL) {
			this.channel = MIN_CHANNEL;
		}else {
			this.channel++;
		}
	}
	void channelDown() {
		if(this.channel<MIN_CHANNEL) {
			this.channel = MAX_CHANNEL;
		}else {
			this.channel--;
		}
	}
}
