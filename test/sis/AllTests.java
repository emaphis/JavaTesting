package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import examples.JavaExamplesTest;

@RunWith(Suite.class)
@SuiteClasses({sis.studentinfo.AllTests.class,
	           sis.report.AllTests.class,
	           JavaExamplesTest.class})
public class AllTests {

}
