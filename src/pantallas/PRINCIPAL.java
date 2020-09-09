package pantallas;

import analisEntrada.evaluacionLexica;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import lexico.errores;
import static p1_comp2.P1_COMP2.listaLeguajes;

/**
 *
 * @author esmeralda
 */
public class PRINCIPAL extends javax.swing.JFrame {

    /**
     * Creates new form PRINCIPAL
     */
    public static LinkedList<pestaña> pestañas = new LinkedList<>();
    public static LinkedList<errores> listaErroresGeneral = new LinkedList<>();
    public static String nombreLenguajeOficial = "";

    public PRINCIPAL() {
        initComponents();
        pestañas.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tabbedPaneArchivos = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTxtErrores = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombreLenguajeSeleccionado = new javax.swing.JLabel();
        btnBorrarPest = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        botonAbrir = new javax.swing.JMenu();
        botonNuevo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        botonGuardar = new javax.swing.JMenuItem();
        botonGuardarComo = new javax.swing.JMenuItem();
        botonSalir = new javax.swing.JMenuItem();
        menuLenguajes = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        botonCargarLenguajes = new javax.swing.JMenuItem();
        botonBorrarLenguajes = new javax.swing.JMenuItem();
        botonCompilar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        botoTablaLALR = new javax.swing.JMenuItem();
        botonPila = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.black);

        jPanel2.setBackground(new java.awt.Color(20, 248, 117));

