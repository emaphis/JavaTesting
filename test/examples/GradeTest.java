package examples;

import examples.GradeTest.Grade;

/*
 * enums extend java.lang.Enum
 * Enum is an abstract class
 * Enum implements Comparable and Serializable
 * Enums have 'no' public constructor
 * Enum values are public, static, and final.
 * Emum values aren't integers but members of the enum class itself.
 * the Enum is final so can't be subclassed
 * Enum is static so it can't access surrounding classes instance variabls.
 * Enum overrites toString: Grade.A.ToString returns "A"
 * Enums provide a valueOf() method.
 * Enums define a final instance of method ordinal().
 * Enums define a values() method, that returns an array of the enum type.
 *
 * Enum constuctor, not needed but must be private and
 *   their default values are always represented by string used
 *   in declaration
 *
 * Any added method is implicitly static.
 * Enums work with switches
 */


public class GradeTest {

	public enum Grade {
		A(5), B(4),	C(3), D(2),	F(0), INCLOMPLETE(-1);

		private int points;
		private String comment;

		private Grade (int points) {
			this.points = points;
		}

		int getPoints() {
			return points;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
	}

	public static void main(String[] args) {

		Student student1 = new Student("John");
		Student student2 = new Student("Ben");

		student1.setGrade(Grade.B);
		student2.setGrade(Grade.F);

		System.out.println(student1);
		System.out.println(student2);

		System.out.println(Grade.A.toString());
		System.out.println(Grade.valueOf("A"));

		// Enumbs create Arrays of their values:
		for (Grade grade: Grade.values()) {
			System.out.println(grade.name());
		}

		System.out.println("getPoints for A: " + Grade.A.getPoints());

		// members of Enums are static:
		System.out.println(Grade.A);
		Grade.A.setComment("You rock!");
		System.out.println(Grade.A.getComment());

		Grade grade1 = Grade.A;
		grade1.setComment("hihi");
		Grade grade2 = Grade.A;
		grade2.setComment("hoho");
		System.out.println(Grade.A.getComment());

		System.out.println(Grade.A.getComment());

		if (grade1 == grade2) {
			System.out.println("grade1==grade2");
		}
		if (grade1 == Grade.A) {
			System.out.println("grade1==Grade.A");
		}

		// switches:
		Grade gradeS = Grade.A;

		switch(gradeS) {
		case A:
			System.out.println("You got top grade");
			break;
		default:
			System.out.println("Try better next time");
			break;
		}
	}
}


class Student {
	private String name;
	private Grade grade;

	public Student(String name) {
		this.name = name;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student: " + name + " got grade " + grade.toString();
	}
}