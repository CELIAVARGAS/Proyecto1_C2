/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.LinkedList;
import lexico.analisisAutomata;

/**
 *
 * @author esmeralda
 */
public final class analisisArbol {

    final int numConcatenacion = 0;
    final int numO = 1;
    final int numOpcional = 2;
    final int numUnoMas = 3;
    final int numCeroMas = 4;

    arbol arbolLenguaje;

    public arbol getArbolLenguaje() {
        return arbolLenguaje;
    }

    public void setArbolLenguaje(arbol arbolLenguaje) {
        this.arbolLenguaje = arbolLenguaje;
    }

    public void analisisArbol(arbol arbolLeng, LinkedList<tablaSimbolos> tablaSImbolos1, int contador) {
        /* recibimos arbol, lo analizamos , creamos el AFD, si los datos so correctos lo cargamos en lenguajes creados
        evaluamos nodo por nodo y obtenemos valores para calcular primeros, siguientes, 
         */

        //primero calculamoslos Primeros, ultimos, siguientes 
        nodo nodoA = arbolLeng.getNodoArbol();
        LinkedList<siguientes> listaSiguientes = arbolLeng.getNumerosSiguiente();
        analisisNodosCalculoDePyU(nodoA, listaSiguientes);
        analisisAutomata a = new analisisAutomata();
        automataL afd1 = arbolLeng.getAfdARbol();
//        a.mostrarArbol(nodoA);
        a.analisisInicial(arbolLeng, tablaSImbolos1, listaSiguientes, afd1, contador);
    }

    public void analisisNodosCalculoDePyU(nodo nodoA, LinkedList<siguientes> listaSiguientes) {
        /*verificar si -es  .  |  +  *  ? o una hoja , luego obtener datos
         */
        boolean concatenacion = nodoA.isConcatenacion();
        boolean barra = nodoA.isO();
        boolean opcional = nodoA.isOpcional();
        boolean unoMas = nodoA.isUnoMas();
        boolean ceroMas = nodoA.isCeroMas();
        boolean hoja = nodoA.isEsHoja();
        boolean aceptacion = nodoA.isEsAceptacion();

        if (concatenacion == true) {//obtenemos nodo hijoIzq, nodo hijoD
            //si el nodo iz o derecha es hoja obtenemos los primeros y siguientes para agregar al nodo , de lo contrario realizamos recursividad
            agregarPyUdeConcatenacionYbarra(nodoA, numConcatenacion, listaSiguientes);
        } else if (barra == true) {//obtenemos nodo hijoIzq, nodo hijoD
            agregarPyUdeConcatenacionYbarra(nodoA, numO, listaSiguientes);
        } else if (opcional == true) {//?
            agregarPyUdenodoA(nodoA, numOpcional, listaSiguientes);
        } else if (unoMas == true) {//+
            agregarPyUdenodoA(nodoA, numUnoMas, listaSiguientes);
        } else if (ceroMas == true) {//*
            agregarPyUdenodoA(nodoA, numCeroMas, listaSiguientes);
        } else if (hoja == true) {//hoja
            //como es hoja ya no se calcula ni anulable ni primeraPos/ultimasPos
        } else if (aceptacion == true) {//#
            //como es aceptacion ya no se calcula ni anulable ni primeraPos/ultimasPos
        }
    }

    public void agregarPyUdeConcatenacionYbarra(nodo nodoA, int tipo, LinkedList<siguientes> listaSiguientes) {

        nodo nodoIzquierdo = nodoA.getNodoIzquierdo();
        nodo nodoDerecho = nodoA.getNodoDerecho();

        boolean nodoIHoja = nodoIzquierdo.isEsHoja();
        boolean nodoDHoja = nodoDerecho.isEsHoja();

        if (nodoIHoja == true && nodoDHoja == true) {
            System.out.println("1. Ambos son hojas en PYU");
            obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
        } else if (nodoIHoja == true && nodoDHoja == false) {
            //llamamos funcion recursiva para nodoD 
            System.out.println("Solo c1 es hoja en PYU");
            analisisNodosCalculoDePyU(nodoDerecho, listaSiguientes);
            //obtenemos datos
            obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
        } else if (nodoIHoja == false && nodoDHoja == true) {
            //llamamos recursion para nodoIzq
            System.out.println("Solo c2 es hoja en PYU");
            analisisNodosCalculoDePyU(nodoIzquierdo, listaSiguientes);
            //obtenemos datos
            obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
        } else {
            System.out.println("niuno PYU");
            //lamamos recursion para ambos nodos
            analisisNodosCalculoDePyU(nodoIzquierdo, listaSiguientes);
            analisisNodosCalculoDePyU(nodoDerecho, listaSiguientes);
            //obtenemos datos
            obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
        }
    }

