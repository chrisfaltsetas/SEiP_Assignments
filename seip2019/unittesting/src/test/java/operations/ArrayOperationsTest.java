package operations;

import org.junit.Assert;
import org.junit.Test;
import filehandlers.FileIO;

import static org.mockito.Mockito.*;

/**
 * Provides test cases for the operations of the class
 * ArrayOperations.
 * @author chrisfaltsetas
 *
 */
public class ArrayOperationsTest {
    // Mock FileIO readFile method
    FileIO io = mock(FileIO.class);
    // Mock IntegerOperations reverseSign method
    IntegerOperations intOps = mock(IntegerOperations.class);
    ArrayOperations arrayOps = new ArrayOperations(io, intOps);
    
    /**
     * A unit test for reversing an array of valid integers.
     * The readFile and reverseSign method dependencies are 
     * isolated by mocking them and predefining the results 
     * of all their calls we are planning to execute.
     */
    @Test
    public void test_reverseArray_Mocking_valid() {
        int[] testValues = {46,32,-11,34,5,-55,0,13,-11};
        String filepath = "src/test/resources/valid-numbers.txt"; 
        when(io.readFile(filepath)).thenReturn(testValues);
        
        when(intOps.reverseSign(46)).thenReturn(-46);
        when(intOps.reverseSign(32)).thenReturn(-32);
        when(intOps.reverseSign(-11)).thenReturn(11);
        when(intOps.reverseSign(34)).thenReturn(-34);
        when(intOps.reverseSign(5)).thenReturn(-5);
        when(intOps.reverseSign(-55)).thenReturn(55);
        when(intOps.reverseSign(0)).thenReturn(0);
        when(intOps.reverseSign(13)).thenReturn(-13);
        
        Assert.assertArrayEquals(new int[] {-46,-32,11,-34,-5,55,0,-13,11}, arrayOps.reverseArray(filepath));
    }
    
    /**
     * A test case for the exception caused by giving an empty
     * array for reversing.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_reverseArray_Mocking_empty() {
        String filepath = "returns/empty/array"; 
        when(io.readFile(filepath)).thenReturn(new int[] {});
        
        arrayOps.reverseArray(filepath);
    }
    
    /**
     * A test case for finding the biggest integer of a valid
     * integer array. The readFile method dependency is mocked.
     */
    @Test
    public void test_findMaxInFile_Mocking_valid() {
        int[] testValues = {46,32,-11,34,5,-55,0,13,-11};
        String filepath = "src/test/resources/valid-numbers.txt"; 
        when(io.readFile(filepath)).thenReturn(testValues);
        
        Assert.assertEquals(46, arrayOps.findMaxInFile(filepath));
    }
    
    /**
     * A test case for the exception caused by trying to find
     * the biggest value of an empty array. 
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_findMaxInFile_Mocking_empty() {
        int[] testValues = {};
        String filepath = "src/test/resources/empty.txt"; 
        when(io.readFile(filepath)).thenReturn(testValues);
        
        arrayOps.findMaxInFile(filepath);
    }
}
