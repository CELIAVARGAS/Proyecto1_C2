package pantallas;

import java.awt.Component;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author esmeralda
 */
public class PRINCIPAL extends javax.swing.JFrame {

    /**
     * Creates new form PRINCIPAL
     */
    public static LinkedList<pestaña> pestañas = new LinkedList<>();

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
        jLabel3 = new javax.swing.JLabel();
        btnBorrarPest = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        botonAbrir = new javax.swing.JMenu();
        botonNuevo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        botonGuardar = new javax.swing.JMenuItem();
        botonGuardarComo = new javax.swing.JMenuItem();
        botonSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
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
                .addComponent(tabbedPaneArchivos)
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

        jLabel3.setForeground(java.awt.Color.cyan);
        jLabel3.setText("---");

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
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                        .addComponent(btnBorrarPest))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
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

        jMenu2.setForeground(java.awt.Color.cyan);
        jMenu2.setText("LEGUAJES");
        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(java.awt.Color.cyan);
        jMenu3.setText("EJECUTAR");

        botonCargarLenguajes.setText("Cargar Lenguaje");
        botonCargarLenguajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarLenguajesActionPerformed(evt);
            }
        });
        jMenu3.add(botonCargarLenguajes);

        botonBorrarLenguajes.setText("Borrar Lenguaje");
        jMenu3.add(botonBorrarLenguajes);

        botonCompilar.setText("Compilar");
        jMenu3.add(botonCompilar);

        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(java.awt.Color.cyan);
        jMenu4.setText("VER");

        botoTablaLALR.setText("Tabla LALR");
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
                return new Dimension(930, 500);
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
        if (i != -1) {
            lecturaArchivo l = new lecturaArchivo();
             l.analizarCodigoLenguaje(i);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTabbedPane tabbedPaneArchivos;
    // End of variables declaration//GEN-END:variables
}
