/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testrest;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author aco-ec-029
 */
public class Test {

    public static void main(String[] args) throws IOException {
//        Long fecha1 = 1518720501L;
//        Date fechaInicio = new Date(fecha1 * 1000);
//        Date fechaActual = new Date();
//        String response = "";
//        if (fechaInicio.getDate() > fechaActual.getDate()) {
//            response = "Fecha 1 mayor";
//        } else if (fechaInicio.getDate() < fechaActual.getDate()) {
//            response = "Fecha 1 menor";
//        } else if (fechaInicio.getDate() == fechaActual.getDate()) {
//            response = "fecha igual";
//        }
//        System.out.println(response);
//        System.out.println("fechaInicio: " + fechaInicio.getDate());
//        System.out.println("fechaActual: " + fechaActual.getDate());

//        LocalDate a = LocalDate.ofEpochDay(fecha1);
//        LocalDate b = LocalDate.ofEpochDay(fechaActual.getTime());
//        if (fecha1 > fechaActual.getTime() / 1000) {
//            response = "Fecha 1 mayor";
//        } else if (fecha1 < fechaActual.getTime()) {
//            response = "Fecha 1 menor";
//        } else if (fecha1 == fechaActual.getTime()) {
//            response = "fecha igual";
//        }
        Boolean response = null;
        final Long startDate = 1519317356L * 1000;
        final Long endDate = 1521995760L * 1000;

        final Calendar finalDate = new GregorianCalendar();
        finalDate.setTimeInMillis(endDate);
        int diaFinal = finalDate.get(finalDate.DATE);
        int diaFinalMes = finalDate.get(finalDate.MONTH) + 1;
        int diaFinalAnio = finalDate.get(finalDate.YEAR);

        final Calendar initialDate = new GregorianCalendar();
        initialDate.setTimeInMillis(startDate);
        int diaInicial = initialDate.get(initialDate.DATE);
        int diaInicialMes = initialDate.get(initialDate.MONTH) + 1;
        int diaInicialAnio = initialDate.get(initialDate.YEAR);

        final Calendar actualDate = new GregorianCalendar();
        int diaActual = actualDate.get(actualDate.DATE);
        int diaActualMes = actualDate.get(actualDate.MONTH) + 1;
        int diaActualAnio = actualDate.get(actualDate.YEAR);
        
//        if (diaInicialAnio >= diaActualAnio) {
//            if (diaInicialMes >= diaActualMes) {
//                if (diaInicialMes == diaActualMes) {
//                    if (diaInicial >= diaActual) {
//                        if (diaFinalMes >= diaInicialMes) {
//                            if (diaFinal < diaInicial) {
//                                System.out.println("Dia final es menor que dia inicial");
//                            } else if (diaFinal >= diaInicial) {
//                                System.out.println("----- exito  1--------");
//                            }
//                        } else if (diaFinalMes < diaInicialMes) {
//                            System.out.println("Mes final menor que mes inicial");
//                        }
//                    } else if (diaInicial < diaActual) {
//                        System.out.println("dia inicial menor a dia actual");
//                    }
//                } else if (diaInicialMes > diaActualMes) {
//                    if (diaFinalMes >= diaInicialMes) {
//                        if (diaFinal < diaInicial) {
//                            System.out.println("Dia final es menor que dia inicial");
//                        } else if (diaFinal >= diaInicial) {
//                            System.out.println("----- exito  1--------");
//                        }
//                    } else if (diaFinalMes < diaInicialMes) {
//                        System.out.println("Mes final menor que mes inicial");
//                    }
//                }
//            } else if (diaInicialMes < diaActualMes) {
//                System.out.println("Mes inicial menor a Mes actual");
//            }
//        } else if(diaInicialAnio < diaActualAnio) {
//            System.out.println("Anio inicio es menor que anio actual");
//        }

        System.out.println("Fecha inicio " + diaInicial);
        System.out.println("Fecha inicial mes: " + diaInicialMes);
        System.out.println("Fecha inicial anio: " + diaInicialAnio);
        System.out.println("------------------------");
        System.out.println("Fecha final " + diaFinal);
        System.out.println("Fecha final Mes: " + diaFinalMes);
        System.out.println("Fecha final Anio: " + diaFinalAnio);
        System.out.println("-----------------------");
        System.out.println("Fecha actual " + diaActual);
        System.out.println("Fecha actual Mes: " + diaActualMes);
        System.out.println("Fecha actual Anio: " + diaActualAnio);
        Calendar cal1 = new GregorianCalendar(2000 + diaInicialAnio, diaInicialMes, diaInicial);
        Calendar cal2 = new GregorianCalendar(2000 + diaActualAnio, diaActualMes, diaActual);
        Calendar cal3 = new GregorianCalendar(2000 + diaFinalAnio, diaFinalMes, diaFinal);
        System.out.println(cal1.compareTo(cal2));
        int compareDItoDA = cal1.compareTo(cal2);
        int compareDItoDF = cal3.compareTo(cal1);

        if (compareDItoDA == 0 || compareDItoDA == 1) {
            if (compareDItoDF == -1) {
                System.out.println("Dia final menor dia inicial");
            } else if (compareDItoDF == 0 || compareDItoDF == 1){
              System.out.println("exito");  
            }
        } else if (compareDItoDA == -1) {
            System.out.println("dia inicial menor a dia actual");
        }
        
        Date fecha = new Date();
        System.out.println("------------------------------");
        System.out.println("Fecha date: " + fecha.getTime() / 1000);
    }
}
