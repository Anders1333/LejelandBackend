/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errorhandling;

import java.io.Serializable;

/**
 *
 * @author Jonas
 */
public class ValidationErrorException extends Exception implements Serializable {
     private static final long serialVersionUID = 1L;

    public ValidationErrorException() {
        super();
    }

    public ValidationErrorException(String msg) {
        super(msg);
    }

    public ValidationErrorException(String msg, Exception e) {
        super(msg, e);
    }
}
