package com.seip;

import com.seip.facade.CodeAnalyzerFacade;

/**
 * 
 * @author chrisfaltsetas
 * Has the role of the Client.
 * Uses the CodeAnalyzerFacade to analyze the source code of the given
 * file with the given type of analysis.
 */
public class CodeAnalyzerDemo {
    public static void main(String[] args) {
        String filepath = args[0];
        String type = args[1];
        CodeAnalyzerFacade analyzer = new CodeAnalyzerFacade();
        analyzer.run(filepath, type);
    }
}
