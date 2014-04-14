package com.analyzer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.fail;
import org.junit.Before;

public class DocumentAnalyzerHelperTest {
    
    public DocumentAnalyzerHelperTest() {
    }
    
    @Before
    public void setUp() {
    }

    @org.junit.Test
    public void testGetHighestOccuringTerms() throws IOException {
        
        try{
        System.out.println("testGetHighestOccuringTerms");
        String document = readFile(new File("test-file.txt"));
        //System.out.println(document);
        List<String> list = DocumentAnalyzerHelper.getHighestOccuringTerms(document, 3);
        System.out.println("Tokens List : Start");
        for(String str:list){
            System.out.println(str);
        }
        System.out.println("Tokens List : End");
        
        }catch(Exception ex){
            ex.printStackTrace();
            fail("Test failed");
        }
        
    }
    
    
    String readFile(File file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    } finally {
        br.close();
    }
}
}
