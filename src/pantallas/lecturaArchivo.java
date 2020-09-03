/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static pantallas.PRINCIPAL.areaTxtErrores;
import static pantallas.PRINCIPAL.pestañas;
import static pantallas.PRINCIPAL.tabbedPaneArchivos;
import analisis.generadorLexicoSintactico;

/**
 *
 * @author esmeralda
 */
public class lecturaArchivo {

    public String abrirArchivoLen() throws FileNotFoundException {
        String frase = " ";
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser(".");
        FileFilter filtro = new FileNameExtensionFilter("Archivos len (.len)", "len");
        fileChooser.setFileFilter(filtro);
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                File f = new File(ruta);
                entrada = new Scanner(f);
                while (entrada.hasNext()) {
                    frase = frase + entrada.nextLine() + "\n";
                }
                String nombreA = nombreArchivo(ruta);
                //agregamos el texto en areatxt, y luego en panel  
                JPanel panelA = new JPanel();
                JTextArea areat = new JTextArea();
                areat.setText(frase);
                NumeroLinea n = new NumeroLinea(areat);
                JScrollPane jsp = new JScrollPane(areat) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(930, 500);
                    }
                };
                jsp.setRowHeaderView(n);
                panelA.add(jsp);
                panelA.setVisible(true);

                pantallas.PRINCIPAL.tabbedPaneArchivos.add(panelA, nombreA);
                int a = tabbedPaneArchivos.getTabCount() + 1;
                pestaña p = new pestaña(areat, nombreA, ruta);
                pestañas.add(p);

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
        } else {
            System.out.println("No se ha seleccionado ningún fichero");
        }
        return frase;
    }

    public void guardarArchivoExistente(String ruta, String texto) {
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL ARCHIVO " + ruta);
        } catch (Exception e) {
            e.printStackTrace();
            areaTxtErrores.append("Error no se guardo su archivo");
        }

    }

    public void guardarArchivoNuevo(String texto) {
        String nombreA = "";
        try {
            JFileChooser file = new JFileChooser(".");
            file.showSaveDialog(file);
            File guarda = file.getSelectedFile();
            if (guarda != null) {
                nombreA = nombreArchivo(guarda.getPath());
                FileWriter save = new FileWriter(guarda);
                save.write(texto);
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente" + nombreA,
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error no selecciono donde guardar archivo");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public String nombreArchivo(String nombre) {
        String nombreA = "";
        String[] arreglo = nombre.split("\\/");
        nombreA = arreglo[arreglo.length - 1];
        return nombreA;
    }

    public  void analizarCodigoLenguaje(int indice) {
        pestaña p = pestañas.get(indice);
        String dato = p.getAreaTxt().getText();
        generadorLexicoSintactico g = new generadorLexicoSintactico();
        System.out.println(dato);
        g.analisisCodigoLen(" \n" +
"nombre: java;\n" +
"version: 11.0.7;\n" +
"autor: sun Microsystems;\n" +
"lanzamiento: 1996;\n" +
"extension: java ;\n" +
"\n" +
"%% \n" +
"List<String> listString=new ArrayList<>();\n" +
"public void addString(String valor){\n" +
"listString.add(valor);\n" +
"}\n" +
"public Integer suma(Integer numero1,Integer numero2){\n" +
"return numero1+numero2;\n" +
"}\n" +
"\n" +
"%% \n" +
"palabra = [a-z]+;\n" +
"entero = [0-9]+;\n" +
"real = [0-9]+((.)[0-9]+)?;\n" +
"más = “+”;\n" +
"menos = “-”;\n" +
"& = [\\n\\t]; \n" +
"\n" +
"%% \n" +
"terminal por, div;\n" +
"terminal más, menos;\n" +
"terminal entero;\n" +
"no terminal A, B;\n" +
"no terminal S;\n" +
"\n" +
"%%\n" +
"S :: E:val {printf(“Resultado = %d”,val);};\n" +
"E :: E:val menos E:val2 {RESULT=val - val2;};\n" +
"E :: E:val mas E:val2 {RESULT=val + val2;};\n" +
"E :: E:val por E:val2 {RESULT=val * val2;};\n" +
"E :: E:val div E:val2 {RESULT=val / val2;};\n" +
"E :: entero:val {RESULT=val;};");
    }
}
