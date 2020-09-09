/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisEntrada;

import java.util.LinkedList;
import lexico.arbol;
import lexico.automataL;
import lexico.errores;
import lexico.estado;
import lexico.filaTablaAFD;
import lexico.tablaSimbolos;
import static p1_comp2.P1_COMP2.listaLeguajes;
import sintactico.lenguaje;
import sintactico.tokensLeidos;

/**
 *
 * @author esmeralda
 */
public class evaluacionLexica {
    //leemos caracter por caracter, evaluando primero como numeros o letras, seguido verificar si algun caracter es similar 

    public LinkedList<tokensLeidos> listaAuxiliarTokensAceptados = new LinkedList<>();
    public String nombreEstado2 = "";
    public String datoGuardado = "";
    public LinkedList<tokensLeidos> listaTok;

    public void analisisLenguajeSeleccionado(String entrada, String nombreLenguaje) {
        System.out.println("INICIA ANALISIS DE ENTRADA ");
        for (int i = 0; i < listaLeguajes.size(); i++) {//evaluamos la lista de lenguajes existentes 

            String nombre = listaLeguajes.get(i).getNombreLenguaje();
            lenguaje lenguaje1 = listaLeguajes.get(i);
            if (nombre.equals(nombreLenguaje)) {//si encontramos el lenguaje seleccionado
                LinkedList<arbol> arboles = listaLeguajes.get(i).getArboles();

                if (0 < entrada.length()) {//evaluamos si la posicion coincide
                    char eof = entrada.charAt(0);
                    if (eof == 3) {//es fin de archivo
                        mostrarTokensleidos(lenguaje1);
                        break;
                    } else {//procedemos a buscar que arbol coincide con el caracter
                        busquedaDatoCoincide(arboles, 0, entrada, lenguaje1, "estado1");
                        mostrarTokensleidos(lenguaje1);
                        break;
                    }

                } else {
                    System.out.println("FINALIZA ANALISIS DE CENTRADA NO HAY MAS CARACTERES");
                    break;
                }
            } else {
                //continua buscando lenguaje que coincida
            }
        }
    }

    public void mostrarTokensleidos(lenguaje l) {
        LinkedList<tokensLeidos> lis = l.getListaTokensLeidos();
        for (int i = 0; i < lis.size(); i++) {
            tokensLeidos t = lis.get(i);
            System.out.println("TOKEN:  " + t.getNombreLexema() + "\tVALOR:  " + t.getValorString());
        }
    }

    public void busquedaDatoCoincide(LinkedList<arbol> arboles, int posicion, String entrada, lenguaje lenguaje1, String nombreEstado2) {
        //en la lista de automatas buscar estado inicial, luego buscar si coincide el dato , si coincide entonces analizar   el automata completamente  
        System.out.println("BUSQUEDA DE DATO COINCIDENTE");
        boolean encontrado = false;

        for (int i = 0; i < arboles.size(); i++) {//analizamos cada automata/arbol
            automataL automata = arboles.get(i).getAfdARbol();
            LinkedList<filaTablaAFD> filasAFD = automata.getTablaAFD();

            for (int j = 0; j < filasAFD.size(); j++) {//obtenemos las filas de la tabla del automata 
                String nombreE = filasAFD.get(j).getEstadoInicial().getNombreEstado();
                filaTablaAFD fila = filasAFD.get(j);

                if (nombreEstado2.equals(nombreE)) {//buscamos que el estado1 coincida con el estado a buscar   
                    //buscar si coincide el caracter, si coincide entonces analizar el automata completo
                    encontrado = coincideE1(fila, posicion, entrada);

                    if (encontrado == true) {
                        //se procede a evaluar el automata, ya no se continua revisando las demas filas del estado
                        System.out.println("Se encontro estado-> " + nombreE);
                        System.out.println("Coincide el automata");
                        String lexema = arboles.get(i).getNombreLexema();
                        analisisDeAutomata(arboles, automata, posicion, entrada, nombreE, lexema, lenguaje1);
                        break; //salimos de revisar las filas 
                    } else {//es el estado pero no con el caracter
                    }
                } else {
                    //se sigue buscando que coincidan estados
                }
            }

            if (encontrado == true) {//ya no se continua con otro automata
                break;
            } else { //se sigue evaluando el automata
            }
        }

        //si en ningun estado  coincide entonces es un error
        if (encontrado == false) {
            //mandar como error lexico, evaluar siguiente caracter
            String caracter = entrada.valueOf(posicion);
            errores e = new errores("LEXICO", 0, 0, caracter, "Error no se reconoce el caracter ");
            System.out.println("ERROR LEXICO, NO SE RECONOCE CARACTER " + caracter);
            lenguaje1.getListaErrores().add(e);
            String nombreLenguaje = lenguaje1.getNombreLenguaje();

            //continuar con siguiente caracter, para ver si existe token, limpiamos los datos 
            posicion = posicion + 1;
            datoGuardado = "";
            listaAuxiliarTokensAceptados.clear();
            if (posicion < entrada.length()) {//validar que este la posicion sea valida en la entrada 
                char eof = entrada.charAt(posicion);
                if (eof == 3) {//es fin de estado
                    System.out.println("FINALIZA ANALISIS DE ENTRADA ");
                } else {
                    System.out.println("SE BUSCA EL SIGUIENTE CARACTER, DESPUES DE ERROR LEXICO");
                    busquedaDatoCoincide(arboles, posicion, entrada, lenguaje1, "estado1");
                }
            } else {
                tokensLeidos t = new tokensLeidos(nombreLenguaje, datoGuardado);
                lenguaje1.getListaTokensLeidos().add(t);
                System.out.println("Token agregado "+t);
                System.out.println("FINALIZA ANALISIS DE ENTRADA ");
            }
        }
    }

