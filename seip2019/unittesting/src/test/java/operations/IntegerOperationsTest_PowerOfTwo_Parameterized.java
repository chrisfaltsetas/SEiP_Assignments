package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;

import operations.IntegerOperations;

/**
 * A test class that implements a Parameterized test
 * for the IntegerOperations powerOfTwo method. 
 * @author agkortzis, chrisfaltsetas
 */
@RunWith(Parameterized.class)
public class IntegerOperationsTest_PowerOfTwo_Parameterized {
    
    // the value is the id of each parameter
    @Parameter (value = 0) 
    public int power;
    @Parameter (value = 1)
    public int product;
    
    IntegerOperations intOps = new IntegerOperations();
    
    /*
     * The following method generates the input values 
     * for the tests. 
     */
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{7,128},{0,1},{3,8},{30,1073741824},{10,1024},{1,2},{4,16}};
        return Arrays.asList(data);
    }
    
    /*
     * A unit test that is executed for each pair of 
     * parameters. 
     */
    @Test
    public void testPowerOfTwoWithNormalCases() {
        Assert.assertEquals(product, intOps.powerOfTwo(power));
    }
}