package studentinfo;

import org.junit.Test;
import java.util.*;
import junit.framework.*;
import studentinfo.DateUtil;

public class DateUtilTest extends TestCase {

	@Test
	public void testCreateDate() {
		Date date = new DateUtil().createDate(2000, 1, 1);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		assertEquals(2000, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.JANUARY, calendar.get(calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
	}

}
