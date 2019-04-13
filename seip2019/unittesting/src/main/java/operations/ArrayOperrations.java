package operations;

import filehandlers.FileIO;

/***
 * A class that performs operations on Arrays
 * @author agkortzis
 */
public class ArrayOperrations {
	private FileIO fileIo;
	private IntegerOperations intOprs; 
	
	/***
	 * Default Constructor is private to prevent 
	 * creating an a class instance without injecting
	 * the required dependencies.
	 */
	private ArrayOperrations() {}
		
	/***
	 * Parameterized Constructor
	 * @param fileIo
	 * @param integerOperations
	 */
	public ArrayOperrations(FileIO fileIo, IntegerOperations integerOperations) {
		this.fileIo = fileIo;
		this.intOprs = integerOperations;
	}
	
	/***
	 * Reads the content of a file (numbers) and finds the max
	 * @param filepath of the file that contains the numbers
	 * @return the largest number
	 * @throws IllegalArgumentException if the array of numbers is empty
	 */
	public int findMaxInFile(String filepath) {
		int max = Integer.MIN_VALUE;
		int[] numbers = this.fileIo.readFile(filepath);

		if (numbers.length < 1) {
			throw new IllegalArgumentException("The array should not be empty.");
		}

		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}

		return max;
	}

	/**
	 * Reverses the signs of the elements in a given array read from a given file. 
	 * The sign reverse is performed by the IntegerOperations
	 * @param filepath the path of the file 
	 * @return an array of integers with reversed signs
	 * @throws IllegalArgumentException when the array is empty
	 */
	public int[] reverseArray(String filepath) {
		int[] numbers = this.fileIo.readFile(filepath);
		int[] reversed = new int[numbers.length];
		
		if (numbers.length < 1) {
			throw new IllegalArgumentException("Cannot reverse the signs of an empty array");
		}
		
		for(int i=0; i<numbers.length; i++) {
			reversed[i] = this.intOprs.reverseSign(numbers[i]);
		}
		
		return reversed;
	}
	
}
