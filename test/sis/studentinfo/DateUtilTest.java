package sis.studentinfo;

import org.junit.Test;
import java.util.*;
import junit.framework.*;
import sis.studentinfo.DateUtil;

public class DateUtilTest extends TestCase {
	private Date startDate;

	@Override
	protected void setUp() throws Exception {
		startDate = DateUtil.createDate(2000, 1, 1);
	}

	@Test
	public void testCreateDate() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		assertEquals(2000, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
	}

}
