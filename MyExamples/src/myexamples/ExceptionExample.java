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
public class ExceptionExample {

    public static void main(String[] args) {
//        try {
//            testException(null);
//        } catch (CustomException e) {
//            e.printStackTrace();
//        }
        try {
            double a = testDivByNullException(5.0, 0.0);
            System.out.println("a=" + a);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------");
            e.getParentException().printStackTrace();
        }
    }

    public static void testException(String string) throws CustomException {
        if (string == null) {
            throw new CustomException("The String value is null");
        }
    }

    public static double testDivByNullException(double up, double down) throws CustomException {
        try {
            Double d = null;
            Double result = up / down * d;
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (new CustomException("Division by null in testDivByNullException")).addParentException(e);
        }
    }
}
