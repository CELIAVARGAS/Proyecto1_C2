/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

/**
 *
 * @author esmeralda
 */
public class tokensLeidos {

    String nombreLexema;
    String valorString;

    public tokensLeidos(String nombreLexema, String valorString) {
        this.nombreLexema = nombreLexema;
        this.valorString = valorString;
    }

    public String getNombreLexema() {
        return nombreLexema;
    }

    public void setNombreLexema(String nombreLexema) {
        this.nombreLexema = nombreLexema;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
    }
    

    
    
    
}
