/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import rivera.Util;
import beu.Curso;
import beu.Matricula;
import bll.GestionCurso;
import bll.GestionMatricula;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author labctr
 */
public class frmReporteCalificaciones extends javax.swing.JInternalFrame {

    private final String titulo = "Reporte de Calificaciones";
    private GestionCurso cursosBll = new GestionCurso();
    private GestionMatricula matriculaBll = new GestionMatricula();
    private List<Curso> cursos;
    private final DefaultTableModel dtmCalificaciones = new DefaultTableModel();
    private List<Matricula> calificaciones;

    private void configurarModeloTabla(){
        String[] columnas = {"Nombre ", "Promedio", "Estado"};
        this.dtmCalificaciones.setColumnIdentifiers(columnas);
        this.tblCalificaciones.setModel(dtmCalificaciones);
    }
    
    private void leerCursos() {
        try {
            Curso ficticio = new Curso("--Seleccione--", 0.0f, "");
            this.cmbCursos.addItem(ficticio);

            cursos = cursosBll.getCursos();
            for (Curso c : cursos) {
                this.cmbCursos.addItem(c);

            }

        } catch (IOException e) {
            Util.imprimir("Error:" + e.toString());
            vtnPrincipal.vermensaje("Error al leer los cursos", titulo, JOptionPane.ERROR_MESSAGE);

        }

    }

    private void buscarMatricula() throws IOException{
        Curso seleccionado = (Curso) cmbCursos.getSelectedItem();
        calificaciones = matriculaBll.reportar(seleccionado.getTitulo());  
        mostrarCalificaciones();
    }
    
    private void mostrarCalificaciones(){
        //Elimina las fials de la tabla
        int lim = dtmCalificaciones.getRowCount() - 1;
        for(int i = lim; i >= 0; i++){
            this.dtmCalificaciones.removeRow(i);
        }
       for(Matricula m: calificaciones){
           Vector fila = new Vector();
           fila.addElement(m.getEstudiante());
           fila.addElement(m.getPromedio());
           fila.addElement(m.getEstado());
           this.dtmCalificaciones.addRow(fila);
       }
       this.tblCalificaciones.setModel(dtmCalificaciones);
    }
    
    public frmReporteCalificaciones() {
        initComponents();
        leerCursos();
        this.configurarModeloTabla();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalificaciones = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte de Calificaciones");

        jLabel1.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        jLabel1.setText("Reporte de  Calificaciones");

        lblCurso.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        lblCurso.setText("Curso:");

        btnBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\59398\\Desktop\\Imagenes Proyecto\\iconos\\search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCalificaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            buscarMatricula();
        } catch (Exception e) {

            Util.imprimir("Error:" + e.toString());
            vtnPrincipal.vermensaje("Error al buscar"
                    + " matriculas ", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JTable tblCalificaciones;
    // End of variables declaration//GEN-END:variables
}
