/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.boluscalc.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ASUS
 */
public class FileHelper{
    
    public String[] read(String path){
        BufferedReader reader = null;
        String[] settings= new String[4];
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            
            int i = 0;
            while((line = reader.readLine())!= null){                
                settings[i]= line;
                
                i++;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return settings;    
    }
    public void write(String[] settings, String path){
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter(path));
            
            for(String i : settings){
                writer.write(i);
                writer.newLine();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
