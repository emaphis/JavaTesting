package chess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BoardTest.class,
			   pieces.AllTests.class,
			   util.AllTests.class})
public class AllTests {

}
