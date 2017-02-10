package sis.studentinfo;

import org.junit.Test;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;

import java.util.*;

public class CourseSessionTest extends SessionTest {

	@Test
	public void testCourseDates() {
		Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession("ENGL", "200", startDate);
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

	@Test
	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", new Date());
		assertEquals(1, CourseSession.getCount());
		createSession("", "", new Date());
		assertEquals(2, CourseSession.getCount());
	}

	protected CourseSession createSession(String department,
										  String number,
										  Date date) {
		return CourseSession.create(department, number, date);
	}

}
