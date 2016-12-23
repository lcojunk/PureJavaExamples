/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.Entities;

/**
 *
 * @author odzhara-ongom
 */
public class MyPOJO extends Object{
    public String toString(int art){
        String result="";
        switch (art) {
            case 0: result=this.toString(); break;
            default: break;                
        }
        return result;
    }
}
