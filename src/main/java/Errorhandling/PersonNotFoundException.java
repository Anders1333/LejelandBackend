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
public class PersonNotFoundException extends Exception implements Serializable {
  
      private static final long serialVersionUID = 1L;

    public PersonNotFoundException() {
        super();
    }

    public PersonNotFoundException(String msg) {
        super(msg);
    }

    public PersonNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
    
    
}
