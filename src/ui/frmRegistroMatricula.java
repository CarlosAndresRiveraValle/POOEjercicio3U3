/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import rivera.Util;
import beu.Curso;
import beu.Estudiante;
import bll.GestionCurso;
import bll.GestionEstudiante;
import bll.GestionMatricula;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author labctr
 */
public class frmRegistroMatricula extends javax.swing.JInternalFrame {

    private final String titulo = "Registrar Matricula";
    //Servicio//Bussiness Logic Layer
    private GestionCurso cursosBll = new GestionCurso();
    private GestionEstudiante estudiantesBll = new GestionEstudiante();
    private GestionMatricula matriculaBll = new GestionMatricula();
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;

    private boolean Validar() {
        Curso cr = (Curso) this.cmbCursos.getSelectedItem();
        Estudiante est = (Estudiante) this.cmbEstudiantes.getSelectedItem();

        if (cr.getTitulo().equals("--Seleccione--")) {
            vtnPrincipal.vermensaje("Curso no valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (est.getCedula() == null) {
            vtnPrincipal.vermensaje("Estudiante no valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void crearMatricula() throws IOException {

        Curso cr = (Curso) this.cmbCursos.getSelectedItem();
        Estudiante est = (Estudiante) this.cmbEstudiantes.getSelectedItem();
        matriculaBll.crear();
        matriculaBll.configurar(cr, est);
        matriculaBll.archivar();

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

    private void leerEstudiantes() {
        try {
            Estudiante ficticio = new Estudiante();
            ficticio.setNombre("--Seleccione--");
            ficticio.setApellido("");
            this.cmbEstudiantes.addItem(ficticio);

            estudiantes = estudiantesBll.leerEstudiantes();

            estudiantes.forEach((est) -> {
                this.cmbEstudiantes.addItem(est);
            });

        } catch (IOException e) {
            Util.imprimir("Error:" + e.toString());
            vtnPrincipal.vermensaje("Error al leer los estudiantes", titulo, JOptionPane.ERROR_MESSAGE);

        }

    }

    public frmRegistroMatricula() {
        initComponents();
        leerCursos();
        leerEstudiantes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegistroMatricula = new javax.swing.JLabel();
        lblEstudiante = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        cmbEstudiantes = new javax.swing.JComboBox<>();
        cmbCursos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Matriculas");

        lblRegistroMatricula.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        lblRegistroMatricula.setText("Registro de Matricula");

        lblEstudiante.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        lblEstudiante.setText("Estudiante:");
        lblEstudiante.setToolTipText("");

        lblCurso.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        lblCurso.setText("Curso:");

        cmbEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstudiantesActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblRegistroMatricula))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCurso)
                            .addComponent(lblEstudiante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEstudiantes, 0, 190, Short.MAX_VALUE)
                            .addComponent(cmbCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistroMatricula)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstudiante)
                            .addComponent(cmbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso)
                            .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(39, 39, 39))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstudiantesActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (Validar()) {
                crearMatricula();
                vtnPrincipal.vermensaje(" Matricula creada correctamente", titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Util.imprimir("Error:" + e.toString());
            vtnPrincipal.vermensaje("Error al crear la Matricula ", titulo, JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JComboBox<Estudiante> cmbEstudiantes;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblRegistroMatricula;
    // End of variables declaration//GEN-END:variables
}
