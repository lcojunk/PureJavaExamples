/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.lambda;

/**
 *
 * @author odzhara-ongom
 */
public class DummyClass {
    private int id;

    public DummyClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isOdd(){
        return id%2!=0;
    }
    
    public boolean isEven(){
        return id%2==0;
    }

    public boolean isTen(){
        return id%10==0;
    }

    public void print(){
        System.out.println("id="+getId());
    }
    
    @Override
    public String toString(){
        return id+"";
    }
}
