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
public class filaTablaAFD {
    //estado inicial
    //simbolo
    //estado final

    estado estadoInicial;
    tablaSimbolos simbolo;
    estado estadoFInal;

    public filaTablaAFD(estado estadoInicial, tablaSimbolos simbolo, estado estadoFInal) {
        this.estadoInicial = estadoInicial;
        this.simbolo = simbolo;
        this.estadoFInal = estadoFInal;
    }

    public estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public tablaSimbolos getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(tablaSimbolos simbolo) {
        this.simbolo = simbolo;
    }

    public estado getEstadoFInal() {
        return estadoFInal;
    }

    public void setEstadoFInal(estado estadoFInal) {
        this.estadoFInal = estadoFInal;
    }


    
}