    public void analisisDeAutomata(LinkedList<arbol> arboles, automataL automata, int posicionCaracter, String entrada,
            String nombreEstado, String nombreLexema, lenguaje lenguaje1) {

        System.out.println("ANALISIS DE AUTOMATA ");
        System.out.println("DaTO GUARDADO " + datoGuardado);
        boolean estadoCoincidente = false;
        //obtenemos los estados del automata 
        LinkedList<filaTablaAFD> filasAFD = automata.getTablaAFD();
        ///buscamos que filas tienen ese estado y evaluaremos cada fila para ver si coincide con el simbolo a evaluar

        if (posicionCaracter < entrada.length()) {
            System.out.println("CARACTER EVALUANDO ->->-> "+entrada.charAt(posicionCaracter));
            for (int i = 0; i < filasAFD.size(); i++) {
                String nombreE = filasAFD.get(i).getEstadoInicial().getNombreEstado();
                filaTablaAFD fila = filasAFD.get(i);
                if (nombreE.equals(nombreEstado)) {//coincide los nombres de los estados 
                    estadoCoincidente = analisisFilaE1(fila, posicionCaracter, entrada, nombreLexema);//analisamos el caracter de ese estado

                    if (estadoCoincidente == true) {
                        //se procede a pasar al siguiente estado, ya no se evalua el automata
                        posicionCaracter = posicionCaracter + 1; //aumentamos la posicion del caracter 

                        if (posicionCaracter < entrada.length()) {//validamos el dato 
                            char eof = entrada.charAt(posicionCaracter);
                            if (eof == 3) {
                                tokensLeidos token = listaAuxiliarTokensAceptados.getLast();
                                lenguaje1.getListaTokensLeidos().add(token);
                                System.out.println("Token agregado " + token.getValorString());
                                System.out.println("FINALIZA ANALISIS DE CADENA CON EOF");
                                break;
                            } else {
                                System.out.println("PASAMOS A OTRO AUTOMATA con el caracter-> " + entrada.charAt(posicionCaracter));
                                busquedaDatoCoincide(arboles, posicionCaracter, entrada, lenguaje1, nombreEstado2);
                                break;
                            }
                        } else { //ya no existe caracter en entrada
                            tokensLeidos token = listaAuxiliarTokensAceptados.getLast();
                            lenguaje1.getListaTokensLeidos().add(token);
                            System.out.println("Token agregado " + token.getValorString());
                            System.out.println("FINALIZA ANALISIS DE CADENA");
                            break;
                        }
                    } else {
                        // no se hace nada hasta recorrer las otras entradas del estado 
                    }
                } else {
                    //seguir buscando estado
                }
            }

            if (estadoCoincidente == false) {
                //limpiamos entrada, y dato guardado, y se comienza a buscar otra vez si coincide el caracter con algun E1 de c/automata
                //la posicion es la misma    
                if (listaAuxiliarTokensAceptados.isEmpty()) {
                    System.out.println("No hay tokens que agregar, no hay datos en la lista auxiliar");
                } else {
                    tokensLeidos token = listaAuxiliarTokensAceptados.getLast();
                    lenguaje1.getListaTokensLeidos().add(token);
                    System.out.println("Token agregado " + token.getValorString());
                }
                datoGuardado = "";
                listaAuxiliarTokensAceptados.clear();
                if (posicionCaracter < entrada.length()) {
                    char eof = entrada.charAt(posicionCaracter);
                    if (eof == 3) {
                        System.out.println("FINALIZA ANALISIS DE CADENA CON EOF");
                    } else {
                        System.out.println("EVALUAMOS OTRO CARACTER, SE HA AGREGADO UN TOKEN, siguiente caracter-> " + entrada.charAt(posicionCaracter));
                        busquedaDatoCoincide(arboles, posicionCaracter, entrada, lenguaje1, "estado1");
                    }
                } else {
                    System.out.println("FINALIZA ANALISIS DE ENTRADA ");
                }
            }

        } else {
            //la posicion del caracter es mayor a la entrada 
                    tokensLeidos token = listaAuxiliarTokensAceptados.getLast();
                    lenguaje1.getListaTokensLeidos().add(token);
                    System.out.println("Token agregado " + token.getValorString());
        }
    }

