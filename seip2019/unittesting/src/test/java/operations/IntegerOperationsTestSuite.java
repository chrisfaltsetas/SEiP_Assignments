package operations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * An class used as a holder of the @RunWith and @Suite 
 * annotations, necessary when someone needs to group
 * classes that include tests, for demonstrating Unit Testing.
 * @author agkortzis, chrisfaltsetas
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({IntegerOperationsTest.class, IntegerOperationsTest_PowerOfTwo_Parameterized.class})
public class IntegerOperationsTestSuite {
    /*
     * This class remains empty. Is used only as a holder 
     * of the above annotations.
     */
}
