/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odzhara-ongom
 */
public class ReflectionExample {
    public static void run(String[] args) {
        Date date = new Date();
        Class c = date.getClass();
        Method [] methods=c.getMethods();
        Method method;
        int n;
        for (int i =0; i<methods.length; i++){
            method=methods[i];
            n=method.getParameterCount();
            
            Parameter [] parameters=method.getParameters();
            System.out.println(i+": "+methods[i].getName()+"; "+n);
            for (int j=0;j<parameters.length;j++){
                System.out.println(parameters[j].getType().getName());
            }
            
        }
    }
    
    public static void testInvoke(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        InterfaceImpl ii=new InterfaceImpl();
        
        Method method=ii.getClass().getMethod("hello", null);
        method.invoke(ii, null);
        method=ii.getClass().getMethod("hello", new Class[]{String.class});
        method.invoke(ii, new String[]{"Leon"});
        
    }
   
    public static void main(String[] args) {
       for (int i=0;i<5;i++){
           System.out.println(new InterfaceImpl().getId());
       }
    }
}
