package filehandlers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * A class that offers file handling operations.
 * It doesn't follow the "Utility" class strict definition 
 * that was introduced during the Design Patterns sessions.
 * @author agkortzis
 */
public class FileIO {
	/***
	 * This is a simple method that opens and reads a 
	 * file line by line.
	 * @param filepath required path to the file
	 * @return a int[] that contains the content of the file
	 * @throws IllegalArgumentException when the file does not exist in the given path
	 * @throws NumberFormatException when the input number is in an invalid form
	 */
	public int[] readFile(String filepath)  {
		List<Integer> linesList = new ArrayList<>();
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
			String line;
			while((line = reader.readLine()) != null) {
				linesList.add(Integer.parseInt(line));
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File " + filepath + " does not exist");
		} catch (IOException e) { 
			throw new NumberFormatException();
		}
		
		int[] linesArray = new int[linesList.size()];
		for (int index=0; index<linesList.size(); index++) {
			linesArray[index] = linesList.get(index);
		}
			
		return linesArray;
	}

}
