/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JOptionPane;

/**
 *
 * @author labctr
 */
public class vtnPrincipal extends javax.swing.JFrame {

    public static void vermensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);

    }

    public vtnPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnuOpciones = new javax.swing.JMenu();
        mniRgistroCalificacion = new javax.swing.JMenuItem();
        mniRegistroMatricula = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();
        mnuEstudiante = new javax.swing.JMenu();
        mniEstudiante = new javax.swing.JMenuItem();
        mniReporteCalificaciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuOpciones.setMnemonic('f');
        mnuOpciones.setText("Opciones");

        mniRgistroCalificacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mniRgistroCalificacion.setMnemonic('o');
        mniRgistroCalificacion.setText("Registro de Calificaciones");
        mniRgistroCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRgistroCalificacionActionPerformed(evt);
            }
        });
        mnuOpciones.add(mniRgistroCalificacion);

        mniRegistroMatricula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mniRegistroMatricula.setMnemonic('s');
        mniRegistroMatricula.setText("Registro de Matricula");
        mniRegistroMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegistroMatriculaActionPerformed(evt);
            }
        });
        mnuOpciones.add(mniRegistroMatricula);

        mniSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniSalir.setMnemonic('x');
        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mnuOpciones.add(mniSalir);

        menuBar.add(mnuOpciones);

        mnuEstudiante.setText("Estudiantes");

        mniEstudiante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniEstudiante.setText("Nuevo Estudiante");
        mniEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEstudianteActionPerformed(evt);
            }
        });
        mnuEstudiante.add(mniEstudiante);

        mniReporteCalificaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniReporteCalificaciones.setMnemonic('r');
        mniReporteCalificaciones.setText("Reporte de Calificaciones");
        mniReporteCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteCalificacionesActionPerformed(evt);
            }
        });
        mnuEstudiante.add(mniReporteCalificaciones);

        menuBar.add(mnuEstudiante);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSalirActionPerformed

    private void mniRgistroCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRgistroCalificacionActionPerformed
        frmRegistroCalificaciones c = new frmRegistroCalificaciones();
        this.desktopPane.add(c);
        c.show();
    }//GEN-LAST:event_mniRgistroCalificacionActionPerformed

    private void mniRegistroMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistroMatriculaActionPerformed
        frmRegistroMatricula m = new frmRegistroMatricula();
        this.desktopPane.add(m);
        m.show();
    }//GEN-LAST:event_mniRegistroMatriculaActionPerformed

    private void mniEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEstudianteActionPerformed
        frmRegistroEstudiantes e = new frmRegistroEstudiantes();
        this.desktopPane.add(e);
        e.show();

    }//GEN-LAST:event_mniEstudianteActionPerformed

    private void mniReporteCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniReporteCalificacionesActionPerformed
        frmReporteCalificaciones r = new frmReporteCalificaciones();
        this.desktopPane.add(r);
        r.show();
    }//GEN-LAST:event_mniReporteCalificacionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mniEstudiante;
    private javax.swing.JMenuItem mniRegistroMatricula;
    private javax.swing.JMenuItem mniReporteCalificaciones;
    private javax.swing.JMenuItem mniRgistroCalificacion;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenu mnuEstudiante;
    private javax.swing.JMenu mnuOpciones;
    // End of variables declaration//GEN-END:variables

}
