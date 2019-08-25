/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.io.File; 
import java.io.IOException; 
import java.util.ArrayList;
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
    
    public pdfReader() {}
    
    
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
            JOptionPane.showMessageDialog(null,"You didnt select any key yet");
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
    
}
