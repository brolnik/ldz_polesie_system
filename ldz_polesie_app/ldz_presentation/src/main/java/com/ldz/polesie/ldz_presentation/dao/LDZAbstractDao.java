/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ldz.polesie.ldz_presentation.dao;

/**
 *
 * @author Rola
 * @param <T>
 */
public interface LDZAbstractDao <T> {
 
   public <T> void createOrUpdate(T t);
   public T findByUniqueValue(String elemName, Object value);
    
}
