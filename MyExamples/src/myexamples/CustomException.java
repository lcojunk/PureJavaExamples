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
public class CustomException extends Exception {

    private static final long serialVersionUID = 1997753363232107009L;

    private Exception parentException;

    public Exception getParentException() {
        return parentException;
    }

    public void setParentException(Exception parentException) {
        this.parentException = parentException;
    }

    public CustomException addParentException(Exception parentException) {
        this.parentException = parentException;
        return this;
    }

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
