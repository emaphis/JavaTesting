package sis.report;


import junit.framework.TestCase;
import studentinfo.CourseSession;
import studentinfo.DateUtil;
import studentinfo.Student;

import org.junit.Test;

public class RosterReporterTest extends TestCase {

	@Test
	public void testRosterReport() {
		CourseSession session =
				new CourseSession("ENGL", "101",
						new DateUtil().createDate(2003,1, 6));

		session.enroll(new Student("A"));
		session.enroll(new Student("B"));

		String rosterReport = new RosterReporter(session).getReport();

		assertEquals(RosterReporter.ROSTER_REPORT_HEADER +
				     "A" + RosterReporter.NEWLINE +
				     "B" + RosterReporter.NEWLINE +
				     RosterReporter.ROSTER_REPORT_FOOTER + "2" +
				     RosterReporter.NEWLINE, rosterReport);
	}
}
