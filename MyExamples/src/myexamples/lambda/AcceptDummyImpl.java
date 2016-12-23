/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.lambda;


public class AcceptDummyImpl implements AcceptDummy {

    @Override
    public boolean accept(DummyClass d) {
        return d!=null;
    }
    
}
