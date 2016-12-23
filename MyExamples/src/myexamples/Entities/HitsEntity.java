/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author odzhara-ongom
 */
public class HitsEntity {
    private long total=0;
    private double max_score=0;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public double getMax_score() {
        return max_score;
    }

    public void setMax_score(double max_score) {
        this.max_score = max_score;
    }
    
    public String toString(int art){
        String result="";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result="total="+total+"\n";
                    result+="max_score="+max_score+"\n";
                    break;
            default: break;                
        }
        return result;
    }
}
