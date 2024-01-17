package ch12;

public class StudentInvoke {
	
	String name;
	int quizScore;
	int middleScore;
	int finalScore;
	
	StudentInvoke(String name) {
		this.name = name;
	}
	
	public double getTotal() {
		double tmp = (this.quizScore + this.middleScore + this.finalScore)/3.0;
		tmp = Math.round(tmp*10)/10.0;
		return tmp;
	}
	
	public char getGrade() {
		int level = (int)this.getTotal()/10;
		switch(level) {
			case 10: case 9 : return 'A';
			case 8 : return 'B';
			case 7 : return 'C';
			case 6 : return 'D';
			default : return 'F';
		}
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", quizScore=" + quizScore + ", middleScore=" + middleScore + ", finalScore="
				+ finalScore + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuizScore() {
		return quizScore;
	}
	
	public boolean setQuizScore(int quizScore) {
		if(!validateScore(quizScore)) {
			System.out.println("퀴즈 점수가 0보다 작거나 100보다 크다");
			return false;
		}
		this.quizScore = quizScore;
		return true;
	}

	public int getMiddleScore() {
		return middleScore;
	}
	
	public boolean setMiddleScore(int middleScore) {
		if(!validateScore(middleScore)) {
			System.out.println("중간시험 점수가 0보다 작거나 100보다 크다");
			return false;
		}
		this.middleScore = middleScore;
		return true;
	}
	
	public int getFinalScore() {
		return finalScore;
	}
	
	public boolean setFinalScore(int finalScore) {
		if(!validateScore(finalScore)) {
			System.out.println("기말시험 점수가 0보다 작거나 100보다 크다");
			return false;
		}
		this.finalScore = finalScore;
		return true;
	}
	
	private boolean validateScore(int score) {
		if(score > 100 || score < 0) return false;
		return true;
	}
	

}
