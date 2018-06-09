/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelo.forenKeys;
import Modelo.Conecion;
import coneciones.GetConecion;
import coneciones.poolConecciones;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author ASUS_01
 */
public class Pojos extends javax.swing.JFrame {

    Properties propiedade;
    Conecion c;
    Conecion c2;
    ArrayList<String> ListTable = new ArrayList();
    ArrayList<String> ListTable2 = new ArrayList();
    ArrayList<forenKeys> listForenKey = new ArrayList();
    String tablas = "";
    poolConecciones pool=new poolConecciones();
    public Connection con;

    public Pojos(Properties p, Conecion c) throws IOException, SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.propiedade = p;
        this.c2 = c;
        coneciones.addItem(c.getNombre());
        mns.setText(".");
        pool = GetConecion.getControllerpool(p);
        conectarPojos();
    }

    public void conectarPojos() throws SQLException, ClassNotFoundException {
        ListTable.clear();
        try {            
            System.out.println("Holaaa");
            if(pool==null){
                System.out.println("poll null");
            }
            con = pool.dataSource.getConnection();
            DatabaseMetaData metaDatos = con.getMetaData();
            System.out.println("-----");
            String v[] = {"TABLE"};
            ResultSet rs = metaDatos.getTables(null, null, null, v);
            while (rs.next()) {
                ListTable.add(rs.getString(3));
            }
            listForenKey = forenKeys(1);
            for (forenKeys string : listForenKey) {
                System.out.println("-- " + string.toString());
            }
            cargarlist();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        } finally {
            con.close();
        }

    }

    public void cargarlist() {
        DefaultListModel listModel = new DefaultListModel();
        for (String string : ListTable) {
            listModel.addElement(string);
        }
        jList2 = new javax.swing.JList<>();
        jList2.setModel(listModel);
        jScrollPane2.setViewportView(jList2);
    }

    public void cargarlist2() {
        DefaultListModel listModel = new DefaultListModel();
        for (String string : ListTable2) {
            listModel.addElement(string);
        }
        jList1 = new javax.swing.JList<>();
        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);
    }

    public void pasarListAll() throws SQLException {
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> remove = new ArrayList();

        for (String string : ListTable2) {
            listModel.addElement(string);
            if (buscarTabla(ListTable2, string) == false) {
                ListTable2.add(string);
            }
        }

        for (String string : ListTable) {
            listModel.addElement(string);
            if (buscarTabla(ListTable2, string) == false) {
                ListTable2.add(string);
            }
        }

        for (String list1 : ListTable2) {
            for (String list2 : ListTable) {
                if (list1.trim().equalsIgnoreCase(list2.trim())) {
                    remove.add(list2);
                }
            }
        }
        for (String list1 : remove) {
            ListTable.remove(list1);
        }

        jList1 = new javax.swing.JList<>();
        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);

        cargarlist();
    }

    public void quitarListAll() throws SQLException {
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> remove = new ArrayList();

        for (String string : ListTable) {
            listModel.addElement(string);
            if (buscarTabla(ListTable, string) == false) {
                ListTable.add(string);
            }
        }

        for (String string : ListTable2) {
            listModel.addElement(string);
            if (buscarTabla(ListTable, string) == false) {
                ListTable.add(string);
            }
        }

        for (String list1 : ListTable) {
            for (String list2 : ListTable2) {
                if (list1.trim().equalsIgnoreCase(list2.trim())) {
                    remove.add(list2);
                }
            }
        }
        for (String list1 : remove) {
            ListTable2.remove(list1);
        }

        jList2 = new javax.swing.JList<>();
        jList2.setModel(listModel);
        jScrollPane2.setViewportView(jList2);

        cargarlist2();
    }

    public void pasarList() throws SQLException {
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> remove = new ArrayList();
        boolean r = false;
        for (String tablas : jList2.getSelectedValuesList()) {
            for (forenKeys fk : listForenKey) {
                if (tablas.trim().equalsIgnoreCase(fk.getTableReference().trim())) {
                    if (buscarTabla(ListTable2, fk.getTable()) == false) {
                        ListTable2.add(fk.getTable());
                    }
                }
            }
            if (buscarTabla(ListTable2, tablas) == false) {
                ListTable2.add(tablas);
            }
        }
        remove.clear();

        for (String string : ListTable2) {
            listModel.addElement(string);

        }

        for (String list1 : ListTable2) {
            for (String list2 : ListTable) {
                if (list1.trim().equalsIgnoreCase(list2.trim())) {
                    remove.add(list2);
                }
            }
        }
        for (String list1 : remove) {
            ListTable.remove(list1);
        }

        jList1 = new javax.swing.JList<>();
        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);

        cargarlist();
    }

    public void quitarList() throws SQLException {
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> remove = new ArrayList();
        boolean r = false;
        for (String tablas : jList1.getSelectedValuesList()) {
            for (forenKeys fk : listForenKey) {
                if (tablas.trim().equalsIgnoreCase(fk.getTableReference().trim())) {
                    if (buscarTabla(ListTable, fk.getTable()) == false) {
                        ListTable.add(fk.getTable());
                    }
                }
            }
            if (buscarTabla(ListTable, tablas) == false) {
                ListTable.add(tablas);
            }
        }
        remove.clear();

        for (String string : ListTable) {
            listModel.addElement(string);

        }

        for (String list1 : ListTable) {
            for (String list2 : ListTable2) {
                if (list1.trim().equalsIgnoreCase(list2.trim())) {
                    remove.add(list2);
                }
            }
        }
        for (String list1 : remove) {
            ListTable2.remove(list1);
        }

        jList2 = new javax.swing.JList<>();
        jList2.setModel(listModel);
        jScrollPane2.setViewportView(jList2);

        cargarlist2();
    }

    public int repetido(ArrayList<String> ListTable2, String tabla) {
        int b = 0;
        for (String tablas : ListTable2) {
            if (tablas.trim().equalsIgnoreCase(tabla.trim())) {
                b++;
            }
        }
//        if (b > 1) {
//
//            for (String tablas : ListTable2) {
//                if (tablas.trim().equalsIgnoreCase(tabla.trim())) {
//                    ListTable2.remove(tablas);
//                    break;
//                }
//            }
//        }
        return b;
    }

    public boolean buscarTabla(ArrayList<String> ListTable2, String tabla) {
        boolean r = false;
        for (String tablas : ListTable2) {
            if (tablas.trim().equalsIgnoreCase(tabla.trim())) {
                r = true;
                break;
            }
        }
//        if (b > 1) {
//
//            for (String tablas : ListTable2) {
//                if (tablas.trim().equalsIgnoreCase(tabla.trim())) {
//                    ListTable2.remove(tablas);
//                    break;
//                }
//            }
//        }
        return r;
    }

    public ArrayList<forenKeys> forenKeys(int condicion) throws SQLException {
        ArrayList<forenKeys> listForenKey = new ArrayList();
        DatabaseMetaData metaDatos = con.getMetaData();
        String v[] = {"TABLE"};
        ResultSet rs = metaDatos.getTables(null, null, null, v);
        while (rs.next()) {
            String tabla = rs.getString(3);
            ResultSet rs4 = metaDatos.getExportedKeys(null, null, tabla);
            while (rs4.next()) {
//                fkTableName = fkTableName + "List<" + rs4.getString("FKTABLE_NAME") + "> List_" + rs4.getString("FKTABLE_NAME") + " = new ArrayList();\n";
                String forenK = rs4.getString("FKTABLE_NAME");
                String fkColumnName = rs4.getString("FKCOLUMN_NAME");
                if (condicion == 1) {
                    listForenKey.add(new forenKeys(tabla, forenK));
                    System.out.println("reference : " + tabla + " ListTable2  : " + forenK);
//                importaciones = importaciones + "import java.util.List;\n";
                } else if (condicion == 2) {
                    listForenKey.add(new forenKeys(tabla, forenK, fkColumnName));
                    System.out.println("reference : " + tabla + " ListTable2  : " + forenK);
                }
            }

        }
        return listForenKey;
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
        jLabel2 = new javax.swing.JLabel();
        mns = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        controladores = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        FolderPojos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jPanel1.add(coneciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 420, -1));

        jButton3.setText("Finish");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jLabel2.setText("Folder");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));
        jPanel1.add(mns, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, -1));

        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 180, 200));

        jScrollPane2.setViewportView(jList2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 200));

        controladores.setText("Crear Controladores y View");
        jPanel1.add(controladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jButton4.setText(">>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jButton5.setText("<<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        jLabel3.setText("Date Base");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));
        jPanel1.add(FolderPojos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 420, -1));

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
        this.dispose();
        try {
            if (controladores.isSelected()) {
                new Controladores(ListTable2, propiedade, this.c2, FolderPojos.getText()).setVisible(true);
            } else {
                new CreacionJCM(ListTable2, controladores.isSelected(), propiedade, c, FolderPojos.getText(), "", 3).setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            pasarList();
        } catch (SQLException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            pasarListAll();
        } catch (SQLException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            quitarList();
        } catch (SQLException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            quitarListAll();
        } catch (SQLException ex) {
            Logger.getLogger(Pojos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public void siguiente() {
        System.out.println("Entro");
        for (int string : jList2.getSelectedIndices()) {
            System.out.println("--- " + string);
        }
        for (String string : jList2.getSelectedValuesList()) {
            System.out.println("--- " + string);
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FolderPojos;
    private javax.swing.JComboBox<String> coneciones;
    private javax.swing.JCheckBox controladores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel mns;
    // End of variables declaration//GEN-END:variables
}