        tabbedPaneArchivos.setBackground(java.awt.Color.white);
        tabbedPaneArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneArchivosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneArchivos)
                .addContainerGap())
        );

        areaTxtErrores.setColumns(20);
        areaTxtErrores.setRows(5);
        jScrollPane1.setViewportView(areaTxtErrores);

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("ERRORES");

        jLabel2.setForeground(java.awt.Color.orange);
        jLabel2.setText("LENGUAJE SELECCIONADO");

        lblNombreLenguajeSeleccionado.setForeground(java.awt.Color.cyan);
        lblNombreLenguajeSeleccionado.setText("---");

        btnBorrarPest.setBackground(new java.awt.Color(252, 61, 61));
        btnBorrarPest.setForeground(java.awt.Color.white);
        btnBorrarPest.setText("Cerrar Pestaña");
        btnBorrarPest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(lblNombreLenguajeSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                        .addComponent(btnBorrarPest)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)
                        .addContainerGap(228, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblNombreLenguajeSeleccionado)
                    .addComponent(btnBorrarPest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenuBar1.setBackground(java.awt.Color.black);
        jMenuBar1.setForeground(java.awt.Color.white);

        botonAbrir.setForeground(java.awt.Color.cyan);
        botonAbrir.setText("ARCHIVO");

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        botonAbrir.add(botonNuevo);

        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        botonAbrir.add(jMenuItem2);

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        botonAbrir.add(botonGuardar);

        botonGuardarComo.setText("Guardar Como");
        botonGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarComoActionPerformed(evt);
            }
        });
        botonAbrir.add(botonGuardarComo);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        botonAbrir.add(botonSalir);

        jMenuBar1.add(botonAbrir);

        menuLenguajes.setForeground(java.awt.Color.cyan);
        menuLenguajes.setText("LEGUAJES");
        menuLenguajes.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuLenguajesMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        menuLenguajes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuLenguajesKeyPressed(evt);
            }
        });
        jMenuBar1.add(menuLenguajes);

        jMenu3.setForeground(java.awt.Color.cyan);
        jMenu3.setText("EJECUTAR");
        jMenu3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu3KeyPressed(evt);
            }
        });

        botonCargarLenguajes.setText("Cargar Lenguaje");
        botonCargarLenguajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarLenguajesActionPerformed(evt);
            }
        });
        jMenu3.add(botonCargarLenguajes);

        botonBorrarLenguajes.setText("Borrar Lenguaje");
        botonBorrarLenguajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarLenguajesActionPerformed(evt);
            }
        });
        jMenu3.add(botonBorrarLenguajes);

        botonCompilar.setText("Compilar");
        botonCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompilarActionPerformed(evt);
            }
        });
        jMenu3.add(botonCompilar);

        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(java.awt.Color.cyan);
        jMenu4.setText("VER");
        jMenu4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jMenu4ItemStateChanged(evt);
            }
        });
        jMenu4.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu4MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu4KeyPressed(evt);
            }
        });

        botoTablaLALR.setText("Tabla LALR");
        botoTablaLALR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoTablaLALRActionPerformed(evt);
            }
        });
        jMenu4.add(botoTablaLALR);

        botonPila.setText("Pila");
        jMenu4.add(botonPila);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int i = tabbedPaneArchivos.getSelectedIndex();
        guardarArchivos(i);
    }//GEN-LAST:event_botonGuardarActionPerformed

    public void guardarArchivos(int i) {
        if (i != -1) {
            //verificar si existe path, sino mostrar pantalla de guardar como

            pestaña p = pestañas.get(i);
            String url = p.getURL();
            String texto = p.getAreaTxt().getText();
            String nombre = p.getNombreArchivo();
            lecturaArchivo l = new lecturaArchivo();
            if ("".equals(url)) {
                //mandamos como guardar como
                l.guardarArchivoNuevo(texto);
            } else {
                //mandamos como guardar
                l.guardarArchivoExistente(url, texto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue un archivo  para guardar");
        }
    }
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        JPanel panelTXT = new JPanel();
        JTextArea areaA = new JTextArea();
        NumeroLinea n = new NumeroLinea(areaA);
        JScrollPane scrollA = new JScrollPane(areaA) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(840, 500);
            }
        };
        scrollA.setRowHeaderView(n);
        panelTXT.add(scrollA);
        panelTXT.setVisible(true);

        int a = tabbedPaneArchivos.getTabCount() + 1;
        tabbedPaneArchivos.add(panelTXT, "Archivo " + a);
        pestaña p = new pestaña(areaA, "Archivo" + a, "");
        pestañas.add(p);
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void tabbedPaneArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneArchivosMouseClicked
    }//GEN-LAST:event_tabbedPaneArchivosMouseClicked

    private void btnBorrarPestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPestActionPerformed
        Component selected = tabbedPaneArchivos.getSelectedComponent();
        if (selected != null) {
            int a = tabbedPaneArchivos.getSelectedIndex();
            pestañas.remove(a);
            tabbedPaneArchivos.remove(selected);
        }
    }//GEN-LAST:event_btnBorrarPestActionPerformed

    private void botonCargarLenguajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarLenguajesActionPerformed

        int i = tabbedPaneArchivos.getSelectedIndex();
        areaTxtErrores.setText("");
        if (i != -1) {
            lecturaArchivo l = new lecturaArchivo();
            l.analizarCodigoLenguaje(i);
            //mostrar en panel los lenguajes cargados
            menuLenguajes.removeAll();;
            for (int j = 0; j < listaLeguajes.size(); j++) {
                String nombre = listaLeguajes.get(j).getNombreLenguaje();
                JMenuItem subMenu = new JMenuItem(nombre);
                subMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("presionado");
                        nombreLenguajeOficial = subMenu.getText();
                        lblNombreLenguajeSeleccionado.setText(nombreLenguajeOficial);
                    }
                });
                menuLenguajes.add(subMenu);
            }
            //mostrar errores si existen, limpiar lista
            for (int j = 0; j < listaErroresGeneral.size(); j++) {
                errores e = listaErroresGeneral.get(i);
                String dato = "\n\nTIPO: " + e.getTipo() + "\n"
                        + "TOKEN: " + e.getToken() + "\n"
                        + "FILA: " + e.getFila() + "\n"
                        + "COLUMNA: " + e.getColumnna() + "\n"
                        + "DESCRIPCION: " + e.getOtro();
                System.out.println(dato);
                areaTxtErrores.append(dato);
            }
            listaErroresGeneral.clear();
        } else {
            JOptionPane.showMessageDialog(null, "Cargue un archivo .len para analizar");
        }
    }//GEN-LAST:event_botonCargarLenguajesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            lecturaArchivo l = new lecturaArchivo();
            l.abrirArchivoLen();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void botonGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarComoActionPerformed
        int i = tabbedPaneArchivos.getSelectedIndex();
        if (i != -1) {
            pestaña p = pestañas.get(i);
            String texto = p.getAreaTxt().getText();
            lecturaArchivo l = new lecturaArchivo();
            l.guardarArchivoNuevo(texto);
        } else {
            JOptionPane.showMessageDialog(null, "Cargue un archivo  para guardar");
        }
    }//GEN-LAST:event_botonGuardarComoActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void menuLenguajesMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuLenguajesMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_menuLenguajesMenuSelected

    private void menuLenguajesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuLenguajesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuLenguajesKeyPressed

    private void jMenu3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu3KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3KeyPressed

    private void botoTablaLALRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoTablaLALRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botoTablaLALRActionPerformed

    private void jMenu4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4KeyPressed

    private void jMenu4MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu4MenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MenuKeyPressed

    private void jMenu4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMenu4ItemStateChanged

