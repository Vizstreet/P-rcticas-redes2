/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
/**
 *
 * @author josue
 */
public class dotEnv {
    
    private String  stopWordsFile;
    private String processTextPython;
    private String initialPath;
    public dotEnv() {
        this.setStopWords();
        this.setPythonFiles();
        this.setInitialPath();
    }
    
    private void setStopWords() {
        this.stopWordsFile = "C:\\Users\\josue\\Documents\\NetBeansProjects\\wordsResume\\Utils\\stopWords.txt";
    }
    public  String getStopWordsFile() {
        return this.stopWordsFile;
    }
    
    private void setPythonFiles() {
        this.processTextPython = "C:\\Users\\josue\\Documents\\NetBeansProjects\\wordsResume\\Utils\\Python\\processText.py";
    }
    public String getProcessTextPythonFile() {
        return this.processTextPython;
    }
    private void setInitialPath() {
        this.initialPath = "C:\\Users\\josue\\Documents\\NetBeansProjects";
    }
    public String getInitialPath() {
        return this.initialPath;
    }
    
}
