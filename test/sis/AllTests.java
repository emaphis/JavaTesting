package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({sis.studentinfo.AllTests.class,
	           sis.report.AllTests.class,
	           examples.AllTests.class,
	           sis.summer.AllTests.class})
public class AllTests {

}
