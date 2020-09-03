/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;

import java.util.Arrays;

/**
 *
 * @author esmeralda
 */
public class auxiliar {

    public String quitarComillas(String dato) {
        String a = "0"; 
        System.out.println("dato " +dato);
        String[] caracteres = dato.split("\"");
        System.out.println("caracteres "+Arrays.toString(caracteres));
        if (caracteres.length >= 1) {
            if (caracteres[1].isEmpty()) {
                a = "0";
            } else {
                a = caracteres[1];
            }
        } else {
            a = "0";
        }
        System.out.println("Caracteres "+a);
        return a;
    }

}
