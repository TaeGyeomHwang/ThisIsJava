package ch08.example.exam4;

public class Student {
	String name;
	int quiz;
	int midterm;
	int finalterm;
	double totalScore;
	String totalGrade;

	public Student(String name) {
		this.name = name;
	}

	public int getQuiz() {
		return this.quiz;
	}

	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}

	public int getMidterm() {
		return this.midterm;
	}

	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	public int getFinalterm() {
		return this.finalterm;
	}

	public void setFinalterm(int finalterm) {
		this.finalterm = finalterm;
	}
	
	public double getTotalScore() {
		return this.totalScore;
	}
	
	public String getTotalGrade() {
		return this.totalGrade;
	}

	public Double setTotalScore() {
		double totalScore = this.getQuiz() * 0.2 + this.getMidterm() * 0.3 + this.getMidterm() * 0.5;
		this.totalScore = totalScore;
		return this.totalScore;
	}

	public String setTotalGrade() {
		if(this.getTotalScore()>=90) {
			this.totalGrade = "A";
			return this.totalGrade;
		}else if(this.getTotalScore()>=80 && this.getTotalScore()<90){
			this.totalGrade = "B";
			return this.totalGrade;
		}else if(this.getTotalScore()>=70 && this.getTotalScore()<80){
			this.totalGrade = "C";
			return this.totalGrade;
		}else if(this.getTotalScore()>=60 && this.getTotalScore()<70){
			this.totalGrade = "D";
			return this.totalGrade;
		}else {
			this.totalGrade = "F";
			return this.totalGrade;
		}
	}

}
