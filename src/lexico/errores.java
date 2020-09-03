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
public class errores {
    String tipo;
    int fila;
    int columnna;
    String token;
    String otro;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumnna() {
        return columnna;
    }

    public void setColumnna(int columnna) {
        this.columnna = columnna;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public errores(String tipo, int fila, int columnna, String token, String otro) {
        this.tipo = tipo;
        this.fila = fila;
        this.columnna = columnna;
        this.token = token;
        this.otro = otro;
    }
    
}
