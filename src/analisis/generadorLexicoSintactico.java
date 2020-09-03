
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author esmeralda
 */
public class generadorLexicoSintactico {
    

    public  void Compiladores_C() {
        try {
            String ruta = "src/analisis/";
            String opcFlex[] = {ruta + "analisisLexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            String opcCUP[] = {"-destdir", ruta, "-parser", "parserC", ruta + "analisisSintactico.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

      public  void analisisCodigoLen(String texto) {
        try {
            System.out.println("************************ Inicia analisis codigo .len... ************************");
            scanner scan = new scanner(new BufferedReader(new StringReader(texto)));
            parserC parser = new parserC(scan);
            parser.parse();
            System.out.println("\n************************ Finaliza analisis codigo .len... ************************");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }

}
