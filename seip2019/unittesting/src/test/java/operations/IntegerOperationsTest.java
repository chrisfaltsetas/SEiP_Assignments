package operations;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerOperationsTest {
    IntegerOperations intOps = new IntegerOperations();
    
    @Test
    public void test_reverseSign_positive() {
        Assert.assertTrue(intOps.reverseSign(3) < 0);
    }
    
    @Test
    public void test_reverseSign_negative() {
        Assert.assertTrue(intOps.reverseSign(-23) > 0);
    }
    
    @Test
    public void test_reverseSign_zero() {
        Assert.assertTrue(intOps.reverseSign(0) == 0);
    }
    
    @Test
    public void test_add_validValues() {
        Assert.assertEquals(727, intOps.add(604, 124));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_add_negativeValues() {
        intOps.add(223, -2);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_add_overflowException() {
        intOps.add(223, Integer.MAX_VALUE - 222);
    }
    
    @Test
    public void test_powerOfTwo_zero() {
        Assert.assertEquals(1, intOps.powerOfTwo(0));
    }
    
    @Test
    public void test_powerOfTwo_one() {
        Assert.assertEquals(2, intOps.powerOfTwo(1));
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void test_powerOfTwo_negativeException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("-54 is not a positive integer.");
        intOps.powerOfTwo(-54);
    }
    
    @Test
    public void test_powerOfTwo_overflowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("31^2 causes an integer overflow.");
        intOps.powerOfTwo(31);
    }
}
