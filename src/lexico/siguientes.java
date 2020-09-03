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
public class siguientes {

    int numero;
    LinkedList<Integer> primerosC2;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LinkedList<Integer> getPrimerosC2() {
        return primerosC2;
    }

    public void setPrimerosC2(LinkedList<Integer> primerosC2) {
        this.primerosC2 = primerosC2;
    }

    @Override
    public String toString() {
        return "siguientes{" + "numero=" + numero + ", primerosC2=" + primerosC2 + '}';
    }
    


}
