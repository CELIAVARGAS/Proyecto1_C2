/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 *
 * @author esmeralda
 */
public class tablaSimbolos {

    String valChar;
    boolean esCadena;
    boolean esNumero;
    boolean esString;
    boolean esEspacioBlanco;
    boolean esTabulador;
    boolean esSaltoLinea;

    final int esCad = 1;
    final int esNum = 2;
    final int esStr = 3;
    final int esEsp = 4;
    final int esTab = 5;
    final int esSaltoL = 6;

    public String getValString() {
        return valChar;
    }

    public void setValString(String valString) {
        this.valChar = valString;
    }

    public boolean isEsCadena() {
        return esCadena;
    }

    public void setEsCadena(boolean esCadena) {
        this.esCadena = esCadena;
    }

    public boolean isEsNumero() {
        return esNumero;
    }

    public void setEsNumero(boolean esNumero) {
        this.esNumero = esNumero;
    }

    public boolean isEsString() {
        return esString;
    }

    public void setEsString(boolean esString) {
        this.esString = esString;
    }

    public boolean isEsEspacioBlanco() {
        return esEspacioBlanco;
    }

    public void setEsEspacioBlanco(boolean esEspacioBlanco) {
        this.esEspacioBlanco = esEspacioBlanco;
    }

    public boolean isEsTabulador() {
        return esTabulador;
    }

    public void setEsTabulador(boolean esTabulador) {
        this.esTabulador = esTabulador;
    }

    public boolean isEsSaltoLinea() {
        return esSaltoLinea;
    }

    public void setEsSaltoLinea(boolean esSaltoLinea) {
        this.esSaltoLinea = esSaltoLinea;
    }

    public void insertarDato(int tipo, String valorChar) {
        switch (tipo) {

            case esCad://es char
                setValString(valorChar);
                setEsCadena(true);
                break;

            case esNum:
                setEsNumero(true);
                break;

            case esStr:
                setEsString(true);
                break;

            case esEsp:
                setEsEspacioBlanco(true);
                break;

            case esTab:
                setEsTabulador(true);
                break;

            case esSaltoL:
                setEsSaltoLinea(true);

                break;

        }
    }

    @Override
    public String toString() {
        return "tablaSimbolos{" + "valChar=" + valChar + ", esCadena=" + esCadena + ", esNumero=" + esNumero + ", esString=" + esString + ", esEspacioBlanco=" + esEspacioBlanco + ", esTabulador=" + esTabulador + ", esSaltoLinea=" + esSaltoLinea + ", esCad=" + esCad + ", esNum=" + esNum + ", esStr=" + esStr + ", esEsp=" + esEsp + ", esTab=" + esTab + ", esSaltoL=" + esSaltoL + '}';
    }
    
    
    
}