    /*        if (nodoIHoja == true) {
            if (nodoDHoja == true) {
                //obtenemos datos
                System.out.println("1. Ambos son hojas en PYU");
                obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
            } else {
                //llamamos funcion recursiva para nodoD 
                System.out.println("Solo c1 es hoja en PYU");
                analisisNodosCalculoDePyU(nodoDerecho, listaSiguientes);
                //obtenemos datos
                obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
            }
        } else if (nodoDHoja == true) {
            if (nodoIHoja == true) {
                //obtenemos datos
                System.out.println("2. Ambos son hojas en PYU");
                obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
            } else {
                //llamamos recursion para nodoIzq
                System.out.println("Solo c2 es hoja en PYU");
                analisisNodosCalculoDePyU(nodoIzquierdo, listaSiguientes);
                //obtenemos datos
                obtenerDatosN(nodoIzquierdo, nodoDerecho, nodoA, tipo, listaSiguientes);
            }
        } 
     */
    public void obtenerDatosN(nodo nodoIzquierdo, nodo nodoDerecho, nodo nodoA, int tipo, LinkedList<siguientes> listaSiguientes) {
        boolean anulableIz = nodoIzquierdo.isAnulable();
        LinkedList<Integer> priIzq = nodoIzquierdo.getPrimeraPos();
        LinkedList<Integer> ultIzq = nodoIzquierdo.getUltimaPos();

        System.out.println(priIzq);
        System.out.println(ultIzq);

        boolean anulableDe = nodoDerecho.isAnulable();
        LinkedList<Integer> priDe = nodoDerecho.getPrimeraPos();
        LinkedList<Integer> ultDe = nodoDerecho.getUltimaPos();
        System.out.println(priDe);
        System.out.println(ultDe);

        switch (tipo) {
            case numConcatenacion:
                pYuConcatenacion(nodoA, priIzq, ultIzq, priDe, ultDe, anulableIz, anulableDe, listaSiguientes);
                break;
            case numO:
                pYuO(nodoA, priIzq, ultIzq, priDe, ultDe, anulableIz, anulableDe);
                break;
            default:
                break;
        }
    }

    public void pYuConcatenacion(nodo nodoA,
            LinkedList<Integer> priIzq, LinkedList<Integer> ultIzq,
            LinkedList<Integer> priDe, LinkedList<Integer> ultDe,
            boolean anulableIz, boolean anulableDe, LinkedList<siguientes> listaSiguientes) {

        //calculamos anulable del nodoPrincipal
        boolean anulableNodo1 = tablaVerdadY(anulableIz, anulableDe);
        nodoA.setAnulable(anulableNodo1);

        //calculamos primeraPos
        LinkedList<Integer> primerosNodo = new LinkedList<>();
        if (anulableIz == false) {
            //primeroIz U primeroDe
            primerosNodo.addAll(priIzq);
            primerosNodo.addAll(priDe);
            nodoA.setPrimeraPos(primerosNodo);
        } else {
            //primerosIz
            if (priIzq.isEmpty()) {
            } else {
                primerosNodo.addAll(priIzq);
                nodoA.setPrimeraPos(primerosNodo);
            }
        }

        //calculamos ultimaPos
        LinkedList<Integer> ultimosNodo = new LinkedList<>();
        if (anulableDe == false) {
            //ultimoIz U ultimoDe
            ultimosNodo.addAll(ultIzq);
            ultimosNodo.addAll(ultDe);
            nodoA.setUltimaPos(ultimosNodo);
        } else {
            //ultimoIzq
            if (ultIzq.isEmpty()) {
            } else {
                ultimosNodo.addAll(ultIzq);
                nodoA.setUltimaPos(ultimosNodo);
            }
        }

        //calculo de siguientes de nodo concatenacion
        addSIguientesCadaNodo(listaSiguientes, ultIzq, priDe);
    }

    public void addSIguientesCadaNodo(LinkedList<siguientes> listaSiguientes, LinkedList<Integer> ultimosC1, LinkedList<Integer> primerosC2) {
        LinkedList<Integer> listaNUmerosSiguientes = listaAuxiliar(listaSiguientes);

        System.out.println("***");
        System.out.println(ultimosC1);
        System.out.println(primerosC2);
        //recorremos ultimos de C1
        if (ultimosC1.isEmpty()) {
        } else {
            for (int i = 0; i < ultimosC1.size(); i++) {
                //verificamos si el numeroUltimosC1 esta en la lista de numeros
                int numUltimoC1 = ultimosC1.get(i);

                if (listaNUmerosSiguientes.contains(numUltimoC1)) {//ya existe#
                    //agregar primerosC2 en ese numero, validar que no se repitan 
                    System.out.println("Existen siguientes " + numUltimoC1);

                    LinkedList<Integer> siguientesNodo = listaSiguientes.get(i).getPrimerosC2();

                    //revisamos que los siguientes de ese numero no se repitan
                    for (int j = 0; j < primerosC2.size(); j++) {
                        int numeroPC2 = primerosC2.get(j);

                        if (siguientesNodo.contains(numeroPC2)) {//ya no agregamos el numero
                        } else {//agregamos el numero
                            listaSiguientes.get(i).getPrimerosC2().add(numeroPC2);
                        }
                    }
                } else {//no existe en numerosSiguientes, agregamos a la lista de siguientes y a la listaAuxiliar, agregamos todos los primerosC2
                    System.out.println("---no existen siguientes se agregaran todos los pC2");
                    System.out.println(numUltimoC1);
                    siguientes a = new siguientes();
                    a.setNumero(numUltimoC1);
                    a.setPrimerosC2(primerosC2);
                    listaSiguientes.add(a);
                    listaNUmerosSiguientes.add(numUltimoC1);
                }
            }
        }
        System.out.println("Siguientes agregado en nodo concatenacion " + listaSiguientes.toString());
    }

