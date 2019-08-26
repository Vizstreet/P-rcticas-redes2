/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.text.PDFTextStripper; 

/**
 *
 * @author josue
 */
public class pdfReader {
    
    private String message;
    private final dotEnv env;
    public pdfReader() {
        this.message = "";
        this.env = new dotEnv();
    }
    
    
     public String rute(String actual_path,String title,String type,boolean isAFile){
        FileNameExtensionFilter filter = new FileNameExtensionFilter(title, type);
        String rute;
        File d = new File(actual_path);
        try {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setDialogTitle(title);
        chooser.setCurrentDirectory(d);
        if(!isAFile) {
           chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int option = chooser.showOpenDialog(chooser);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = chooser.getSelectedFile();
            rute = f.getAbsolutePath();
            return rute;
            }
        }
        catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null,"You didnt select any pdf yet");
        }
        return null;
    }
    
    public String readFile(String file) throws IOException {
        String text = "";
        try (PDDocument document = PDDocument.load(new File(file))) {
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                text = stripper.getText(document);
            }
        }
        return text;
    }
    
    public ArrayList<String> getFilesOnDirectory(String directory) {
        File folder = new File(directory);
        String[] files = folder.list();
        ArrayList<String> pdfFiles = new ArrayList<>();
        String regex = "[a-zA-Z0-9_-]*.pdf$";
        if(files == null) {
            System.out.println("There´s no files on the directory");
            System.exit(0);
        }
        for (String file : files) {
            if (file.matches(regex)){
                pdfFiles.add(file);
            }
        }
        return pdfFiles;
    }
    
    public void write_file(Map<String,Integer> results[], ArrayList<String> filenames) throws FileNotFoundException, UnsupportedEncodingException{
        this.message = "";
        int index = 0;
        for(Map<String,Integer>result: results) {
            this.message += "filename: " + filenames.get(index++) +"\r\n";
            result.forEach((String key, Integer value)->{
                this.message += key + "," + value.toString() + "\r\n";
            });
            this.message += "#\r\n";
        }
         File out_file = new File(this.env.getOutFile());
        if(out_file.exists()) {
            out_file.delete();
        }
        File nuevo=new File(this.env.getOutFile());        
        try (PrintWriter fw = new PrintWriter(nuevo,"utf-8")) {
            fw.println(this.message);
            fw.close();
        }
        this.message = "";
        JOptionPane.showMessageDialog(null,"Ya hemos obtenido los resultados, en un momento se desplegará una pagina dónde podrá verlos");
        
    }
    
    public void write_file(Map<String,Integer> result, String filename) throws IOException{
        this.message = "";
        message += "filename: " + filename +"\r\n";
        result.forEach((String key,Integer value)->{
            this.message += key + "," + value.toString() + "\r\n";
        });
        this.message += "#";
        
        File out_file = new File(this.env.getOutFile());
        if(out_file.exists()) {
            out_file.delete();
        }
        File nuevo=new File(this.env.getOutFile());        
        try (PrintWriter fw = new PrintWriter(nuevo,"utf-8")) {
            fw.println(this.message);
            fw.close();
        }
        this.message = "";
        JOptionPane.showMessageDialog(null,"Ya hemos obtenido los resultados, en un momento se desplegará una pagina dónde podrá verlos");
    }
    
}
