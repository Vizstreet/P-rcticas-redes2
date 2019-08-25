/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;
import java.util.Map;

/**
 *
 * @author josue
 */
public class thread {
    
    private void generalFunction(String text, String[] stop_words) {
        textProcessing processor = new textProcessing();
        List<String> clean_text = processor.processText(text, stop_words);
        Map<String,Integer> dictionary = processor.createDictionary(clean_text);
        dictionary.forEach((key, value) -> 
        System.out.println(key + "-->" + value.toString()));
    }
    
}
