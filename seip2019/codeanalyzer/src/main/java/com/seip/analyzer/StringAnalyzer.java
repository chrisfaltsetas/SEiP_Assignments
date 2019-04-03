package com.seip.analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chrisfaltsetas
 * Analyzes a Java source file and calculates metrics with String analysis.
 * Follows the Strategy pattern as a ConcreteStrategy.
 */
public class StringAnalyzer implements Analyzer {

    /**
     * Receives a List of lines and removes the from the list the ones that are Java comments.
     * @param contents List of Strings
     * @return List of String without Java comments
     */
    public List<String> cleanUp(List<String> contents) {
        int counter = 0;
        List<Integer> comments = new ArrayList<Integer>();
        boolean[] status = new boolean[2];
        for (String line : contents) {
            line = line.trim();
            if (line.isEmpty()) {
                comments.add(counter);
            } else {
                if (line.startsWith("//")) {
                    comments.add(counter);
                } else {
                    status = isBlockComment(line, status[1]);
                    if (status[0]) {
                        comments.add(counter);
                    }
                }
            }
            counter++;
        }
        for (int i = contents.size() - 1; i >= 0; i--) {
            if (comments.contains(i)) {
                contents.remove(i);
            }
        }
        return contents;
    }
    
    /**
     * Calculates if the line contains a Java Block comment and returns the status
     * of the current line (if it is a comment and if the code is currently in a block).
     * @param line String
     * @param inBlock boolean
     * @return boolean array of length 2 (index 0 isComment, index 1 inBlock)
     */
    public boolean[] isBlockComment(String line, boolean inBlock) {
        // Initialize isComment depending if the line is already in a Block Comment or not
        boolean isComment;
        if (inBlock) {
            isComment = true;
        } else {
            isComment = false;
        }
        
        if (line.contains("/*") && line.contains("*/")) {
            if (!line.endsWith("*/")) {
                if (line.lastIndexOf("/*") < line.lastIndexOf("*/")) {
                    isComment = false;
                    inBlock = false;
                } else {
                    inBlock = true;
                    if ((line.indexOf("/*") == line.lastIndexOf("/*")) && (line.indexOf("*/") == line.lastIndexOf("*/"))) {
                        if (line.lastIndexOf("/*") == line.lastIndexOf("*/") + 2) {
                            isComment = true;
                            // There is no point of this existing in code e.g. hello*//*there
                        } else {
                            isComment = false;
                        }
                    } else {
                        // Good luck with that
                    }
                }
            } else {
                inBlock = false;
                if (!line.startsWith("/*")) {
                    isComment = false;
                } else {
                    if (line.indexOf("*/") + 2 == line.lastIndexOf("/*")) {
                        isComment = true;
                        // There is no point of this existing in code e.g. /*hello*//*there*/
                    } else {
                        if ((line.indexOf("/*") == line.lastIndexOf("/*")) && (line.indexOf("*/") == line.lastIndexOf("*/"))) {
                            isComment = true;;
                        } else {
                            isComment = false;
                        }
                    }
                }
            }
        } else if (line.contains("/*") && !line.contains("*/")) {
            if (line.startsWith("/*")) {
                isComment = true;
            } else {
                isComment = false;
            }
            inBlock = true;
        } else if (!line.contains("/*") && line.contains("*/")) {
            if (line.endsWith("*/")) {
                isComment = true;
            } else {
                isComment = false;
            }
            inBlock = false;
        } else if (!line.contains("/*") && !line.contains("*/")) {
            //System.out.println(line + inBlock);
            if (inBlock == true) {
                isComment = true;
            } else {
                isComment = false;
            }
        }
        boolean[] status = new boolean[2];
        status[0] = isComment;
        status[1] = inBlock;
        return status;
    }

    public int getLinesOfCode(List<String> contents) {
        contents = cleanUp(contents);
        int loc = contents.size();
        return loc;
    }

    public int getNoClasses(List<String> contents) {
        contents = cleanUp(contents);
        return 0;
    }

    public int getNoMethods(List<String> contents) {
        // TODO Auto-generated method stub
        return 0;
    }

}
