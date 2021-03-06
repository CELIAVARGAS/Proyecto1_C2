/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

import java.util.LinkedList;
import lexico.arbol;
import lexico.errores;

/**
 *
 * @author esmeralda
 */
public class lenguaje {

    String nombreLenguaje;
    LinkedList<arbol> arboles;// cada arbol tiene nombre de lexema y su automata
    LinkedList<tokensLeidos> listaTokensLeidos;// lexemas leidos
    LinkedList<errores> listaErrores ;
    
    public String getNombreLenguaje() {
        return nombreLenguaje;
    }

    public void setNombreLenguaje(String nombreLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
    }

    public LinkedList<arbol> getArboles() {
        return arboles;
    }

    public void setArboles(LinkedList<arbol> arboles) {
        this.arboles = arboles;
    }

    public LinkedList<tokensLeidos> getListaTokensLeidos() {
        return listaTokensLeidos;
    }

    public void setListaTokensLeidos(LinkedList<tokensLeidos> listaTokensLeidos) {
        this.listaTokensLeidos = listaTokensLeidos;
    }

    public LinkedList<errores> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(LinkedList<errores> listaErrores) {
        this.listaErrores = listaErrores;
    }

    public lenguaje(String nombreLenguaje, LinkedList<arbol> arboles, LinkedList<tokensLeidos> listaTokensLeidos, LinkedList<errores> listaErrores) {
        this.nombreLenguaje = nombreLenguaje;
        this.arboles = arboles;
        this.listaTokensLeidos = listaTokensLeidos;
        this.listaErrores = listaErrores;
    }



}
