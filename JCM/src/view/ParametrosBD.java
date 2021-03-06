/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelo.Conecion;
import coneciones.GetConecion;

import coneciones.poolConecciones;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS_01
 */
public class ParametrosBD extends javax.swing.JFrame {

    /**
     * Creates new form Configur
     */
    String drive1 = "";
    ArrayList<Conecion> listConeciones = new ArrayList();
    Conecion conecion;
    Properties p = new Properties();
    boolean validacion;
    poolConecciones pool;

    public ParametrosBD(Conecion c) throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conecion = c;
        coneciones.addItem(c.getNombre());
        mns.setText(".");
        validacion = false;
        Host.setText("localhost");
        puerto.setText(conecion.getPuerto());
        BD.setText("");
        user.setText("");
        pass.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        coneciones = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Host = new javax.swing.JTextField();
        BD = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        puerto = new javax.swing.JTextField();
        mns = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 578, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 369, 578, 10));

        coneciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conecionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                conecionesMousePressed(evt);
            }
        });
        coneciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conecionesActionPerformed(evt);
            }
        });
        jPanel1.add(coneciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 400, -1));

        jButton3.setText("Siguiente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jLabel1.setText("JDBC URL :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel2.setText("Driver Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel3.setText("Host");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel4.setText("Date Base");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel5.setText("Puerto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel6.setText("User");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jTextField1.setEnabled(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 400, -1));

        Host.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostActionPerformed(evt);
            }
        });
        jPanel1.add(Host, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));
        jPanel1.add(BD, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 400, -1));
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 400, -1));

        jButton1.setText("Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 400, -1));
        jPanel1.add(puerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 80, -1));
        jPanel1.add(mns, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, -1));

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

    private void conecionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conecionesMouseClicked

    }//GEN-LAST:event_conecionesMouseClicked

    private void conecionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conecionesMousePressed

    }//GEN-LAST:event_conecionesMousePressed

    private void conecionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conecionesActionPerformed

    }//GEN-LAST:event_conecionesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (validacion) {

        } else {

        }
        this.dispose();
        try {
            new Pojos(p, conecion).setVisible(true);
        } catch (IOException ex) {
            System.out.println("error : " + ex.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ParametrosBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ParametrosBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void HostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HostActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            comprobarConecion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ParametrosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void comprobarConecion() throws ClassNotFoundException {
        try {

            if (Host.getText().length() == 0 || puerto.getText().length() == 0 || BD.getText().length() == 0 || BD.getText().length() == 0
                    || user.getText().length() == 0) {
                System.out.println("deben estar todos llenos");
                mns.setText("Llenar todos los campos");
            } else {
                System.out.println("todo bn");

                p.put("user", user.getText());
                p.put("password", pass.getText());
                p.put("BD", conecion.getNombre());
                p.put("Servidor", Host.getText());
                p.put("Puerto", puerto.getText());
                p.put("NameBD", BD.getText());
                p.put("driver", conecion.getDrive());

                pool = GetConecion.getControllerpool(p);
                if (pool != null) {
                    mns.setText("Conecto bien");
                    validacion = true;
                } else {
                    validacion = false;
                    mns.setText("Error de conecion");
                }
            }

        } catch (Exception ex) {

        } finally {

        }

    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BD;
    private javax.swing.JTextField Host;
    private javax.swing.JComboBox<String> coneciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mns;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField puerto;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
