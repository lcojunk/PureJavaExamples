/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.WordDocsExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author odzhara-ongom
 */
public class Test1 {
    
    public static void simpleFileReading()throws IOException {
        JFileChooser chooser = new JFileChooser();        
        if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getSelectedFile().getName());
            FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
            XWPFDocument doc= new XWPFDocument(fis);
            XWPFWordExtractor extract = new XWPFWordExtractor(doc);
            System.out.println(extract.getText()); 
            
        }
    }

    public static void simplepartsReading()throws IOException {
        JFileChooser chooser = new JFileChooser();        
        if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getSelectedFile().getName());
            FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
            XWPFDocument doc= new XWPFDocument(fis);
            XWPFWordExtractor extract = new XWPFWordExtractor(doc);
            //System.out.println(extract.getText());
            List <XWPFParagraph> pList= doc.getParagraphs();
            List <XWPFTable> tList= doc.getTables();
                    
            System.out.println("Number of Paragraphs="+pList.size());
            System.out.println("Number of Tables="+tList.size());
            List <XWPFTableRow> rList;
            List <XWPFTableCell> cList;
            List <XWPFParagraph> rcpList;
            int tCount=0, rCount=0, cCount=0, rcpCount=0, dummCounter=0;
            WordReference wordReference=new WordReference();
            for (XWPFTable t:tList ){                
                rList=t.getRows();
                rCount=0; cCount=0; rcpCount=0;
                System.out.println("Table Nr."+(tCount++));
                for (XWPFTableRow r:rList){
                    cList=r.getTableCells();
                    cCount=0; rcpCount=0;
                    System.out.println("Row Nr."+(rCount++));
                    for (XWPFTableCell c:cList) {
                        rcpList=c.getParagraphs();
                        rcpCount=0;
                        System.out.println("Cell Nr."+(cCount++));
                        System.out.println("Cell Text: "+c.getText());
                        System.out.println("Nr of Tables: "+c.getTables().size());
                        for (XWPFParagraph rcp:rcpList) {
                            System.out.println("Par Nr."+(rcpCount++)+" Paragraphtext="+ rcp.getText());
                        }
                        for (XWPFTable t1:c.getTables()) {
                            for (XWPFTableRow r1:t1.getRows()) {
                                for (XWPFTableCell c1:r1.getTableCells()) {
                                    System.out.println("DC Nr."+dummCounter+" Cell Text: "+c1.getText());
                                    switch (dummCounter) {
                                        case 0: wordReference.kundenLogo=c1.getText(); break;
                                        case 1: wordReference.kundenprofil=c1.getText(); break;
                                        case 2: wordReference.ausgangslage=c1.getText(); break;
                                        case 3: wordReference.losung=c1.getText(); break;
                                        case 4: wordReference.ergebnis=c1.getText(); break;
                                        case 5: wordReference.kunde=c1.getText(); break;
                                        case 6: wordReference.projektname=c1.getText(); break;
                                        case 7: wordReference.kundenstatement=c1.getText(); break;
                                        case 8: wordReference.statementBei=c1.getText(); break;
                                        case 9: wordReference.flisstext=c1.getText(); break;
                                        default:;
                                    }
                                    dummCounter++;
                                }
                            }
                            
                        } 
                    }
                }
            }
            System.out.println(wordReference.toString(1));
            
        }
    }
   
    public static WordReference getWordReference() throws IOException {
        WordReference wordReference=new WordReference();
        JFileChooser chooser = new JFileChooser();        
        if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getSelectedFile().getName());
            FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
            XWPFDocument doc= new XWPFDocument(fis);
            XWPFWordExtractor extract = new XWPFWordExtractor(doc);
            //System.out.println(extract.getText());
            List <XWPFParagraph> pList= doc.getParagraphs();
            List <XWPFTable> tList= doc.getTables();
                    
//            System.out.println("Number of Paragraphs="+pList.size());
//            System.out.println("Number of Tables="+tList.size());
            List <XWPFTableRow> rList;
            List <XWPFTableCell> cList;
            List <XWPFParagraph> rcpList;
            int tCount=0, rCount=0, cCount=0, rcpCount=0, dummCounter=0;
            
            for (XWPFTable t:tList ){                
                rList=t.getRows();
                rCount=0; cCount=0; rcpCount=0;
 //               System.out.println("Table Nr."+(tCount++));
                for (XWPFTableRow r:rList){
                    cList=r.getTableCells();
                    cCount=0; rcpCount=0;
    //                System.out.println("Row Nr."+(rCount++));
                    for (XWPFTableCell c:cList) {
                        rcpList=c.getParagraphs();
                        rcpCount=0;
 //                       System.out.println("Cell Nr."+(cCount++));
 //                       System.out.println("Cell Text: "+c.getText());
 //                       System.out.println("Nr of Tables: "+c.getTables().size());
                        for (XWPFParagraph rcp:rcpList) {
                           // System.out.println("Par Nr."+(rcpCount++)+" Paragraphtext="+ rcp.getText());
                        }
                        for (XWPFTable t1:c.getTables()) {
                            for (XWPFTableRow r1:t1.getRows()) {
                                for (XWPFTableCell c1:r1.getTableCells()) {
                                    //System.out.println("DC Nr."+dummCounter+" Cell Text: "+c1.getText());
                                    switch (dummCounter) {
                                        case 0: wordReference.kundenLogo=c1.getText(); break;
                                        case 1: wordReference.kundenprofil=c1.getText(); break;
                                        case 2: wordReference.ausgangslage=c1.getText(); break;
                                        case 3: wordReference.losung=c1.getText(); break;
                                        case 4: wordReference.ergebnis=c1.getText(); break;
                                        case 5: wordReference.kunde=c1.getText(); break;
                                        case 6: wordReference.projektname=c1.getText(); break;
                                        case 7: wordReference.kundenstatement=c1.getText(); break;
                                        case 8: wordReference.statementBei=c1.getText(); break;
                                        case 9: wordReference.flisstext=c1.getText(); break;
                                        default:;
                                    }
                                    dummCounter++;
                                }
                            }
                            
                        } 
                    }
                }
            }
            //System.out.println(wordReference.toString(1));
            
        }
        return wordReference;
    }
    
    public static void main(String[] args) throws IOException {
        simpleFileReading();
        //System.out.println(getWordReference().toString(1));
    }
}
