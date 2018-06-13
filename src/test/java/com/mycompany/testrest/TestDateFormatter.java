/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testrest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author aco-ec-029
 */
public class TestDateFormatter {

    public static void main(String[] args) {
        final Long date = 1517843916L;
        final Calendar creationAudienceDate = new GregorianCalendar();
        creationAudienceDate.setTimeInMillis(date * 1000);
        
        String stringDate = null;
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        stringDate = d.format(creationAudienceDate.getTime());
        System.out.println("fecha: " + stringDate);
        
    }
}
