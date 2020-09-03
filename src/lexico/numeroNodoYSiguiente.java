/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

/**
 *
 * @author esmeralda
 */
public class numeroNodoYSiguiente {
    
    nodo n;
    boolean respuesta;

    public numeroNodoYSiguiente(nodo n, boolean respuesta) {
        this.n = n;
        this.respuesta = respuesta;
    }

    public nodo getN() {
        return n;
    }

    public void setN(nodo n) {
        this.n = n;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
}