    public boolean coincideE1(filaTablaAFD fila, int posicion, String entrada) {
        boolean coincide = false;

        tablaSimbolos simbolo = fila.getSimbolo();

        boolean esString = simbolo.isEsString();
        boolean esInt = simbolo.isEsNumero();
        boolean esChar = simbolo.isEsCadena();
        boolean esSaltoLinea = simbolo.isEsSaltoLinea();
        boolean esEspacio = simbolo.isEsEspacioBlanco();
        boolean esTb = simbolo.isEsTabulador();

        //primero evaluar si coincide con un char , sino entonces puede ser un id, num , espacios
        if (esChar == true) {
            //obtenemos el valor del char para ver si coincide 
            String valroCHar = simbolo.getValString();
            int indice = valroCHar.length() - 1;
            //avanzamos esa cantidad en  la entrada 
            if (indice < entrada.length()) {
                String cadena = entrada.substring(posicion, posicion + indice);
                if (cadena.equals(valroCHar)) {
                    coincide = true;
                } else {
                    coincide = false;
                }
            } else {
                coincide = false;
            }

        } else {
            //antes validar la posicion del caracter en la entrada
            if (posicion < entrada.length()) {

                //evaluar si es string, int , espacios.
                if (esString == true) {
                    //evaluamos si esta en el rango de a-z
                    int numero = entrada.charAt(posicion);
                    if ((numero >= 65 && numero <= 90) || (numero >= 97 && numero <= 122)) {// A-Z a-z
                        coincide = true;
                    } else {
                        coincide = false;
                    }
                } else if (esInt == true) {//evaluaos si esta en rango de 0-9
                    int numero = entrada.charAt(posicion);
                    if (numero >= 48 && numero <= 57) {// 0-9
                        coincide = true;
                    } else {
                        coincide = false;
                    }
                } else if (esSaltoLinea == true) { //evaluamos si coincide, 10
                    int numero = entrada.charAt(posicion);
                    if (numero == 10) {
                    } else {
                    }
                } else if (esEspacio == true) {//evaluamos si coincide, 32
                    int numero = entrada.charAt(posicion);
                    if (numero == 32) {
                        coincide = true;
                    } else {
                        coincide = false;
                    }
                } else if (esTb == true) {//evaluamos si coincide, 9
                    int numero = entrada.charAt(posicion);
                    if (numero == 9) {
                        coincide = true;
                    } else {
                        coincide = false;
                    }
                }

            } else {//en caso que la posicion no coincidad
                coincide = false;
            }

        }
        return coincide;
    }

