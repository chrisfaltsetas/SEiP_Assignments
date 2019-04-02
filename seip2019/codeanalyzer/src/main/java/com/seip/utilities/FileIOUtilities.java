package com.seip.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chrisfaltsetas
 * 
 * Utility class that implements File input and output operations.
 * The methods implemented are the one that reads a given file and the
 * one that writes in a given file.
 */
public final class FileIOUtilities {
    private FileIOUtilities() {
        // private Constructor to prevent class instantiation
    }
    
    /**
     * Receives the path of the file to be read and with the help 
     * of a BufferedReader, it adds every line of the file in a List, as a String,
     * and returns that List.
     * @param filepath String containing the path of the file
     * @return
     */
    public static List<String> readFile(String filepath) {
        BufferedReader reader = null;
        List<String> fileLines = new ArrayList<String>();
        try {
            File file = new File(filepath);
            String encoding = "UTF8";
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            
            String line = reader.readLine();
            while (line != null) {
                fileLines.add(line);
                line = reader.readLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // Ignore exception because reader was not initialized
            }
        }
        return fileLines;
    }
    
    /**
     * Receives a List of String that contain the lines to be written
     * in the file that is also received as a file path and with the help of
     * a BufferedWriter, it writes every item of the List in a new line.
     * @param filepath String containing the path of the file
     * @param content List of Strings containing the lines to be written in the file
     */
    public static void writeFile(String filepath, List<String> content) {
        if (content != null && !content.isEmpty()) {
            BufferedWriter writer = null;
            File file = new File(filepath);
            String encoding = "UTF8";
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
                for (String line : content) {
                    writer.write(line);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Ignore exception because writer was not initialized
                }
            }
            
        }
    }
}
