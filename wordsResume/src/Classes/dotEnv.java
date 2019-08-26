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
    private String out_file;
    public dotEnv() {
        this.setStopWords();
        this.setPythonFiles();
        this.setInitialPath();
        this.setOutFilePath();
    }
    
    private void setStopWords() {
        this.stopWordsFile = "C:\\Users\\josue\\Documents\\GitHub\\P-rcticas-redes2\\wordsResume\\Utils\\stopWords.txt";
    }
    public  String getStopWordsFile() {
        return this.stopWordsFile;
    }
    
    private void setPythonFiles() {
        this.processTextPython = "C:\\Users\\josue\\Documents\\GitHub\\P-rcticas-redes2\\wordsResume\\Utils\\Python\\processText.py";
    }
    public String getProcessTextPythonFile() {
        return this.processTextPython;
    }
    private void setInitialPath() {
        this.initialPath = "C:\\Users\\josue\\Downloads\\pdf";
    }
    public String getInitialPath() {
        return this.initialPath;
    }
    private void setOutFilePath() {
        this.out_file = "C:\\Users\\josue\\Documents\\GitHub\\P-rcticas-redes2\\wordsResume\\Utils\\out.txt";
    }
    public String getOutFile() {
        return this.out_file;
    }
    
}
