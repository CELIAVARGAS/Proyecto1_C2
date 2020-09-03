/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author esmeralda
 */
public class automataL {
    //ya se ha calculado los primeros, ultimos y siguientes de cada nodo del arbol

    LinkedList<estado> estadosRevisados;
    LinkedList<estado> estadosSinRevisar;
    LinkedList<filaTablaAFD> tablaAFD;


    //tiene estados revisados
    //estados sin revisar
    //tabla de simbolos
    public automataL(LinkedList<estado> estadosRevisados, LinkedList<estado> estadosSinRevisar, LinkedList<filaTablaAFD> tablaAFD) {
        this.estadosRevisados = estadosRevisados;
        this.estadosSinRevisar = estadosSinRevisar;
        this.tablaAFD = tablaAFD;
    }

    public LinkedList<estado> getEstadosRevisados() {
        return estadosRevisados;
    }

    public void setEstadosRevisados(LinkedList<estado> estadosRevisados) {
        this.estadosRevisados = estadosRevisados;
    }

    public LinkedList<estado> getEstadosSinRevisar() {
        return estadosSinRevisar;
    }

    public void setEstadosSinRevisar(LinkedList<estado> estadosSinRevisar) {
        this.estadosSinRevisar = estadosSinRevisar;
    }

    public LinkedList<filaTablaAFD> getTablaAFD() {
        return tablaAFD;
    }

    public void setTablaAFD(LinkedList<filaTablaAFD> tablaAFD) {
        this.tablaAFD = tablaAFD;
    }

}
