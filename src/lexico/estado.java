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
public class estado {

    String nombreEstado;
    LinkedList<Integer> numeros;
    boolean esFInal ;

    
    
    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public LinkedList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(LinkedList<Integer> numeros) {
        this.numeros = numeros;
    }

    public boolean isEsFInal() {
        return esFInal;
    }

    public void setEsFInal(boolean esFInal) {
        this.esFInal = esFInal;
    }

    public estado(String nombreEstado, LinkedList<Integer> numeros) {
        this.nombreEstado = nombreEstado;
        this.numeros = numeros;
    }
    

}
