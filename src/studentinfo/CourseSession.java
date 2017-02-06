package studentinfo;

import java.util.ArrayList;
import java.util.*;

/**
* Provides a representation of a single-semester
* session of a specific university course.
* @author Administrator
*/
public class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<>();
	private Date startDate;

	public CourseSession(String department, String number, Date startDate) {
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

	public void enroll(Student student) {
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

}
