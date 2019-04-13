package operations;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(intOps.add(604, 124), 728);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_add_negativeValues() {
        intOps.add(223, -2);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_add_overMaxValues() {
        intOps.add(223, Integer.MAX_VALUE - 222);
    }
}
