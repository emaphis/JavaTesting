package studentinfo;

import java.util.*;

/**
* Provides a representation of a single-semester
* session of a specific university course.
* @author Administrator
*/
public class CourseSession {
	private static int count;
	private String department;
	private String number;
	private int numberOfCredits;
	private ArrayList<Student> students = new ArrayList<>();
	private Date startDate;

	private CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public Student get(int index) {
		return students.get(index);
	}

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfDays = 16 * 7 - 3;  // weeks * days per week - 3 days
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	public Date getStartDate() {
		return startDate;
	}

	public ArrayList<Student> getAllStudents() {
		return students;
	}

	// class methods
	static int getCount() {
		return count;
	}

	static void resetCount() {
		count = 0;
	}

	private static void incrementCount() {
		++count;
	}

	// factoy method
	public static CourseSession create(String department, String number, Date startDate2) {
		incrementCount();
		return new CourseSession(department, number, startDate2);
	}

}
