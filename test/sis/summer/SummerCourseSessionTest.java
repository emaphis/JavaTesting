package sis.summer;

import junit.framework.*;
import org.junit.Test;
import java.util.*;
import sis.studentinfo.*;

public class SummerCourseSessionTest extends TestCase {
	@Test
	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);
		CourseSession session =
				SummerCourseSession.create("ENGL", "200", startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}
}
