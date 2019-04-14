package operations;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Provides test cases for simple integer operations
 * of the IntegerOperations class.
 * @author chrisfaltsetas
 *
 */
public class IntegerOperationsTest {
    IntegerOperations intOps = new IntegerOperations();
    
    /**
     * A unit test that checks a valid positive input and
     * expects its opposite as a result
     */
    @Test
    public void test_reverseSign_positive() {
        Assert.assertTrue(intOps.reverseSign(3) == -3);
    }
    
    /**
     * A unit test that checks a valid negative input and
     * expects its opposite as a result
     */
    @Test
    public void test_reverseSign_negative() {
        Assert.assertTrue(intOps.reverseSign(-23) == 23);
    }
    
    /**
     * A unit test that checks a valid positive input of
     * the number 0 and expects 0 as a result
     */
    @Test
    public void test_reverseSign_zero() {
        Assert.assertTrue(intOps.reverseSign(0) == 0);
    }
    
    /**
     * A unit test that examines the add method with normal 
     * input values and expects their sum as a result 
     */
    @Test
    public void test_add_validValues() {
        Assert.assertEquals(728, intOps.add(604, 124));
    }
    
    /**
     * A unit test that examines the add method with valid
     * input values and expects their sum as a result.
     * This case examines the border case where the sum
     * expected equals the MAX_VALUE of an integer. 
     */
    @Test
    public void test_add_validValuesBorder() {
        Assert.assertEquals(Integer.MAX_VALUE, intOps.add(604, Integer.MAX_VALUE - 604));
    }
    
    /**
     * A test case for the exceptions caused when
     * one or more input values are negative
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_add_negativeValues() {
        intOps.add(223, -2);
    }
    
    /**
     * A test case for the exceptions caused when
     * the result of the addition doesn't fit 
     * in an Integer variable.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_add_overflowException() {
        intOps.add(223, Integer.MAX_VALUE - 222);
    }

    /**
     * Two test cases for the exceptions caused when
     * trying to raise a negative integer to the power of two.
     * Testing the exceptions is performed with a @Rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void test_powerOfTwo_negativeException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("-54 is not a positive integer.");
        intOps.powerOfTwo(-54);
    }
    // TODO do we need to reset "thrown"(@before) or create a new Rule?
    @Test
    public void test_powerOfTwo_overflowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("31^2 causes an integer overflow.");
        intOps.powerOfTwo(31);
    }
}
