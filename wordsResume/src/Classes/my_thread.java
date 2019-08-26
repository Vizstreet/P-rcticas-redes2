/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author josue
 */
public class my_thread implements Runnable{
    
    private final String text;
    private final String[] stop_words;
    private final String[] words_to_search;
    private final Map<String, Integer> results;
    private int total_of_words;
    
    public my_thread(String text, String[] stop_words, String[] words_to_search) {
        this.text = text;
        this.stop_words = stop_words;
        this.words_to_search = words_to_search;
        results = new HashMap<>();
    }
    
    public void run() {
        textProcessing processor = new textProcessing();
        List<String> clean_text = processor.processText(this.text, this.stop_words);
        Map<String,Integer> dictionary = processor.createDictionary(clean_text);
        this.total_of_words = dictionary.size();
        this.find_words(dictionary);
    }
    
    private void find_words(Map<String, Integer>dictionary) {
        for(String word: this.words_to_search) {
            if(dictionary.get(word)!= null) {
                this.results.put(word,dictionary.get(word));
            } else {this.results.put(word,0);}
        }
    }
    
    public int get_total_words() { return this.total_of_words; }
    public Map<String,Integer> get_results() { return this.results; }
    
}
