/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author esmeralda
 */
public class mostrarDatos {

    public void mostrarAutomata(arbol a) {
        automataL automata = a.getAfdARbol();
        LinkedList<filaTablaAFD> tablaAFD = automata.getTablaAFD();
        if (tablaAFD.isEmpty()) {
            System.out.println("No hay datos del automata ");
        } else {
   //         tablaAFD = tablaAFD.stream().distinct().collect(Collectors.toList());
//                    stream().distinct().collect(Collectors.toList());

            System.out.println("------ FILAS " + tablaAFD.size() + "\n ");
            for (int i = 0; i < tablaAFD.size(); i++) {
                estado estado1 = tablaAFD.get(i).getEstadoInicial();
                estado1.getNumeros();
                estado estado2 = tablaAFD.get(i).getEstadoFInal();

                tablaSimbolos fila = tablaAFD.get(i).getSimbolo();
                boolean isNumero = fila.isEsNumero();
                boolean isString = fila.isEsString();
                boolean isChar = fila.isEsCadena();
                boolean isSaltoLinea = fila.isEsSaltoLinea();
                boolean isTabulador = fila.isEsTabulador();
                boolean isEspacioBlanco = fila.isEsEspacioBlanco();

                System.out.print("\t ESTADO INICIO---> " + estado1.getNombreEstado()+"-"+estado1.getNumeros());

                if (isNumero == true) {
                    System.out.print("\t SIMBOLOS ---> numero ");
                } else if (isString == true) {
                    System.out.print("\t SIMBOLOS ---> String ");
                } else if (isChar == true) {
                    System.out.print("\t SIMBOLOS ---> " + fila.getValString());
                } else if (isSaltoLinea == true) {
                    System.out.print("\t SIMBOLOS ---> salto linea");
                } else if (isTabulador == true) {
                    System.out.print("\t SIMBOLOS ---> tabulador ");
                } else if (isEspacioBlanco == true) {
                    System.out.print("\t SIMBOLOS ---> espacio ");
                }


                System.out.print(" \t ESTADO FINAL---> " + estado2.getNombreEstado()+"-"+estado2.getNumeros());
                System.out.println("\t ES ACEPTACION --->"+estado2.isEsFInal());
            }
        }

    }

    public void mostrarArbol() {
    }
}
