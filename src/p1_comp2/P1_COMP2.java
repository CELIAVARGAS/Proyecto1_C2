/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_comp2;

import analisis.generadorLexicoSintactico;
import java.util.LinkedList;
import lexico.nodo;
import sintactico.lenguaje;

/**
 *
 * @author esmeralda
 */
public class P1_COMP2 {

    /**
     * @param args the command line arguments
     */
    public static LinkedList<lenguaje> listaLeguajes = new LinkedList<>();

    public static void main(String[] args) {
        //Limpiamos lista de lenguajes 
        listaLeguajes.clear();

        generadorLexicoSintactico a = new generadorLexicoSintactico();
        a.Compiladores_C();

        pantallas.PRINCIPAL p = new pantallas.PRINCIPAL();
        p.setVisible(true);

    }

}
