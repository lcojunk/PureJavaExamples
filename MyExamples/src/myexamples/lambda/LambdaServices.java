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
public class LambdaServices {
    //classic java implementation
    private AcceptDummy serviceNotNull= new AcceptDummyImpl();
    //implementation with annonymous class
    private AcceptDummy serviceOdd=new AcceptDummy() {
        @Override
        public boolean accept(DummyClass d) {
            return d.isOdd();
        }
    };
    //Lambda operation
    private AcceptDummy serviceEven=(DummyClass d)->{return d.isEven(); };
    //short lambda operation
    private AcceptDummy serviceTen=DummyClass::isTen;

    public AcceptDummy getServiceNotNull() {
        return serviceNotNull;
    }

    public AcceptDummy getServiceOdd() {
        return serviceOdd;
    }

    public AcceptDummy getServiceEven() {
        return serviceEven;
    }

    public AcceptDummy getServiceTen() {
        return serviceTen;
    }

    
}