//        System.out.println("Presionado");
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ItemStateChanged

    private void botonBorrarLenguajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarLenguajesActionPerformed
        if (nombreLenguajeOficial.equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un lenguaje para eliminar");
        } else {
            for (int i = 0; i < listaLeguajes.size(); i++) {
                String nombreL = listaLeguajes.get(i).getNombreLenguaje();
                if (nombreL.equals(nombreLenguajeOficial)) {
                    listaLeguajes.remove(i);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el lenguaje-> " + nombreLenguajeOficial);
                } else {
                }
            }
            lblNombreLenguajeSeleccionado.setText("-----");
            //mostramos los lenguajes que quedan
            menuLenguajes.removeAll();
            for (int j = 0; j < listaLeguajes.size(); j++) {
                String nombre = listaLeguajes.get(j).getNombreLenguaje();
                JMenuItem subMenu = new JMenuItem(nombre);
                subMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("presionado");
                        nombreLenguajeOficial = subMenu.getText();
                        lblNombreLenguajeSeleccionado.setText(nombreLenguajeOficial);
                    }
                });
                menuLenguajes.add(subMenu);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBorrarLenguajesActionPerformed

    private void botonCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompilarActionPerformed
        int i = tabbedPaneArchivos.getSelectedIndex();
        areaTxtErrores.setText("");
        if (i != -1) {
            pestaña p = pestañas.get(i);
            String dato = p.getAreaTxt().getText();
            //procedemos a evlauar las cadenas de entrada 
            evaluacionLexica e = new evaluacionLexica();
            if (nombreLenguajeOficial.equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione un lenguaje");
            } else {
                e.analisisLenguajeSeleccionado(dato, nombreLenguajeOficial);                
            }
        }
    }//GEN-LAST:event_botonCompilarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea areaTxtErrores;
    private javax.swing.JMenuItem botoTablaLALR;
    private javax.swing.JMenu botonAbrir;
    private javax.swing.JMenuItem botonBorrarLenguajes;
    private javax.swing.JMenuItem botonCargarLenguajes;
    private javax.swing.JMenuItem botonCompilar;
    private javax.swing.JMenuItem botonGuardar;
    private javax.swing.JMenuItem botonGuardarComo;
    private javax.swing.JMenuItem botonNuevo;
    private javax.swing.JMenuItem botonPila;
    private javax.swing.JMenuItem botonSalir;
    private javax.swing.JButton btnBorrarPest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreLenguajeSeleccionado;
    private javax.swing.JMenu menuLenguajes;
    public static javax.swing.JTabbedPane tabbedPaneArchivos;
    // End of variables declaration//GEN-END:variables
}
