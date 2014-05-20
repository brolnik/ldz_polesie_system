/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rola
 */
public class DateFormatter {

    public static Date string2date(final String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date outputDate = null;

        try {
            outputDate = dateFormat.parse(date);
        } catch (ParseException ex) {
            System.out.println("Exception thrown during date parsing ... " + ex.getMessage());
        }
        
        return outputDate;
    }

}
