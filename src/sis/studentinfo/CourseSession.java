package sis.studentinfo;

import java.util.*;

/**
* Provides a representation of a single-semester
* session of a specific university course.
* @author Administrator
*/
public class CourseSession extends Session {
	private static int count;

	public static CourseSession create(String department,
            							String number,
            							Date startDate){
		return new CourseSession(department, number, startDate);
	}

	protected CourseSession(String department,
			                String number,
			                Date startDate) {
		super(department, number, startDate);
		CourseSession.incrementCount();
	}


	// class methods

	private static void incrementCount() {
		++count;
	}

	static void resetCount() {
		count = 0;
	}

	static int getCount() {
		return count;
	}

	@Override
	protected int getSessionLength() {
		return 16;
	}

	// Comparable implementation
	public int compareTo(CourseSession that) {
		int compare =
				this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0)
			compare = this.getNumber().compareTo(that.getNumber());
		return compare;
	}

}
