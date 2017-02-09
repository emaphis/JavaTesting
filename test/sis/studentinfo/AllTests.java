package sis.studentinfo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({StudentTest.class,
	           CourseSessionTest.class,
	           DateUtilTest.class,
	           BasicGradingStrategyTest.class,
	           HonorsGradingStrategyTest.class})
public class AllTests {

}
