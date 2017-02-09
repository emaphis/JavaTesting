package sis.studentinfo;

public class BasicGradingStrategy implements GradingStratagy {
	@Override
	public int getGradePointsFor(Student.Grade grade) {
		//Student.Grade grade = new Student.G
		return grade.getPoints();
	}
}
