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
public class analisisAutomata {

    String nombre = "estado";

    public void analisisInicial(arbol arbolAnalizar, LinkedList<tablaSimbolos> tablaS, LinkedList<siguientes> tablaSiguientes, automataL automata1, int contador) {
        System.out.println("TABLA SIGUIENTES " + tablaSiguientes.toString());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------INICIA ANALISIS AUTOMATA -------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Cantidad de simbolos a evaluar " + tablaS.size());
        nodo nodoArbol = arbolAnalizar.getNodoArbol();

        LinkedList<Integer> primeros = nodoArbol.getPrimeraPos();
        contador = contador + 1;
        String nombre1 = nombre + contador;
        estado e = new estado(nombre1, primeros);
        automata1.getEstadosSinRevisar().add(e);
        //iniciamos con primer estado
        System.out.println("*****Estado analizando -> " + e.getNombreEstado());
        System.out.println("*****NumerosEstado " + e.getNumeros().toString());
        construccionAFD(tablaS, nodoArbol, tablaSiguientes, automata1, contador);

        /*        //recorremos lista de automatas sin revisar y vamos desapilando hasta que no quede niuno
        for (int i = 0; i < automata1.getEstadosSinRevisar().size(); i++) {
            estado estadoAnalizando = automata1.getEstadosSinRevisar().get(i);

            System.out.println("*************** Estado analizando " + estadoAnalizando.getNombreEstado());
            System.out.println("*************** NumerosEstado " + estadoAnalizando.getNumeros().toString());
            //cambiamos el estado de lugar

            automata1.getEstadosRevisados().add(estadoAnalizando);
            automata1.getEstadosSinRevisar().remove(estadoAnalizando);
            construccionAFD(estadoAnalizando, tablaS, nodoArbol, tablaSiguientes, automata1, contador);
        }
         */ System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void construccionAFD(LinkedList<tablaSimbolos> tablaSImbolos,
            nodo nodoA, LinkedList<siguientes> tablaSiguientes, automataL automata1, int contador) {

        for (int k = 0; k < automata1.getEstadosSinRevisar().size(); k++) {
            estado estadoAnalizando = automata1.getEstadosSinRevisar().get(k);

            System.out.println("*************** Estado analizando " + estadoAnalizando.getNombreEstado());
            System.out.println("*************** NumerosEstado " + estadoAnalizando.getNumeros().toString());
            //cambiamos el estado de lugar
            automata1.getEstadosRevisados().add(estadoAnalizando);
            automata1.getEstadosSinRevisar().remove(estadoAnalizando);

            //crear estados
            System.out.println("-------------Construccionde AFD");
            LinkedList<Integer> listaNumeros = estadoAnalizando.getNumeros();
            //EVALUAMOS CADA SIMBOLO CON EL ESTADO ACTUAL 
            for (int i = 0; i < tablaSImbolos.size(); i++) {
                //obtenemos caracter por caracter y lo comparamos con el numero de nodo para validar si tienen mismo caracter
                LinkedList<Integer> nuevaLista = new LinkedList<>(); //por cada caracter se crea una lista 
                tablaSimbolos filaSImbolos = tablaSImbolos.get(i);
                System.out.println("----------------------------- ->Fila de la tabla de simbolos " + filaSImbolos.toString());
                //al finalizar  se revisa en la lista de estadosRevisados si existe o se agrega a la estadoSinRevisar con un nuevo nombre
                if (listaNumeros.isEmpty()) {
                    System.out.println("********** NO hay numeros a evaluar del estado");
                } else {
                    System.out.println("********** SI hay numeros a evaluar del estado");
                    for (int j = 0; j < listaNumeros.size(); j++) {
                        int numero = listaNumeros.get(j);
                        System.out.println("*************** Numero a evaluar " + numero);
                        busquedaPorTipo(filaSImbolos, numero, nuevaLista, nodoA, estadoAnalizando, tablaSiguientes);
                    }
                    //buscamos si ya existe el estado con la lista creada, si existe solo se hace referencia del mismo , sino se agega nuevo estado       
                    //tambien se agrega a la tabla del automata la transicion
                    if (nuevaLista.isEmpty()) {
                        System.out.println("LISTA VACIA no se agrega estado ");
                    } else {
                        busquedaEstadoRevisadoYSinRevisar(automata1, nuevaLista, filaSImbolos, estadoAnalizando, contador, tablaSImbolos, nodoA, tablaSiguientes);
                    }
                }
            }
        }

    }

    public void busquedaEstadoRevisadoYSinRevisar(automataL a, LinkedList<Integer> listaBuscar, tablaSimbolos filaSImbolo, estado estadoAnalizando, int contador,
            LinkedList<tablaSimbolos> tablaSImbolos,
            nodo nodoA, LinkedList<siguientes> tablaSiguientes) {
        System.out.println("Lista a buscar si existe en algun estado " + listaBuscar.toString());
        LinkedList<estado> eR1 = a.getEstadosRevisados();
        LinkedList<estado> eSR1 = a.getEstadosSinRevisar();
        boolean encontrado = false;
        estado estadoEncontrado = null;

        /*primero buscamos en estados revisados, 
        sino se encuentra entonces  buscamos en estados sin revisar, 
        si al final no se encuentra,se apila a estados sin revisar  como nuevo estado
         */
        for (int i = 0; i < eR1.size(); i++) {
            LinkedList<Integer> listaEstadoRevisado = eR1.get(i).getNumeros();
            //ordenamos cada lista
            listaBuscar.sort(Comparator.naturalOrder());
            listaEstadoRevisado.sort(Comparator.naturalOrder());
            //ya ordenadas comparamos 
            if (listaBuscar.equals(listaEstadoRevisado)) {
                estadoEncontrado = eR1.get(i);
                System.out.println("Estado encontrado en  revisados " + estadoEncontrado.getNombreEstado());
                encontrado = true;
                break;
            } else {
            }
        }

        if (encontrado == true) {
            System.out.println("ya existia estado como un estado revisado -->" + estadoEncontrado.getNombreEstado());

            //agregamos transicion a la tabla
            filaTablaAFD filaAfd = new filaTablaAFD(estadoAnalizando, filaSImbolo, estadoEncontrado);
            a.getTablaAFD().add(filaAfd);

        } else {
            //buscamos en lista de estados sin revisar
            for (int i = 0; i < eSR1.size(); i++) {
                LinkedList<Integer> listaEstadosSInRevisar = eSR1.get(i).getNumeros();
                //ordenamos cada lista
                listaBuscar.sort(Comparator.naturalOrder());
                listaEstadosSInRevisar.sort(Comparator.naturalOrder());
                //ya ordenadas comparamos 
                if (listaBuscar.equals(listaEstadosSInRevisar)) {
                    estadoEncontrado = eSR1.get(i);
                    System.out.println("Estado encontrado en sin revisar " + estadoEncontrado.getNombreEstado());
                    encontrado = true;
                    break;
                } else {
                }
            }
            if (encontrado == true) {
                System.out.println("ya existia estado como un estado sin revisar -->" + estadoEncontrado.getNombreEstado());
                //agregar a tabla como una transicion
                filaTablaAFD filaAfd = new filaTablaAFD(estadoAnalizando, filaSImbolo, estadoEncontrado);
                a.getTablaAFD().add(filaAfd);

            } else {
                //sino agregar como nuevo estado sin revisar
                contador = contador + 1;
                String nombre1 = nombre + contador;
                estado e2 = new estado(nombre1, listaBuscar);
                a.getEstadosSinRevisar().add(e2);
                System.out.println("Se agrego nuevo estado --->" + e2.getNombreEstado() + " " + e2.getNumeros().toString());
                filaTablaAFD filaAfd = new filaTablaAFD(estadoAnalizando, filaSImbolo, e2);
                a.getTablaAFD().add(filaAfd);

                System.out.println("*****Estado analizando -> " + e2.getNombreEstado());
                System.out.println("*****NumerosEstado " + e2.getNumeros().toString());
                construccionAFD(tablaSImbolos, nodoA, tablaSiguientes, a, contador);

            }
        }
    }

    public void busquedaPorTipo(tablaSimbolos fila1, int numero, LinkedList<Integer> nuevaLista, nodo nodoA, estado e, LinkedList<siguientes> tablaSiguientes) {
        //obtenemos del numero el dato y si son iguales se agrega a la lista que se creara por cada simbolo 
        boolean esCadena = fila1.isEsCadena();
        boolean esString = fila1.isEsString();
        boolean esInt = fila1.isEsNumero();
        boolean esEspacio = fila1.isEsEspacioBlanco();
        boolean esTab = fila1.isEsTabulador();
        boolean esSaltoL = fila1.isEsSaltoLinea();

        boolean encontrado = false;

        System.out.println("********** SE BUSCA NODO QUE COINCIDA CON EL NUMERO ");
        System.out.println("Se obtiene valor de la fila ");
        String cadenaChar = "";
        if (esCadena == true) {
            System.out.println("------------------------------- comparando con cadena ");
            //obtenemos el booleano del numero a buscar y si coincide lo agregamos a la lista , en este caso tambien comparamos la cadena 
            cadenaChar = fila1.getValString();
            recorridoArbol(nodoA, numero, e, cadenaChar, 0, nuevaLista, tablaSiguientes, true);
        } else if (esString == true) {
            System.out.println("-------------------------------  comparando con string ");
            //obtenemos el booleano del numero a buscar y si coincide lo agregamos a la lista 
            encontrado = recorridoArbol(nodoA, numero, e, cadenaChar, 1, nuevaLista, tablaSiguientes, true);
        } else if (esInt == true) {
            System.out.println("------------------------------- comparando con int ");
            //obtenemos el booleano del numero a buscar y si coincide lo agregamos a la lista 
            encontrado = recorridoArbol(nodoA, numero, e, cadenaChar, 2, nuevaLista, tablaSiguientes, true);
        } else if (esEspacio == true) {
            System.out.println("------------------------------- comparando con espacio ");
            //obtenemos el booleano del numero a buscar y si coincide lo agregamos a la lista 
            encontrado = recorridoArbol(nodoA, numero, e, cadenaChar, 3, nuevaLista, tablaSiguientes, true);
        } else if (esTab == true) {
            System.out.println("------------------------------- comparando con tabulacion ");
            //obtenemos el booleano del numero a buscar y si coincide lo agregamos a la lista 
            recorridoArbol(nodoA, numero, e, cadenaChar, 4, nuevaLista, tablaSiguientes, true);
        } else if (esSaltoL == true) {
            System.out.println("------------------------------- comparando con salto linea ");
            //obtenemos el booleano del numero a buscar y si coincide lo agregamos a la lista 
            recorridoArbol(nodoA, numero, e, cadenaChar, 5, nuevaLista, tablaSiguientes, true);
        } else {
            System.out.println("------------------------------ no se compara xq no coincidio con ningun valor ");
        }
    }

    public void agregar(LinkedList<Integer> lista, int numero, LinkedList<siguientes> tablaSiguientes, boolean opcion1, boolean opcion2) {
        System.out.println("Lista siguientes " + tablaSiguientes.toString());
        if (opcion1 == true && opcion2 == true) {
            System.out.println("-----------------------SE encontro dato del nodo que coincida con la fila  ");
            for (int i = 0; i < tablaSiguientes.size(); i++) {//numero que evaluamos 
                int numeroS = tablaSiguientes.get(i).getNumero();
                if (numero == numeroS) {//si el numero evaluado esta en la tabla de siguientes entonces obtenemos sus siguientes 
                    //agregamos siguientes a la  lista , revisar antes que cada numero no este repetido 
                    LinkedList<Integer> numerosS = tablaSiguientes.get(i).getPrimerosC2(); //obtenemos los numeros del nodo
                    System.out.println("Numeros siguiente y numeroNodo igual ");
                    for (int j = 0; j < numerosS.size(); j++) {
                        int numeroA = numerosS.get(j);
                        if (lista.contains(numeroA)) {
                        } else {
                            System.out.println("Numero agregado " + numeroA);
                            lista.add(numeroA);
                        }
                    }
                    break;
                } else {
                }
            }
        } else {
            System.out.println("No coincidio el dato del nodo con la fila ");
        }
    }

    public boolean recorridoArbol(nodo nodoA, int numeroBuscar, estado e, String cadenaBuscar,
            int tipo, LinkedList<Integer> nuevaLista, LinkedList<siguientes> tablaSiguientes, boolean opcion1) {
        boolean respuesta = false;
        boolean concatenacion = nodoA.isConcatenacion();
        boolean barra = nodoA.isO();
        boolean opcional = nodoA.isOpcional();
        boolean unoMas = nodoA.isUnoMas();
        boolean ceroMas = nodoA.isCeroMas();
        boolean hoja = nodoA.isEsHoja();
        boolean aceptacion = nodoA.isEsAceptacion();

        if (concatenacion == true) {//obtenemos nodo hijoIzq, nodo hijoD
            nodo nodoIzquierdo = nodoA.getNodoIzquierdo();
            nodo nodoDerecho = nodoA.getNodoDerecho();

            recorridoArbol(nodoIzquierdo, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);
            recorridoArbol(nodoDerecho, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);

        } else if (barra == true) {//obtenemos nodo hijoIzq, nodo hijoD
            nodo nodoIzquierdo = nodoA.getNodoIzquierdo();
            nodo nodoDerecho = nodoA.getNodoDerecho();

            recorridoArbol(nodoIzquierdo, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);
            recorridoArbol(nodoDerecho, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);

        } else if (opcional == true) {//? obtenemos nodo central
            nodo nodoCentral = nodoA.getNodoCentral();
            recorridoArbol(nodoCentral, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);

        } else if (unoMas == true) {//+ obtenemos nodo central
            nodo nodoCentral = nodoA.getNodoCentral();
            recorridoArbol(nodoCentral, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);

        } else if (ceroMas == true) {//* obtenemos nodo central
            nodo nodoCentral = nodoA.getNodoCentral();
            recorridoArbol(nodoCentral, numeroBuscar, e, cadenaBuscar, tipo, nuevaLista, tablaSiguientes, opcion1);

        } else if (hoja == true) {//hoja obtenemos valor de la hoja 
            //revisamos que el numero de hoja coincida con el numeroBUscar, si coinciden  procedemos a validar
            int numeroHoja = nodoA.getNumeroHoja();
            if (numeroHoja == numeroBuscar) {
                System.out.println("************ Encontramos hoja con el numero " + numeroBuscar);
                switch (tipo) {
                    case 0:
                        //validar que los caracteres sean identicos
                        respuesta = nodoA.isIsChar();
                        if (respuesta == true) {
                            String cadenaObtenida = nodoA.getValorChar();
                            System.out.println("Cadena 1" + cadenaBuscar);
                            System.out.println("Cadena 2" + cadenaObtenida);
                            if (cadenaObtenida.equals(cadenaBuscar)) {
                                System.out.println("Obteniendo el valor del nodoCH " + numeroBuscar + "-->" + respuesta);
                                respuesta = true;
                                agregar(nuevaLista, numeroBuscar, tablaSiguientes, opcion1, respuesta);
                            } else {
                                respuesta = false;
                            }
                        } else {
                            respuesta = false;
                        }
                        break;
                    case 1:
                        respuesta = nodoA.isIsString();
                        System.out.println("Obteniendo el valor del nodoSTR " + numeroBuscar + "-->" + respuesta);
                        agregar(nuevaLista, numeroBuscar, tablaSiguientes, opcion1, respuesta);
                        break;
                    case 2:
                        respuesta = nodoA.isIsNumero();
                        System.out.println("Obteniendo el valor del nodoN " + numeroBuscar + "-->" + respuesta);
                        agregar(nuevaLista, numeroBuscar, tablaSiguientes, opcion1, respuesta);
                        break;
                    case 3:
                        respuesta = nodoA.isIsEspacioBlanco();
                        System.out.println("Obteniendo el valor del nodoES " + numeroBuscar + "-->" + respuesta);
                        agregar(nuevaLista, numeroBuscar, tablaSiguientes, opcion1, respuesta);
                        break;
                    case 4:
                        respuesta = nodoA.isIsTabulador();
                        System.out.println("Obteniendo el valor del nodoTAB " + numeroBuscar + "-->" + respuesta);
                        agregar(nuevaLista, numeroBuscar, tablaSiguientes, opcion1, respuesta);
                        break;
                    case 5:
                        respuesta = nodoA.isIsSaltoLinea();
                        System.out.println("Obteniendo el valor del nodoSL " + numeroBuscar + "-->" + respuesta);
                        agregar(nuevaLista, numeroBuscar, tablaSiguientes, opcion1, respuesta);
                        break;
                }
            } else {
            }
        } else if (aceptacion == true) {//# no realizamos nada , solo devolvemos que es de aceptacion asi se marca el estado como aceptacion
            int numeroHoja = nodoA.getNumeroHoja();
            if (numeroBuscar == numeroHoja) {
                System.out.println("Es aceptacion ");
                e.setEsFInal(true);
            } else {
            }
        }
        return respuesta;
    }

    public void mostrarArbol(nodo nodoA) {
        boolean concatenacion = nodoA.isConcatenacion();
        boolean barra = nodoA.isO();
        boolean opcional = nodoA.isOpcional();
        boolean unoMas = nodoA.isUnoMas();
        boolean ceroMas = nodoA.isCeroMas();
        boolean hoja = nodoA.isEsHoja();
        boolean aceptacion = nodoA.isEsAceptacion();

        if (concatenacion == true) {//obtenemos nodo hijoIzq, nodo hijoD
            nodo nodoIzquierdo = nodoA.getNodoIzquierdo();
            nodo nodoDerecho = nodoA.getNodoDerecho();

            mostrarArbol(nodoIzquierdo);
            mostrarArbol(nodoDerecho);
            System.out.println("NODO CONCATENACION ");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());

            System.out.println("----------NODO IZQUIERDO PC1 " + nodoIzquierdo.getPrimeraPos());
            System.out.println("----------NODO IZQUIERDO UC1 " + nodoIzquierdo.getUltimaPos());

            System.out.println("---------------NODO DERECHO PC2 " + nodoDerecho.getPrimeraPos());
            System.out.println("----------------NODO DERECHO UC2 " + nodoDerecho.getUltimaPos());

        } else if (barra == true) {//obtenemos nodo hijoIzq, nodo hijoD
            nodo nodoIzquierdo = nodoA.getNodoIzquierdo();
            nodo nodoDerecho = nodoA.getNodoDerecho();

            mostrarArbol(nodoIzquierdo);
            mostrarArbol(nodoDerecho);
            System.out.println("NODO O ");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());

            System.out.println("----------NODO IZQUIERDO PC1 " + nodoIzquierdo.getPrimeraPos());
            System.out.println("----------NODO IZQUIERDO UC1 " + nodoIzquierdo.getUltimaPos());

            System.out.println("---------------NODO DERECHO PC2 " + nodoDerecho.getPrimeraPos());
            System.out.println("---------------NODO DERECHO UC2 " + nodoDerecho.getUltimaPos());

        } else if (opcional == true) {//? obtenemos nodo central
            nodo nodoCentral = nodoA.getNodoCentral();

            mostrarArbol(nodoCentral);
            System.out.println("NODO OPCIONAL ");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());

