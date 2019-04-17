package operations;

/***
 * A class that performs operations on Integers
 * @author agkortzis
 */
public class IntegerOperations {
		
	/***
	 * A simple method that reverses the sign of an integer
	 * @param number the input integer number
	 * @return the integer number with the reversed sign
	 */
	public int reverseSign(int number) {
		return -number;
	}
	
	/**
	 * Adds two positive Integers
	 * @param x first positive Integer
	 * @param y second positive Integer 
	 * @return the results of the addition of the input Integers
	 * @throws IllegalArgumentException when one or 
	 * more input Integers are negative
	 * @throws IllegalArgumentException when the input Integers
	 * can cause an Integer overflow
	 */
	public int add(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Input numbers should be positive.");
		}

		if (y > Integer.MAX_VALUE - x) {
			throw new IllegalArgumentException("Cannot fit the result in an Integer.");
		}

		return x + y;
	}
	
	/***
	 * Calculates the power of two for a given power. For example: <br>
	 * 2^0=1, 2^1=2, 2^2=4, 2^3=8, etc,.
	 * @param number the 
	 * @return the result
	 * @throws IllegalArgumentException when the given power is a negative number
	 * @throws IllegalArgumentException when the given power is > 31 and thus, causes an integer overflow
	 */
	public int powerOfTwo(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(number + " is not a positive integer.");
		} else if(number > 30) {
			throw new IllegalArgumentException(number + "^2 causes an integer overflow.");
		}
		
		int product = 1;
		
		if(number == 0) {
			return 1;
		} else if(number == 1) {
			return 2;
		} else {
			for (int i=1; i<=number; i++) {
				product *= 2;
			}
		}
		
		return product;
	}
}
