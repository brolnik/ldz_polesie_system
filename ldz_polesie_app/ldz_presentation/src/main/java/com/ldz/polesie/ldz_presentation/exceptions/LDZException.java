/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.exceptions;

/**
 *
 * @author Rola
 */
public class LDZException extends Exception {

    public LDZException() {
    }

    public LDZException(String message) {
        super(message);
    }

    public LDZException(String message, Throwable cause) {
        super(message, cause);
    }

    public LDZException(Throwable cause) {
        super(cause);
    }  
}
