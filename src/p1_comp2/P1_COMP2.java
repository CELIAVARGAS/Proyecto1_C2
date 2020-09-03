/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_comp2;

import analisis.generadorLexicoSintactico;
import java.util.LinkedList;
import lexico.nodo;
import sintactico.lenguaje;

/**
 *
 * @author esmeralda
 */
public class P1_COMP2 {

    /**
     * @param args the command line arguments
     */
    public static LinkedList<lenguaje> listaLeguajes = new LinkedList<>();

    public static void main(String[] args) {
        //Limpiamos lista de lenguajes 
        listaLeguajes.clear();

        generadorLexicoSintactico a = new generadorLexicoSintactico();
        a.Compiladores_C();

        pantallas.PRINCIPAL p = new pantallas.PRINCIPAL();
        p.setVisible(true);

        System.out.println(" //este es un comentario simple \\n\" +\n"
                + "\"nombre: java; /*comentario compuesto*/\\n\" +\n"
                + "\"version: 11.0.7;\\n\" +\n"
                + "\"autor: sun Microsystems;\\n\" +\n"
                + "\"lanzamiento: 1996;\\n\" +\n"
                + "\"extension: java ;\\n\" +\n"
                + "\"\\n\" +\n"
                + "\"%% \\n\" +\n"
                + "        \"{ sout{}; sout {}; public a}\"+\n"
                + "\"%% \\n\" +\n"
                + "\"palabra = [a-z]+;\\n\" +\n"
                + "\"entero1 = [0-9]+;\\n\" +\n"
                + "\"real1 = [0-9]+((\\\".\\\")[0-9]+)?;\\n\" +\n"
                + "\"más = \\\"+\\\";\\n\" +\n"
                + "\"menos = \\\"-\\\";\\n\" +\n"
                + "\"& = [\\\\n\\\\t]; \\n\" +\n"
                + "\"\\n\" +\n"
                + "\"%% \\n\" +\n"
                + "\"terminal por, div;\\n\" +\n"
                + "\"terminal más, menos;\\n\" +\n"
                + "\"terminal entero1;\\n\" +\n"
                + "\"no terminal A, B;\\n\" +\n"
                + "\"no terminal S;\\n\" +\n"
                + "\"\\n\" +\n"
                + "\"%%\\n\" +\n"
                + "\"S :: E:val {printf(“Resultado = %d”,val);};\\n\" +\n"
                + "\"E :: E:val menos E:val2 {RESULT=val - val2;};\\n\" +\n"
                + "\"E :: E:val mas E:val2 {RESULT=val + val2;};\\n\" +\n"
                + "\"E :: E:val por E:val2 {RESULT=val * val2;};\\n\" +\n"
                + "\"E :: E:val div E:val2 {RESULT=val / val2;};\\n\" +\n"
                + "\"E :: entero1:val {RESULT=val;};\"");

        a.analisisCodigoLen(" //este es un comentario simple \n"
                + "nombre: java; /*comentario compuesto*/\n"
                + "version: 11.0.7;\n"
                + "autor: sun Microsystems;\n"
                + "lanzamiento: 1996;\n"
                + "extension: java ;\n"
                + "\n"
                + "%% \n"
                + "        { }\n"
                + "%% \n"
                + "palabra = [a-z]+;\n"
                + "entero1 = [0-9]+;\n"
                + "real1 = [0-9]+((\".\")[0-9]+)?;\n"
                + "más = \"+\";\n"
                + "menos = \"-\";\n"
                + "& = [\\n\\t]; \n"
                + "dato1 = (\"a\"|\"b\"|\\n); \n"
                + "dato2 = (\"a\")*; \n"
                + "dato3 = (\"a\")+; \n"
                + "dato4 = (\"a\")(\"b\")(\"c\"); \n"
                + "dato5 = (\"palabra\"); \n"
                + "\n"
                + "%% \n"
                + "terminal por, div;\n"
                + "terminal más, menos;\n"
                + "terminal entero1;\n"
                + "no terminal A, B;\n"
                + "no terminal S;\n"
                + "\n"
                + "%%\n"
                + "S :: E:val {printf(“Resultado = %d”,val);};\n"
                + "E :: E:val menos E:val2 {RESULT=val - val2;};\n"
                + "E :: E:val mas E:val2 {RESULT=val + val2;};\n"
                + "E :: E:val por E:val2 {RESULT=val * val2;};\n"
                + "E :: E:val div E:val2 {RESULT=val / val2;};\n"
                + "E :: entero1:val {RESULT=val;};");

    }

}
