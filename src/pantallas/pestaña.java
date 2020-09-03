package pantallas;

import javax.swing.JTextArea;

/**
 *
 * @author esmeralda
 */

public class pestaña {
    
    JTextArea areaTxt;
    String nombreArchivo;
    String URL;

    public pestaña(JTextArea areaTxt, String nombreArchivo, String URL) {
        this.areaTxt = areaTxt;
        this.nombreArchivo = nombreArchivo;
        this.URL = URL;
    }

    public JTextArea getAreaTxt() {
        return areaTxt;
    }

    public void setAreaTxt(JTextArea areaTxt) {
        this.areaTxt = areaTxt;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
