/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisEntrada;

import java.util.LinkedList;
import lexico.arbol;
import lexico.automataL;
import lexico.estado;
import lexico.filaTablaAFD;
import lexico.tablaSimbolos;
import static p1_comp2.P1_COMP2.listaLeguajes;
import sintactico.tokensLeidos;

/**
 *
 * @author esmeralda
 */
public class evaluacionLexica {
    //leemos caracter por caracter, evaluando primero como numeros o letras, seguido verificar si algun caracter es similar 

    public void analisisLenguajeSeleccionado(String entrada, String nombreLenguaje) {
        for (int i = 0; i < listaLeguajes.size(); i++) {
            String nombre = listaLeguajes.get(i).getNombreLenguaje();

            if (nombre.equals(nombreLenguaje)) {
                busquedaDatosParaAnalisis(i, entrada);
                break;
            } else {

            }
        }
    }

    public void busquedaDatosParaAnalisis(int posicion, String entrada) {
        LinkedList<arbol> arboles = listaLeguajes.get(posicion).getArboles();
        LinkedList<tokensLeidos> tokensL = new LinkedList<>();

        int posicionCaracter = 0;

        //una vez obtenido el conjunto de arboles, se procede a evaluar cada caracter leido 
        for (int i = 0; i < arboles.size(); i++) {
            automataL automata = arboles.get(i).getAfdARbol();
//            analisisDeAutomata(automata, posicionCaracter, entrada);
        }
    }

    public void funcionRecursivaAutomata(LinkedList<arbol> arboles, int posicionCaracter, String entrada, LinkedList<tokensLeidos> tokensL, tokensLeidos token) {
        for (int i = 0; i < arboles.size(); i++) {//analizamos cada automata
            automataL automata = arboles.get(i).getAfdARbol();
            String nombreLexema = arboles.get(i).getNombreLexema();

            //si todos los automatas devuelven false entonces es un erro lexico
            analisisDeAutomata(automata, posicionCaracter, entrada, "estado1", tokensL, token, nombreLexema);
        }
    }

    public void analisisDeAutomata(automataL automata, int posicionCaracter, String entrada,
            String nombreEstado, LinkedList<tokensLeidos> tokensL, tokensLeidos token, String nombreLexema) {
        LinkedList<filaTablaAFD> filasAFD = automata.getTablaAFD();
        ///buscamos que filas tienen ese estado y evaluaremos cada fila para ver si coincide con el simbolo a evaluar
        for (int i = 0; i < filasAFD.size(); i++) {
            String nombreE = filasAFD.get(i).getEstadoInicial().getNombreEstado();
            if (nombreE.equals(nombreEstado)) {
                //analisamos la fila 
            } else {
                //seguir buscando
            }
        }

    }

    public void analisisFilaE1(filaTablaAFD fila, int posicion, String entrada, String datoGuardado,
            LinkedList<tokensLeidos> tokensL, tokensLeidos token, String nombreLexema) {
        estado e1 = fila.getEstadoInicial();
        tablaSimbolos simbolo = fila.getSimbolo();
        estado e2 = fila.getEstadoFInal();

        boolean esString = simbolo.isEsString();
        boolean esInt = simbolo.isEsNumero();
        boolean esChar = simbolo.isEsCadena();
        boolean esSaltoLinea = simbolo.isEsSaltoLinea();
        boolean esEspacio = simbolo.isEsEspacioBlanco();
        boolean esTb = simbolo.isEsTabulador();

        //primero evaluar si coincide con un char , sino entonces puede ser un id, num , espacios
        if (esChar == true) {

            //obtenemos el valor del char para ver si coincide 
            String valroCHar = simbolo.getValString();

            int indice = valroCHar.length();

            //avanzamos esa cantidad en  la entrada 
            String cadena = entrada.substring(posicion, posicion + indice - 1);
            if (cadena.equals(valroCHar)) {
                //si coincide la entrada entonces unimos a lo que viene anterior 
                datoGuardado = datoGuardado + valroCHar;
                //evaluar si este es un estado final
                if (e2.isEsFInal() == true) {
                    //creamos el objeto
                    token = new tokensLeidos(nombreLexema, datoGuardado);
                } else {
                }
                //avanzamos al siguiente estado 

            } else {
                //guardar dato anterior en la lista auxiliar, limpiamos el valor de DatoGuardado, mandamos el mismo indice para evaluar en siguientes filas
                tokensL.add(token);
            }
        } else {
            //evaluar si es string, int , espacios.
            if (esString == true) {
                //evaluamos si esta en el rango de a-z
                char dato = entrada.charAt(posicion);
                int numero = entrada.charAt(posicion);
                if ((numero >= 65 && numero <= 90) || (numero >= 97 && numero <= 122)) {// A-Z a-z

                } else {
                    //no hay simbolo  que coincida con este estado, guardar datoAnterior si es que es aceptado
                }
            } else if (esInt == true) {//evaluaos si esta en rango de 0-9
                int numero = entrada.charAt(posicion);
                if (numero >= 48 && numero <= 57) {// 0-9
                    //me muevo al estado2
                } else {
                }
            } else if (esSaltoLinea == true) { //evaluamos si coincide
            } else if (esEspacio == true) {//evaluamos si coincide
            } else if (esTb == true) {//evaluamos si coincide
            } else {
            }

        }
    }

}
