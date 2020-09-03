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
public class tablaAuxiliar {
  
    int numeroDelArreglo;
    nodo nodoHoja;

    public tablaAuxiliar(int numeroDelArreglo, nodo nodoHoja) {
        this.numeroDelArreglo = numeroDelArreglo;
        this.nodoHoja = nodoHoja;
    }

    
    
    public int getNumeroDelArreglo() {
        return numeroDelArreglo;
    }

    public void setNumeroDelArreglo(int numeroDelArreglo) {
        this.numeroDelArreglo = numeroDelArreglo;
    }

    public nodo getNodoHoja() {
        return nodoHoja;
    }

    public void setNodoHoja(nodo nodoHoja) {
        this.nodoHoja = nodoHoja;
    }
    
    
}
