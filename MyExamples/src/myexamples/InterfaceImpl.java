/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

/**
 *
 * @author odzhara-ongom
 */
public class InterfaceImpl {
    private static long count=0;
    private long id=count;

    public InterfaceImpl() {
        count++;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        InterfaceImpl.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
    
    public String hello(String s) {
        System.out.println("hello, "+s+"!");
        return "hello, "+s+"!";
    }
}
