package com.analyzer.util;

import java.util.Comparator;

public class TermFrequency implements Comparator<TermFrequency>{

    private String term;
    private Integer frequency;

    public TermFrequency(){
        
    }

    public TermFrequency(String term) {
        this(term,0);
    }
    
    public TermFrequency(String term, Integer frequency) {
        this.term = term;
        this.frequency = frequency;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compare(TermFrequency o1, TermFrequency o2) {
        return o2.getFrequency()-o1.getFrequency();
    }

    public void incrementFrequency() {
        frequency++;
    }

}