    public boolean analisisFilaE1(filaTablaAFD fila, int posicion, String entrada,  String nombreLexema) {

        boolean aceptado = true;

        estado e1 = fila.getEstadoInicial();
        tablaSimbolos simbolo = fila.getSimbolo();
        estado e2 = fila.getEstadoFInal();
        nombreEstado2 = e2.getNombreEstado();

        boolean esString = simbolo.isEsString();
        boolean esInt = simbolo.isEsNumero();
        boolean esChar = simbolo.isEsCadena();
        boolean esSaltoLinea = simbolo.isEsSaltoLinea();
        boolean esEspacio = simbolo.isEsEspacioBlanco();
        boolean esTb = simbolo.isEsTabulador();

        //primero evaluar si coincide con un char , sino entonces puede ser un id, num , espacios
        if (esChar == true) {
            System.out.println("En el estado es un char");
            //obtenemos el valor del char para ver si coincide 
            String valroCHar = simbolo.getValString();

            int indice = valroCHar.length() - 1;
            //avanzamos esa cantidad en  la entrada 
            int fin = posicion + indice;
            if (fin < entrada.length()) {

                //avanzamos esa cantidad en  la entrada 
                String cadena = entrada.substring(posicion, fin);
                if (cadena.equals(valroCHar)) {
                    //si coincide la entrada entonces unimos a lo que viene anterior 
                    datoGuardado = datoGuardado + valroCHar;
                    //evaluar si este es un estado final
                    if (e2.isEsFInal() == true) {
                        //agregamos a lista, no limpiamos dato aun pues puesde ser que se concatene a otros datos
                        tokensLeidos a = new tokensLeidos(nombreLexema, datoGuardado);
                        listaAuxiliarTokensAceptados.add(a);
                    } else {
                        //no es estado final
                    }
                    //continuamos con siguiente fila del estado
                    aceptado = true;
                } else {
                    //no coincide el char con el simbolo,  evaluamos el caracter en otro automata 
                    aceptado = false;
                }
            } else {
                aceptado = false;
            }
        } else {

            if (posicion < entrada.length()) {
                //evaluar si es string, int , espacios.
                if (esString == true) {
                    System.out.println("En el estado es un string");
                    //evaluamos si esta en el rango de a-z
                    char dato = entrada.charAt(posicion);
                    int numero = entrada.charAt(posicion);
                    if ((numero >= 65 && numero <= 90) || (numero >= 97 && numero <= 122)) {// A-Z a-z
                        aceptado = true;
                        //si coincide la entrada entonces unimos a lo que viene anterior 
                        datoGuardado = datoGuardado + dato;
                        //evaluar si este es un estado final
                        if (e2.isEsFInal() == true) {
                            //agregamos a lista, no limpiamos dato aun pues puesde ser que se concatene a otros datos
                            tokensLeidos a = new tokensLeidos(nombreLexema, datoGuardado);
                            listaAuxiliarTokensAceptados.add(a);
                        } else {
                            //no es estado final
                        }
                    } else {
                        aceptado = false;
                    }
                } else if (esInt == true) {//evaluaos si esta en rango de 0-9
                    System.out.println("En el estado es un numero");
                    int numero = entrada.charAt(posicion);
                    if (numero >= 48 && numero <= 57) {// 0-9
                        //me muevo al estado2
                        char dato = entrada.charAt(posicion);
                        aceptado = true;
                        //si coincide la entrada entonces unimos a lo que viene anterior 
                        datoGuardado = datoGuardado + dato;
                        //evaluar si este es un estado final
                        if (e2.isEsFInal() == true) {
                            //agregamos a lista, no limpiamos dato aun pues puesde ser que se concatene a otros datos
                            tokensLeidos a = new tokensLeidos(nombreLexema, datoGuardado);
                            listaAuxiliarTokensAceptados.add(a);
                        } else {
                            //no es estado final
                        }
                    } else {
                        aceptado = false;
                    }
                } else if (esSaltoLinea == true) { //evaluamos si coincide, 10
                    System.out.println("En el estado es un saltoLinea");
                    int numero = entrada.charAt(posicion);
                    if (numero == 10) {
                        char dato = entrada.charAt(posicion);
                        aceptado = true;
                        //si coincide la entrada entonces unimos a lo que viene anterior 
                        datoGuardado = datoGuardado + dato;
                        //evaluar si este es un estado final
                        if (e2.isEsFInal() == true) {
                            //agregamos a lista, no limpiamos dato aun pues puesde ser que se concatene a otros datos
                            tokensLeidos a = new tokensLeidos(nombreLexema, datoGuardado);
                            listaAuxiliarTokensAceptados.add(a);
                        } else {
                            //no es estado final
                        }
                    } else {
                        aceptado = false;
                    }
                } else if (esEspacio == true) {//evaluamos si coincide, 32
                    System.out.println("En el estado es un espacio");

                    int numero = entrada.charAt(posicion);
                    if (numero == 32) {
                        char dato = entrada.charAt(posicion);
                        aceptado = true;
                        //si coincide la entrada entonces unimos a lo que viene anterior 
                        datoGuardado = datoGuardado + dato;
                        //evaluar si este es un estado final
                        if (e2.isEsFInal() == true) {
                            //agregamos a lista, no limpiamos dato aun pues puesde ser que se concatene a otros datos
                            tokensLeidos a = new tokensLeidos(nombreLexema, datoGuardado);
                            listaAuxiliarTokensAceptados.add(a);
                        } else {
                            //no es estado final
                        }
                    } else {
                        aceptado = false;
                    }
                } else if (esTb == true) {//evaluamos si coincide, 9
                    System.out.println("En el estado es tabulacion");

                    int numero = entrada.charAt(posicion);
                    if (numero == 9) {
                        char dato = entrada.charAt(posicion);
                        aceptado = true;
                        //si coincide la entrada entonces unimos a lo que viene anterior 
                        datoGuardado = datoGuardado + dato;
                        //evaluar si este es un estado final
                        if (e2.isEsFInal() == true) {
                            //agregamos a lista, no limpiamos dato aun pues puesde ser que se concatene a otros datos
                            tokensLeidos a = new tokensLeidos(nombreLexema, datoGuardado);
                            listaAuxiliarTokensAceptados.add(a);
                        } else {
                            //no es estado final
                        }
                    } else {
                        aceptado = false;
                    }
                } else {
                    aceptado = false;
                }
            } else {
                aceptado = false;
            }
        }
        return aceptado;
    }

}
