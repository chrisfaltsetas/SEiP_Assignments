package com.seip.facade;

import java.util.ArrayList;
import java.util.List;
import com.seip.analyzer.Analyzer;
import com.seip.analyzer.AnalyzerFactory;
import com.seip.utilities.FileIOUtilities;

/**
 * 
 * @author chrisfaltsetas
 * Has the role of the Facade class in the Facade pattern.
 * Runs the source code analyzer with specific settings.
 */
public class CodeAnalyzerFacade {

    private List<String> readSourceCode(String filepath) {
        List<String> lines = FileIOUtilities.readFile(filepath);
        return lines;
    }
    
    private int[] calculateMetrics(List<String> lines, String type) {
        int[] metrics = new int[3];
        Analyzer analyzer = new AnalyzerFactory().createAnalyzer(type);
        metrics[0] = analyzer.getLinesOfCode(lines);
        metrics[1] = analyzer.getNoClasses(lines);
        metrics[2] = analyzer.getNoMethods(lines);
        return metrics;
    }
    
    private void writeCSV(int[] metrics) {
        StringBuilder csvLine = new StringBuilder("");
        if (metrics.length > 0) {
            for (int i = 0; i < metrics.length - 1; i++) {
                csvLine.append(String.valueOf(metrics[i]));
                csvLine.append(",");
            }
            csvLine.append(String.valueOf(metrics[metrics.length - 1]));
        }
        List<String> lines = new ArrayList<String>();
        lines.add(csvLine.toString());
        FileIOUtilities.writeFile("./metrics.csv", lines);
    }

    /**
     * Receives the filepath of the source code and the type of analysis.
     * After reading the file, it calculates the metrics and writes them 
     * in a metrics.csv file.
     * @param filepath String The path of the source code file
     * @param type String The type of analysis
     */
    public void run(String filepath, String type) {
        List<String> lines = readSourceCode(filepath);
        int[] metrics = calculateMetrics(lines, type);
        writeCSV(metrics);
    }
}
