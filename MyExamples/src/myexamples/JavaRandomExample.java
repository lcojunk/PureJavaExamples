/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.util.Random;

/**
 *
 * @author odzhara-ongom
 */
public class JavaRandomExample {
    
    public static void main(String[] args) {
        showHistogramm(100000000, 20);
    }
    
    public static void showHistogramm(long numberOfTests, int maxValue){
        long [] histogramm = new long[maxValue];
        for (int i=0; i<histogramm.length; i++){
            histogramm[i]=0;
        }
        Random random=new Random();
        int value;
        for (long testNumber=0; testNumber<numberOfTests; testNumber++){
            value=random.nextInt(maxValue);
            histogramm[value]++;
        }
        long max=0;
        for (int i=0; i<histogramm.length; i++){
            if(max<histogramm[i]) max=histogramm[i];
        }
        for (int i=0; i<histogramm.length; i++){
            System.out.println(i+": "+histogramm[i]+"; "+histogramm[i]*100.0/max);
        }
    }
}
