/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testrest;

/**
 *
 * @author aco-ec-029
 */
public class TestOrder {
    
    public static void main(String[] args) {
        //Valores que tiene el arreglo desordenado.
        int arreglo[] = {8, 6, 7, 2, 1, 8, 6, 8, 7, 1, 9, 7, 7, 3};
        int arregloOrdenado[] = burbuja(arreglo);

        //imprimimos el arreglo ordenado.
        for (int i = 0; i < arregloOrdenado.length; i++) {
            System.out.println(arregloOrdenado[i]);
        }
    }

    public static int[] burbuja(int[] arreglo) {
        int auxiliar;
        int[] arregloOrdenado;
        for (int i = 1; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }
    
//    public static void Insercion(int[] vector) {
//        for (int i = 1; i < vector.length; i++) {
//            int aux = vector[i];
//            int j;
//            for (j = i - 1; j > = 0 && vector[j] > aux; j--) {
//                vector[j + 1] = vector[j];
//            }
//            vector[j + 1] = aux;
//        }
//    }
}
