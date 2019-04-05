package com.seip.analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chrisfaltsetas
 * Analyzes a Java source file and calculates metrics with regex analysis.
 * Follows the Strategy pattern as a ConcreteStrategy.
 * Is a concrete object of the Product role.
 */
public class RegexAnalyzer implements Analyzer {

    /**
     * Receives a List of lines and removes the from the list the ones that are Java comments.
     * @param contents List of Strings
     * @return List of String without Java comments
     */
    public List<String> cleanUp(List<String> contents) {
        int counter = 0;
        List<Integer> comments = new ArrayList<Integer>();
        String wholeCode = "";
        for (String line : contents) {
            line = line.trim();
            wholeCode = wholeCode + line + "\n";
        }
        wholeCode = wholeCode.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        String[] lines = wholeCode.split("\n");
        List<String> cleanContents = new ArrayList<String>();
        for (String line : lines) {
            cleanContents.add(line);
            if (line.trim().isEmpty()) {
                comments.add(counter);
            }
            counter++;
        }
        for (int i = cleanContents.size() - 1; i >= 0; i--) {
            if (comments.contains(i)) {
                cleanContents.remove(i);
            }
        }
        return cleanContents;
    }
    
    /**
     * Receives a list of strings and returns the number of actual Java code lines.
     * @param contents List of Strings
     * @return number of Java lines of code
     */
    public int getLinesOfCode(List<String> contents) {
        contents = cleanUp(contents);
        int loc = contents.size();
        return loc;
    }

    /**
     * Receives a list of strings and returns the number of Java classes contained.
     * @param contents List of Strings
     * @return number of Java classes
     */
    public int getNoClasses(List<String> contents) {
        contents = cleanUp(contents);
        int noClasses = 0;
        boolean checkNext = false;
        for (String line : contents) {
            if (checkNext) {
                if (line.matches("\\{.*")) {
                    noClasses++;
                }
            }
            if (line.matches(".* class .*[A-Z].*")) {
                if (line.matches(".* class .*[A-Z].*\\{")) {
                    noClasses++;
                } else {
                    checkNext = true;
                }
            }
        }
        return noClasses;
    }

    /**
     * Receives a list of strings and returns the number of Java methods contained.
     * @param contents List of Strings
     * @return number of Java methods
     */
    public int getNoMethods(List<String> contents) {
        contents = cleanUp(contents);
        int noMethods = 0;
        boolean checkNext = false;
        for (String line : contents) {
            line = line.trim();
            if (checkNext) {
                if (line.matches("\\{.*")) {
                    noMethods++;
                }
            }
            String[] specialWords = {"if", "else", "for", "while", "do", 
                    "switch", "case", "try", "catch", "finally", "return", "package", "import"};
            boolean maybeMethod = true;
            for (int i = 0; i < specialWords.length; i++) {
                String regex = specialWords[i] + ".*";
                if (line.matches(regex)) {
                    maybeMethod = false;
                }
            }
            if (line.matches(".*if.*")) {
                maybeMethod = false;
            }
            if (maybeMethod) {
                if (line.matches(".*\\w* \\w*\\(.*\\).*")) {
                    if (line.matches(".*\\w* \\w*\\(.*\\).*\\{")) {
                        noMethods++;
                    } else {
                        checkNext = true;
                    }
                }
            }
        }
        return noMethods;
    }
}
