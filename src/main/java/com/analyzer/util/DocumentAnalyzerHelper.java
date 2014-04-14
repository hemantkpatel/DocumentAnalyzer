package com.analyzer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentAnalyzerHelper {
    
    public static List<String> getHighestOccuringTerms(String doc, int numberOfTerms){
        
        List<String> highestOccuringTermsList = new ArrayList<>();
        
        //We will return a blank list if document is blank or numberOfTerm is less than 1.
        if(doc!=null && !doc.isEmpty() && numberOfTerms>0){
            Map<String,TermFrequency> tokenMap = new HashMap<>();
            String tokens[] = doc.split("[\\s\\-,.']+");
            
            //System.out.println("String tokenized");
            for(String token:tokens){
              //System.out.println(token);  
              TermFrequency termFrequency = tokenMap.get(token)==null?new TermFrequency(token):tokenMap.get(token);
              
              termFrequency.incrementFrequency();
              
              tokenMap.put(token,termFrequency);
            }
            
            List<TermFrequency> termFrequencyList = new ArrayList<>();
            termFrequencyList.addAll(tokenMap.values());
            Collections.sort(termFrequencyList,new TermFrequency());
            
            for(TermFrequency termFrequency:termFrequencyList){
                System.out.println(termFrequency.getTerm()+"  +  "+termFrequency.getFrequency());
            }
            
            for(TermFrequency termFrequency:termFrequencyList.subList(0, termFrequencyList.size()<numberOfTerms?termFrequencyList.size():numberOfTerms)){
                highestOccuringTermsList.add(termFrequency.getTerm());
            }
            
        }
        return highestOccuringTermsList;
    }

}
