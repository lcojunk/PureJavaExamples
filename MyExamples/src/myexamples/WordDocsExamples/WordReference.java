/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.WordDocsExamples;

/**
 *
 * @author odzhara-ongom
 */
public class WordReference {
    String kundenLogo;
    String kundenprofil;
    String ausgangslage;
    String losung;
    String ergebnis;
    String kunde;
    String projektname;
    String kundenstatement;
    String statementBei;
    String flisstext;
    
    
    public String toString(int art){
        String result="";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="kundenLogo="+kundenLogo+"\n";
                    result+="kundenprofil="+kundenprofil+"\n";
                    result+="ausgangslage="+ausgangslage+"\n";
                    result+="losung="+losung+"\n";
                    result+="ergebnis="+ergebnis+"\n";
                    result+="kunde="+kunde+"\n";
                    result+="projektname="+projektname+"\n";
                    result+="kundenstatement="+kundenstatement+"\n";
                    result+="statementBei="+statementBei+"\n";
                    result+="flisstext="+flisstext+"\n";
                    break;
            default: break;                
        }
        return result;
    }
}
