package com.seip.analyzer;

import java.util.List;

/**
 * 
 * @author chrisfaltsetas
 * Has the role of the "Product" in the Factory Pattern.
 */
public interface Analyzer {
    public int getLinesOfCode(List<String> contents);
    public int getNoClasses(List<String> contents);
    public int getNoMethods(List<String> contents);
}