            System.out.println("----------NODO CENTRAL PC1 " + nodoCentral.getPrimeraPos());
            System.out.println("----------NODO CENTRAL UC1 " + nodoCentral.getUltimaPos());

        } else if (unoMas == true) {//+ obtenemos nodo central
            nodo nodoCentral = nodoA.getNodoCentral();

            mostrarArbol(nodoCentral);
            System.out.println("NODO UNO MAS ");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());

            System.out.println("----------NODO CENTRAL PC1 " + nodoCentral.getPrimeraPos());
            System.out.println("----------NODO CENTRAL UC1 " + nodoCentral.getUltimaPos());

        } else if (ceroMas == true) {//* obtenemos nodo central
            nodo nodoCentral = nodoA.getNodoCentral();
            System.out.println("NODO CERO MAS ");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());

            System.out.println("----------NODO CENTRAL PC1 " + nodoCentral.getPrimeraPos());
            System.out.println("----------NODO CENTRAL UC1 " + nodoCentral.getUltimaPos());

            mostrarArbol(nodoCentral);

        } else if (hoja == true) {//hoja obtenemos valor de la hoja 
            //revisamos que el nume ro de hoja coincida con el numeroBUscar, si coinciden  procedemos a validar
            System.out.println("NODO HOJA ");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());
            System.out.println("-----NUMERO HOJA  " + nodoA.getNumeroHoja());

        } else if (aceptacion == true) {//# no realizamos nada , solo devolvemos que es de aceptacion asi se marca el estado como aceptacion
            System.out.println("NODO ACEPTACION");
            System.out.println("-----NODO DE " + nodoA.getPrimeraPos());
            System.out.println("-----NODO IZ " + nodoA.getUltimaPos());
            System.out.println("-----NUMERO HOJA  " + nodoA.getNumeroHoja());

        }
    }

}
