/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author odzhara-ongom
 */
public class ExceptionExample {

    public static void main(String[] args) {
        testThrowingnUncheckedException();

    }

    private static boolean throwCheckedException(boolean shouldThrow) throws IOException {
        if (shouldThrow) {
            throw new IOException(); //is checked exception
        }
        return shouldThrow;
    }

    private static boolean throwUncheckedException(boolean shouldThrow) {
        try {
            return throwCheckedException(shouldThrow);
        } catch (IOException e) {
            System.out.println("Checked exception is caught");
            throw new IllegalArgumentException("illegal argument in throwCheckedException", e);
        }
    }

    private static Connection getConnection() {
        return null;
    }

    private static void testThrowingCheckedException() throws SQLException {
        try (Connection connection = getConnection()) {

        }
        try {
            System.out.println("no exception:" + throwCheckedException(false));
            throwCheckedException(true);
        } catch (IOException e) {
            System.out.println("Exception is thrown");
        }
    }

    private static void testThrowingnUncheckedException() {
        try {
            System.out.println("unchecked exception:" + throwUncheckedException(true));
        } catch (IllegalArgumentException exception) {
            System.out.println("Unchecked Exception was caught:" + exception.getMessage());
        }
    }

    private static void testCustomException() {
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