    public LinkedList<Integer> listaAuxiliar(LinkedList<siguientes> ls) {
        LinkedList<Integer> numerosSig = new LinkedList<>();
        for (int i = 0; i < ls.size(); i++) {
            int numero = ls.get(i).getNumero();
            numerosSig.add(numero);
        }
        return numerosSig;
    }

    public void pYuO(nodo nodoA,
            LinkedList<Integer> priIzq, LinkedList<Integer> ultIzq,
            LinkedList<Integer> priDe, LinkedList<Integer> ultDe,
            boolean anulableIz, boolean anulableDe) {

        //calculo de anulable
        boolean anulableNodo = tablaVerdadO(anulableIz, anulableDe);
        nodoA.setAnulable(anulableNodo);

        //calculamos primeraPos
        LinkedList<Integer> primerosNodo = new LinkedList<>();
        primerosNodo.addAll(priIzq);
        primerosNodo.addAll(priDe);
        nodoA.setPrimeraPos(primerosNodo);

        //calculamos ultimaPos
        LinkedList<Integer> ultimosNodo = new LinkedList<>();
        ultimosNodo.addAll(ultIzq);
        ultimosNodo.addAll(ultDe);
        nodoA.setUltimaPos(ultimosNodo);

    }

    public boolean tablaVerdadY(boolean dato1, boolean dato2) {
        boolean respuesta1;
        //sera verdadero si ambas son verdaderas
        respuesta1 = dato1 == true && dato2 == true; // V y V = V
        return respuesta1;
    }

    public boolean tablaVerdadO(boolean dato1, boolean dato2) {
        boolean respuesta;
        //sera falso si ambos son falsos
        respuesta = !(dato1 == false && dato2 == false); // F y F = F
        return respuesta;
    }

    public void agregarPyUdenodoA(nodo nodoA, int tipo, LinkedList<siguientes> listaSiguientes) {
        //el anulable se obtiene del nodo central 
        nodo nodoCentral = nodoA.getNodoCentral();
        boolean esHoja = nodoCentral.isEsHoja();

        //verificamos datos
        if (esHoja == true) {
            //si es hoja obtenemos datos directos, porque la hoja ya no necesita mas datos, todos los incluye
            calculoAnulablePyUdeNodoA(nodoA, nodoCentral, tipo, listaSiguientes);
        } else {//cargar datos de nodo central, y luego obtener los datos del nodo
            analisisNodosCalculoDePyU(nodoCentral, listaSiguientes);
            calculoAnulablePyUdeNodoA(nodoA, nodoCentral, tipo, listaSiguientes);
        }
    }

    public void calculoAnulablePyUdeNodoA(nodo nodoA, nodo nodoCentral, int tipo, LinkedList<siguientes> listaSiguientes) {
        LinkedList<Integer> primeraPosNC = nodoCentral.getPrimeraPos();
        LinkedList<Integer> ultimaPosNC = nodoCentral.getUltimaPos();
        boolean anulableNC = nodoCentral.isAnulable();

        //agregamos datos correspondientes al nodo
        LinkedList<Integer> primeraPA = new LinkedList<>();
        LinkedList<Integer> ultimaPA = new LinkedList<>();
        //primeraPos y ultimaPos   
        if (primeraPosNC.isEmpty()) {
        } else {
            primeraPA.addAll(primeraPosNC);
            if (ultimaPosNC.isEmpty()) {
            } else {
                ultimaPA.addAll(ultimaPosNC);
            }
        }

        nodoA.setPrimeraPos(primeraPA);
        nodoA.setUltimaPos(ultimaPA);
        //anulable dependera del tipo
        switch (tipo) {
            case numOpcional:
                //ya tiene anulable
                break;
            case numCeroMas:
                //ya tiene anulable
                addSIguientesCadaNodo(listaSiguientes, ultimaPA, primeraPA);
                break;
            case numUnoMas:
                //no tiene anulable
                boolean anulableA = anulableNC;
                nodoA.setAnulable(anulableA);
                addSIguientesCadaNodo(listaSiguientes, ultimaPA, primeraPA);
                break;
            default:
                break;
        }

    }

}
