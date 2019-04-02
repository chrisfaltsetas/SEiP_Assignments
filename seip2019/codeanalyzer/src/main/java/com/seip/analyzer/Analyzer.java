package com.seip.analyzer;

import java.util.List;

public interface Analyzer {
    public int getLinesOfCode(List<String> contents);
    public int getNoClasses(List<String> contents);
    public int getNoMethods(List<String> contents);
}
