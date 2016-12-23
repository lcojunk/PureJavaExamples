/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.WordDocsExamples;

import java.io.IOException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 *
 * @author odzhara-ongom
 */
public class Test2Docx4j {
    public static void main(String[] args) throws IOException, InvalidFormatException, Docx4JException{
        //WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File("HelloWord1.docx"));
        
        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
        wordMLPackage.save(new java.io.File("HelloWord1.docx"));
    }
}
