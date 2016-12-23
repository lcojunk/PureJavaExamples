/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 * @author odzhara-ongom
 */
public class StringsFormattest {
    
    private static String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    
    
    
    
    public static void main(String[] args) throws IOException  {
        //String result="Hallo, %s! Ich freue mich %schen zu sehen";
        String result="Hello, %s %s!";
        String name="Leon";
        String sname="O";
        
        System.out.println(String.format(result, name, sname));
        
       // System.out.println("txt"+readFromFile("index.html"));
    }
}
