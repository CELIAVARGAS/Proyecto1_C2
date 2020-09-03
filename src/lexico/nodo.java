/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.LinkedList;

/**
 *
 * @author esmeralda
 */
public class nodo {

    /*datos para calculo del nodo*/
    int numeroHoja;
    boolean anulable;
    LinkedList<Integer> primeraPos;
    LinkedList<Integer> ultimaPos;

    /*datos para forma*/
    boolean concatenacion; //1
    boolean o; //2 
    boolean unoMas; //3
    boolean ceroMas; //4
    boolean opcional; //5
    boolean esHoja; //6 
    boolean esAceptacion; //6 

    nodo nodoIzquierdo;
    nodo nodoDerecho;
    nodo nodoCentral;

    /*valor del nodo*/
    int valorNumero;
    String valorChar;

    boolean isNumero;
    boolean isString;
    boolean isChar;
    boolean isSaltoLinea;
    boolean isTabulador;
    boolean isEspacioBlanco;

    int contador;

    public int getNumeroHoja() {
        return numeroHoja;
    }

    public void setNumeroHoja(int numeroHoja) {
        this.numeroHoja = numeroHoja;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public LinkedList<Integer> getPrimeraPos() {
        return primeraPos;
    }

    public void setPrimeraPos(LinkedList<Integer> primeraPos) {
        this.primeraPos = primeraPos;
    }

    public LinkedList<Integer> getUltimaPos() {
        return ultimaPos;
    }

    public void setUltimaPos(LinkedList<Integer> ultimaPos) {
        this.ultimaPos = ultimaPos;
    }

    public boolean isConcatenacion() {
        return concatenacion;
    }

    public void setConcatenacion(boolean concatenacion) {
        this.concatenacion = concatenacion;
    }

    public boolean isO() {
        return o;
    }

    public void setO(boolean o) {
        this.o = o;
    }

    public boolean isUnoMas() {
        return unoMas;
    }

    public void setUnoMas(boolean unoMas) {
        this.unoMas = unoMas;
    }

    public boolean isCeroMas() {
        return ceroMas;
    }

    public void setCeroMas(boolean ceroMas) {
        this.ceroMas = ceroMas;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    public boolean isEsHoja() {
        return esHoja;
    }

    public void setEsHoja(boolean esHoja) {
        this.esHoja = esHoja;
    }

    public nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public nodo getNodoCentral() {
        return nodoCentral;
    }

    public void setNodoCentral(nodo nodoCentral) {
        this.nodoCentral = nodoCentral;
    }

    public int getValorNumero() {
        return valorNumero;
    }

    public void setValorNumero(int valorNumero) {
        this.valorNumero = valorNumero;
    }

    public String getValorChar() {
        return valorChar;
    }

    public void setValorChar(String valorChar) {
        this.valorChar = valorChar;
    }

    public boolean isIsNumero() {
        return isNumero;
    }

    public void setIsNumero(boolean isNumero) {
        this.isNumero = isNumero;
    }

    public boolean isIsString() {
        return isString;
    }

    public void setIsString(boolean isString) {
        this.isString = isString;
    }

    public boolean isIsChar() {
        return isChar;
    }

    public void setIsChar(boolean isChar) {
        this.isChar = isChar;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean isIsSaltoLinea() {
        return isSaltoLinea;
    }

    public void setIsSaltoLinea(boolean isSaltoLinea) {
        this.isSaltoLinea = isSaltoLinea;
    }

    public boolean isIsTabulador() {
        return isTabulador;
    }

    public void setIsTabulador(boolean isTabulador) {
        this.isTabulador = isTabulador;
    }

    public boolean isIsEspacioBlanco() {
        return isEspacioBlanco;
    }

    public void setIsEspacioBlanco(boolean isEspacioBlanco) {
        this.isEspacioBlanco = isEspacioBlanco;
    }

    public boolean isEsAceptacion() {
        return esAceptacion;
    }

    public void setEsAceptacion(boolean esAceptacion) {
        this.esAceptacion = esAceptacion;
    }

    /*datos para forma
    boolean concatenacion; //1
    boolean o; //2 
    boolean unoMas; //3
    boolean ceroMas; //4
    boolean opcional; //5
    boolean esHoja; //6 
     */
    public void insertarNodoAceptacion(int contador) {
        System.out.println("se inserto nodo aceptacion");
        setEsAceptacion(true);
        setContador(contador);
        setAnulable(false);
        setNumeroHoja(contador);

        LinkedList<Integer> primeraPosNodoA = new LinkedList<>();
        LinkedList<Integer> ultimaPosNodoA = new LinkedList<>();
        primeraPosNodoA.clear();
        ultimaPosNodoA.clear();
        primeraPosNodoA.add(contador);
        ultimaPosNodoA.add(contador);

        setPrimeraPos(primeraPosNodoA);
        setUltimaPos(ultimaPosNodoA);

    }

    /*Insertar Nodos*/
    public void insertarNodoConcatenacion(nodo nodoIzq, nodo nodoDerec) {
        System.out.println("se inserto nodo concatenacion");
        setConcatenacion(true);
        setNodoIzquierdo(nodoIzq);
        setNodoDerecho(nodoDerec);
    }

    public void insertarNodoO(nodo nodoIzq, nodo nodoDerec) {
        System.out.println("se inserto nodo o");

        setO(true);
        setNodoIzquierdo(nodoIzq);
        setNodoDerecho(nodoDerec);
    }

    public void insertarNodoCeroMas(nodo nodoUnico) {
        System.out.println("se inserto nodo * ");
        setCeroMas(true);
        setAnulable(true);
        setNodoCentral(nodoUnico);
    }

    public void insertarNodoOpcion(nodo nodoUnico) {
        System.out.println("se inserto nodo ?");
        setOpcional(true);
        setAnulable(true);
        setNodoCentral(nodoUnico);
    }

    public void insertarNodoUnoMas(nodo nodoUnico) { //lleva el anulable del nodo
        System.out.println("se inserto nodo +");
        setUnoMas(true);
        setNodoCentral(nodoUnico);
    }

    public void insertarNodohoja(int valDato, String caracteres, int contador) {
        System.out.println("se inserto nodo hoja");
        /*SI ES HOJA 
        ANULABLE = TRUE
        PRIMERAPOS = 0
        ULTIMAPOS =0
         */

        setEsHoja(true);
        setContador(contador);

        LinkedList<Integer> primeraPosNodoA = new LinkedList<>();
        LinkedList<Integer> ultimaPosNodoA = new LinkedList<>();
        primeraPosNodoA.clear();
        ultimaPosNodoA.clear();

        primeraPosNodoA.add(contador);
        ultimaPosNodoA.add(contador);

        setPrimeraPos(primeraPosNodoA);
        setUltimaPos(ultimaPosNodoA);

        setNumeroHoja(contador);

        System.out.println("numero hoja " + getNumeroHoja());
        System.out.println("primeros " + getPrimeraPos());
        System.out.println("ultimos " + getUltimaPos());
        switch (valDato) {
            case 1://numero
                System.out.println("Nodo numero");
                setIsNumero(true);
                setAnulable(false);
                break;

            case 2://string
                System.out.println("Nodo string");
                setAnulable(false);
                setIsString(true);
                break;

            case 3://\n
                System.out.println("Nodo saltoLinea");
                setAnulable(false);

                setIsSaltoLinea(true);

                break;
            case 4://\b
                setAnulable(false);
                System.out.println("Nodo espacioBlanco");

                setIsEspacioBlanco(true);
                break;
            case 5://\t
                System.out.println("Nodo tabulacion");
                setAnulable(false);

                setIsTabulador(true);
                break;

            case 6://char
                setAnulable(false);
                System.out.println("Nodo caracter");
                setValorChar(caracteres);
                System.out.println(getValorChar());
                setIsChar(true);
                break;
        }
    }
}
