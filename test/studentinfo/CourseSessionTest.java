package studentinfo;

import org.junit.Test;
import junit.framework.TestCase;
import studentinfo.CourseSession;
import studentinfo.DateUtil;
import studentinfo.Student;

import java.util.*;

public class CourseSessionTest extends TestCase {
	private CourseSession session;
	private Date startDate;

	@Override
	protected void setUp() throws Exception {
		startDate = new DateUtil().createDate(2003, 1, 6);
		session = new CourseSession("ENGL", "101", startDate);
	}

	@Test
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}

	@Test
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));

		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}

	@Test
	public void testCourseDates() {
		Date sixteenWeeksOut = new DateUtil().createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

}
