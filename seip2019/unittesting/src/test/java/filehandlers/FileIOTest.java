package filehandlers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Provides test cases for the file reading method
 * of the FileIO class.
 * @author chrisfaltsetas
 *
 */
public class FileIOTest {
    FileIO io = new FileIO();
    
    /**
     * A test case for reading a file containing
     * valid input numbers.
     */
    @Test
    public void test_readFile_valid() {
        String filepath = "src/test/resources/valid-numbers.txt";
        
        int[] expected = new int[9];
        expected[0] = 46;
        expected[1] = 32;
        expected[2] = -11;
        expected[3] = 34;
        expected[4] = 5;
        expected[5] = -55;
        expected[6] = 0;
        expected[7] = 13;
        expected[8] = -11;
        
        Assert.assertArrayEquals(expected, io.readFile(filepath));
    }
    
    /**
     * A test case for the exception caused by
     * reading a file containing invalid input numbers.
     */
    @Test (expected = NumberFormatException.class)
    public void test_readFile_invalid() {
        String filepath = "src/test/resources/invalid-numbers.txt";
        io.readFile(filepath);
    }
    
    /**
     * A test case for the exception caused by trying
     * to read a file that does not exist in the given filepath
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_readFile_notFound() {
        io.readFile("this/is/not/a/valid/filepath");
    }
}