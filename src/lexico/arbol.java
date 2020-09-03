/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this templa\te file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.LinkedList;

/**
 *
 * @author esmeralda
 */
public final class arbol {

    nodo nodoArbol;
    String nombreLexema;
    LinkedList<siguientes> numerosSiguiente;
    automataL afdARbol;

    public arbol(nodo nodoArbol, String nombreLexema, LinkedList<siguientes> numerosSiguiente, automataL afdARbol) {
        this.nodoArbol = nodoArbol;
        this.nombreLexema = nombreLexema;
        this.numerosSiguiente = numerosSiguiente;
        this.afdARbol = afdARbol;
    }

    public nodo getNodoArbol() {
        return nodoArbol;
    }

    public void setNodoArbol(nodo nodoArbol) {
        this.nodoArbol = nodoArbol;
    }

    public String getNombreLexema() {
        return nombreLexema;
    }

    public void setNombreLexema(String nombreLexema) {
        this.nombreLexema = nombreLexema;
    }

    public LinkedList<siguientes> getNumerosSiguiente() {
        return numerosSiguiente;
    }

    public void setNumerosSiguiente(LinkedList<siguientes> numerosSiguiente) {
        this.numerosSiguiente = numerosSiguiente;
    }

    public automataL getAfdARbol() {
        return afdARbol;
    }

    public void setAfdARbol(automataL afdARbol) {
        this.afdARbol = afdARbol;
    }
    


}
