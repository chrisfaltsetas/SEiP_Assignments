package com.seip.analyzer;

/**
 * @author chrisfaltsetas
 * 
 * This class follows the Factory pattern as the Factory
 * and creates Analyzers depending on the type of the analyzer.
 * StringAnalyzer for "string" type and RegexAnalyzer for "regex" type.
 */
public class AnalyzerFactory {
    
    /**
     * Creates and returns an Analyzer based on the given type.
     * The default analyzer is with regex
     * @param type String type of Analyzer
     * @return Analyzer depending on the type given
     */
    public Analyzer createAnalyzer(String type) {
        Analyzer analyzer;
        if (type.equals("string")) {
            analyzer = new StringAnalyzer();
        } else {
            analyzer = new RegexAnalyzer();
        }
        return analyzer;
    }
}
