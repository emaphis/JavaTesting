package sis.studentinfo;

import java.util.*;


public class Student {
	private String name;
	private int credits;
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String state = "";

	public enum Grade {
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);

		private int points;

		private Grade (int points) {
			this.points = points;
		}

		int getPoints() {
			return points;
		}
	}

	private List<Grade> grades = new ArrayList<>();
	private GradingStratagy gradingStrategy = new BasicGradingStrategy();

	public Student(String name) {
		this.name = name;
		credits = 0;
	}

	public String getName() {
		return name;
	}

	boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	int getCredits() {
		return credits;
	}

	void addCredits(int credits) {
		this.credits += credits;
	}

	boolean isInState() {
		return state.equals(Student.IN_STATE);
	}

	void setState(String state) {
		this.state = state.toUpperCase();
	}

	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	public double getGpa() {
		if (grades.isEmpty())
			return 0.0;

		double total = 0.0;
		for (Grade grade: grades) {
			total += gradingStrategy.getGradePointsFor(grade);
		}

		return total / grades.size();
	}

	public void setGradingStrategy(GradingStratagy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}

}
