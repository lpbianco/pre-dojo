package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testCompleteLine.class, testCreateGamer.class,
		testFileReader.class, testCreateLog.class })
public class AllTests {

}
