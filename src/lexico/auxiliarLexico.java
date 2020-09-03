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
public class auxiliarLexico {

    public boolean verificarNombreEnLista(LinkedList<String> lista, String dato) {
        boolean encontrado = false;
        if (lista.isEmpty()) {//si es vacia la lista entonces se agrega el dat 
            encontrado = false;
            lista.add(dato);
        } else {
            if (lista.contains(dato)) {//si la lista contiene el nombre entonces no lo agregamos 
                encontrado = true;
            } else {//la lista no contiene el nombre
                encontrado = false;
                lista.add(dato);
            }
        }
        return encontrado;
    }

}
