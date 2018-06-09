/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Modelo.Conecion;
import Modelo.forenKeys;
import coneciones.GetConecion;
import coneciones.poolConecciones;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreacionJCM extends javax.swing.JFrame implements Runnable {

    ArrayList<String> Listablas = new ArrayList();
    int porcentaje;
    boolean boolControl;
    double rowcount;
    Thread Hilo1;
    Properties propiedade;
    Conecion c;
    String folder;
    String folder2;
    int temp;
    poolConecciones pool = new poolConecciones();
    public Connection con;

    public CreacionJCM(ArrayList<String> tablas, boolean controladores, Properties propiedade, Conecion c, String Folder, String folder2, int temp) throws IOException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        Listablas = tablas;
        System.out.println("tablas selecionadas");
        for (String tabla : tablas) {
            System.out.println("-- " + tabla);
        }
        porcentaje = 1;
        progreso.setValue(porcentaje);
        progreso.setStringPainted(true);
        this.Hilo1 = new Thread(this);
        this.boolControl = controladores;
        this.propiedade = propiedade;
        this.c = c;
        this.folder = Folder;
        this.folder2 = folder2;
        this.temp = temp;
        System.out.println("folder : " + Folder);
        System.out.println("folder 2 : " + folder2);
        pool = GetConecion.getControllerpool(propiedade);
        Hilo1.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        mns = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        progreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 578, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 578, 10));
        jPanel1.add(mns, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, -1));

        jLabel1.setText("Creando paquetes....");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel1.add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 64, 540, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mapeoEntity() throws IOException, SQLException, ClassNotFoundException {
        try {

            con = pool.dataSource.getConnection();
            ArrayList<forenKeys> listForenKey = new ArrayList();
            listForenKey = forenKeys( 1);
            //        sqlServer conecion = sqlServer.getDbCon();
            //Swing
//        String f = "src/JAJA";
//        String util = "src/util";
//        String persistencia = "src/JAJA/Persistencia.java";
//        String Utilidad = "src/JAJA/Util.java";
//        String rutaModelo = "src/JAJA";

            //WEB
            String f = "src/java/" + this.folder;
            String rutaConecion = "src/java/Conecion";
            String util = "src/java/util";
            String persistencia = "src/java/" + this.folder + "/Persistencia.java";
            String poolConecion = "src/java/Conecion/poolConeciones.java";
            String Utilidad = "src/java/" + this.folder + "/Util.java";
            String rutaModelo = "src/java/" + this.folder;
            String rutaBeans = "";
            File folder = new File(f);
            folder.mkdir();

            File folderConecion = new File(rutaConecion);
            folderConecion.mkdir();

//        File folderUtil = new File(util);
//        folderUtil.mkdir();
//        String ruta = "src/JAJA/prueba.java";
            String camposBD = "";
            String GeterSeter = "";
            String prepareInsert = "";
            String InsertValores = "";
            String TipoDato = "";
            String CamposBDCopy = "";
            String prepareEdit = "";
            String fkTableName = "";
            String CamposResulset = "";
            boolean esKey = false;
            ArrayList<String> primaryKey = new ArrayList();
            String keysTable = "";
            String importaciones = "";
            boolean TieneCampos = false;
            boolean TieneLLaves = false;
            boolean TienePrimary = false;
            boolean CrearTabla = false;
            int posicion = 0;
            int porcentajenum = 0;

            BufferedWriter bw = null;

            bw = new BufferedWriter(new FileWriter(poolConecion));
            bw.write("package Conecion;\n"
                    + "import java.sql.Connection;\n"
                    + "import java.sql.ResultSet;\n"
                    + "import java.sql.SQLException;\n"
                    + "import java.sql.Statement;\n"
                    + "import javax.sql.DataSource;\n"
                    + "import javax.swing.JOptionPane;\n"
                    + "import org.apache.commons.dbcp.BasicDataSource;\n"
                    + "\n"
                    + "public class poolConeciones {\n"
                    + "\n"
                    + "    public static Statement stat;\n"
                    + "    public  Connection con;\n"
                    + "    public DataSource dataSource;\n"
                    + "\n"
                    + "    public poolConeciones(BasicDataSource basicDataSource) {\n"
                    + "        dataSource = basicDataSource;\n"
                    + "    }\n"
                    + "\n"
                    + "    public ResultSet query(String query) throws SQLException {\n"
                    + "        con = dataSource.getConnection();\n"
                    + "        stat = con.createStatement();\n"
                    + "        ResultSet res = stat.executeQuery(query);\n"
                    + "        return res;\n"
                    + "    }\n"
                    + "\n"
                    + "    public int transaccion(String insertQuery) throws SQLException {\n"
                    + "        con = dataSource.getConnection();\n"
                    + "        stat = con.createStatement();\n"
                    + "        int result = stat.executeUpdate(insertQuery);\n"
                    + "        return result;\n"
                    + "    }\n"
                    + "\n"
                    + "public void probarConecion() {\n"
                    + "        try {\n"
                    + "            con = dataSource.getConnection();\n"
                    + "            if (con != null) {\n"
                    + "                JOptionPane.showMessageDialog(null, \"Conectado\");\n"
                    + "            }\n"
                    + "        } catch (SQLException e) {\n"
                    + "            System.out.println(e);\n"
                    + "        } finally {\n"
                    + "            try {\n"
                    + "                con.close();\n"
                    + "            } catch (SQLException ex) {\n"
                    + "                System.out.println(ex);\n"
                    + "            }\n"
                    + "        }\n"
                    + "    }\n"
                    + "    public Connection getconecion() {\n"
                    + "        return con;\n"
                    + "    }\n"
                    + "\n"
                    + "}\n"
                    + ""
                    + "");
            bw.close();

            String url = "";
            if (propiedade.getProperty("BD").equalsIgnoreCase("postgresql")) {
                url = "jdbc:" + propiedade.getProperty("BD") + "://"
                        + propiedade.getProperty("Servidor") + ":" + propiedade.getProperty("Puerto") + "/" + propiedade.getProperty("NameBD");
            } else if (propiedade.getProperty("BD").equalsIgnoreCase("sqlserver")) {
                url = "jdbc:" + propiedade.getProperty("BD") + "://"
                        + propiedade.getProperty("Servidor") + ":" + propiedade.getProperty("Puerto") + ";databaseName=" + propiedade.getProperty("NameBD");
            }

            bw = new BufferedWriter(new FileWriter(persistencia));
            bw.write("\n"
                    + "package " + this.folder + ";"
                    + "import java.util.List;\n"
                    + "import Conecion.poolConeciones;\n"
                    + "import org.apache.commons.dbcp.BasicDataSource;\n"
                    + "abstract class Persistencia {\n"
                    + "\n"
                    + "    BasicDataSource DataSource = new BasicDataSource();\n"
                    + "    poolConeciones pool;\n"
                    + "\n"
                    + " public Persistencia() {\n"
                    + "        DataSource.setDriverClassName(\"" + propiedade.getProperty("driver") + "\");\n"
                    + "        DataSource.setUsername(\"" + propiedade.getProperty("user") + "\");\n"
                    + "        DataSource.setPassword(\"" + propiedade.getProperty("password") + "\");\n"
                    + "        DataSource.setUrl(\"" + url + "\");\n"
                    + "        DataSource.setMaxActive(50);\n"
                    + "        pool=new poolConeciones(DataSource);\n"
                    + "}\n"
                    + "    public abstract int create();\n"
                    + "\n"
                    + "    public abstract int edit();\n"
                    + "\n"
                    + "    public abstract int remove();\n"
                    + "\n"
                    + "    public abstract List List();\n"
                    + "\n"
                    + "\n"
                    + "    public poolConeciones getConecion() {\n"
                    + "      return pool;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setConecion(poolConeciones pool) {\n"
                    + "      this.pool = pool;\n"
                    + "    }\n"
                    + "\n"
                    + "}\n"
                    + "");
            bw.close();

            int a = 1;
            int count = 0;
            DatabaseMetaData metaDatos = con.getMetaData();
            String v[] = {"TABLE"};
            ResultSet rs = metaDatos.getTables(null, null, null, v);

            if (rs.last()) {
                rowcount = rs.getRow();
                rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }
            System.out.println("cant : " + rowcount);
            porcentajenum = (int) ((rowcount / 100) * 100);
            if (boolControl) {
                porcentajenum = porcentajenum / 2;
            }
            System.out.println("porcentaje a sumar : " + porcentajenum);
            while (rs.next()) {
                porcentaje += porcentajenum;
                System.out.println("------------------------ :: " + porcentaje);
                progreso.setValue(porcentaje);
                progreso.setStringPainted(true);
                camposBD = "";
                GeterSeter = "";
                prepareInsert = "";
                InsertValores = "";
                importaciones = "";
                keysTable = "";
                primaryKey.clear();
                prepareEdit = "";
                TieneCampos = false;
                TieneLLaves = false;
                TienePrimary = false;
                CrearTabla = false;
                fkTableName = "";
                CamposResulset = "";
                posicion = 1;

                String catalogo = rs.getString(1);
                String tabla = rs.getString(3);
                String tabla2 = rs.getString(4);
                System.out.println("-- " + rs.getString(2));
                System.out.println("-- " + rs.getString(4));
//            System.out.println("TABLA=" + tabla + " -- "  +tabla2);

                for (String table : Listablas) {
                    if (table.trim().equalsIgnoreCase(tabla)) {
                        CrearTabla = true;
                    }
                }

                if (CrearTabla) {

                    rutaModelo = "src/java/" + this.folder + "/" + tabla + ".java";
                    rutaBeans = "src/java/Beans/" + tabla + ".java";
//                rutaModelo = "src/JAJA/" + tabla + ".java";
//                rutaBeans = "src/Beans/" + tabla + ".java";
                    File archivo = new File(rutaModelo);
                    File archivoBean = new File(rutaModelo);

                    ResultSet rs3 = metaDatos.getPrimaryKeys(null, null, tabla);
                    while (rs3.next()) {
//                System.out.println("---");
                        String pkey = rs3.getString("COLUMN_NAME");
                        primaryKey.add(pkey);
//                System.out.println("primary key = " + pkey);
                    }

                    ResultSet rs2 = metaDatos.getColumns(catalogo, null, tabla, null);

                    while (rs2.next()) {
                        String nombreColumna = rs2.getString(4);
                        String tipoColumna = rs2.getString(6);
                        CamposBDCopy = nombreColumna;
                        esKey = false;
                        String isAutoIncrement = rs2.getString("IS_AUTOINCREMENT");
//                System.out.println("columna " + nombreColumna + " - tipo : " + tipoColumna);
//                System.out.println("-------------AUTOINCREMENT " + isAutoIncrement);

                        if (tipoColumna.equalsIgnoreCase("varchar")) {
                            CamposBDCopy = "\"" + "'" + "\"" + "+" + nombreColumna + "+" + "\"" + "'" + "\"";
                            TipoDato = "String";
                        } else if (tipoColumna.equalsIgnoreCase("date")) {
                            CamposBDCopy = "\"" + "'" + "\"" + "+" + nombreColumna + "+" + "\"" + "'" + "\"";
                            TipoDato = "Date";
                            importaciones = importaciones + "import java.util.Date;\n";
                        } else if (tipoColumna.contains("numeric")) {
                            TipoDato = "BigDecimal";
                            importaciones = importaciones + "import java.math.BigDecimal;\n";

                        } else if (tipoColumna.equalsIgnoreCase("datetime")) {
                            CamposBDCopy = "\"" + "'" + "\"" + "+" + nombreColumna + "+" + "\"" + "'" + "\"";
                            TipoDato = "Date";
                            importaciones = importaciones + "import java.util.Date;\n";
                        } else if (tipoColumna.equalsIgnoreCase("datetime")) {
                            TipoDato = "Date";
                        }

                        for (String key : primaryKey) {
                            if (key.equalsIgnoreCase(nombreColumna)) {
                                keysTable = keysTable + "\"" + nombreColumna + "=\"" + "+" + CamposBDCopy + "+" + "\"" + " and " + "\"" + "+";
                                esKey = true;
                                TienePrimary = true;
//                        System.out.println("es primary");
                                break;
                            }
                        }

                        camposBD = camposBD + "    public " + TipoDato + " " + nombreColumna + ";\n";
                        if (isAutoIncrement.equalsIgnoreCase("NO")) {
                            prepareInsert = prepareInsert + nombreColumna + ",";
                            InsertValores = InsertValores + "+" + CamposBDCopy + "+" + "\"" + "," + "\"";
                            TieneCampos = true;
                        }
                        if (esKey == false) {
                            prepareEdit = prepareEdit + "\"" + nombreColumna + "=\"" + "+" + CamposBDCopy + "+" + "\"" + "," + "\"+";
                            TieneLLaves = true;
                        }
                        CamposResulset = CamposResulset + "              tabla.set" + nombreColumna.substring(0, 1).toUpperCase() + "" + nombreColumna.substring(1, nombreColumna.length()) + "(rs.get" + TipoDato + "(" + posicion + "));\n";
                        GeterSeter = GeterSeter + "\n" + "   public " + TipoDato + " get" + nombreColumna.substring(0, 1).toUpperCase() + "" + nombreColumna.substring(1, nombreColumna.length()) + "() {\n"
                                + "        return " + nombreColumna + ";\n"
                                + "    }\n"
                                + "\n"
                                + "   public void set" + nombreColumna.substring(0, 1).toUpperCase() + "" + nombreColumna.substring(1, nombreColumna.length()) + "(" + TipoDato + " " + nombreColumna + ") {\n"
                                + "        this." + nombreColumna + " = " + nombreColumna + ";\n"
                                + "   }\n";
                        posicion++;
                    }
                    if (TieneCampos) {
                        InsertValores = InsertValores.substring(0, InsertValores.length() - 4);
                        prepareInsert = prepareInsert.substring(0, prepareInsert.length() - 1);
                    }
                    if (TieneLLaves) {
                        prepareEdit = prepareEdit.substring(0, prepareEdit.length() - 4);
                    }
                    if (TienePrimary) {
//                System.out.println("--" + keysTable);
                        keysTable = keysTable.substring(0, keysTable.length() - 9);
//                System.out.println("-- :: " + keysTable);
                    }

//            System.out.println("-- : " + prepareEdit);
                    for (forenKeys foren : listForenKey) {
                        if (foren.getTableReference().equalsIgnoreCase(tabla)) {
                            fkTableName = fkTableName + "  List<" + foren.getTable() + "> List_" + foren.getTable() + " = new ArrayList();\n";
                            importaciones = importaciones + "import java.util.List;\n";
                        }

                    }

                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("package " + this.folder + ";\n"
                            + "import java.sql.SQLException;\n"
                            + "import java.util.ArrayList;\n"
                            + "import java.io.Serializable;\n"
                            + "import java.sql.ResultSet;\n"
                            + importaciones + "\n"
                            + "public class " + tabla + " extends Persistencia implements Serializable{\n"
                            + camposBD + "\n"
                            + fkTableName
                            + "   public " + tabla + "() {\n"
                            + "     super();\n"
                            + "   }\n"
                            + "   " + GeterSeter + "\n"
                            + "   " + "@Override\n"
                            + "   public int create() {\n"
                            + "      int transaccion=-1;\n"
                            + "      String prepareInsert=\"insert into " + tabla + " (" + prepareInsert + ") values (" + "\"" + InsertValores + "+" + "\"" + ")" + "\";\n"
                            + "      try {\n"
                            + "          this.getConecion().con = this.getConecion().dataSource.getConnection();\n"
                            + "          this.getConecion().con.setAutoCommit(false);\n"
                            + "          transaccion=" + tabla + ".this.getConecion().transaccion(prepareInsert);\n"
                            + "      }  catch (SQLException ex) {\n"
                            + "          System.out.println(\"Error SQL : \" + ex.toString());\n"
                            + "      }  finally {\n"
                            + "           try {\n"
                            + "               this.getConecion().getconecion().commit();\n"
                            + "               this.getConecion().getconecion().setAutoCommit(true);\n"
                            + "               this.getConecion().con.close();\n"
                            + "           } catch (SQLException ex) {\n"
                            + "               System.out.println(ex);\n"
                            + "           }\n"
                            + "      }\n"
                            + "     return transaccion;  "
                            + "     }\n"
                            + "\n"
                            + "   " + "@Override\n"
                            + "   public int edit() {\n"
                            + "      int transaccion=-1;\n"
                            + "      String prepareEdit=\"update " + tabla + " set \"+" + prepareEdit + "\" where \"" + "+" + keysTable + ";"
                            + "      try {\n"
                            + "           this.getConecion().con = this.getConecion().dataSource.getConnection();\n"
                            + "           this.getConecion().con.setAutoCommit(false);\n"
                            + "           transaccion=" + tabla + ".this.getConecion().transaccion(prepareEdit);\n"
                            + "       }  catch (SQLException ex) {\n"
                            + "           System.out.println(\"Error SQL : \" + ex.toString());\n"
                            + "       } finally {\n"
                            + "           try {\n"
                            + "                 this.getConecion().getconecion().commit();\n"
                            + "                 this.getConecion().getconecion().setAutoCommit(true);\n"
                            + "                 this.getConecion().con.close();\n"
                            + "            }  catch (SQLException ex) {\n"
                            + "                System.out.println(ex);\n"
                            + "            }\n"
                            + "        }"
                            + "     return transaccion;  "
                            + "    }\n"
                            + "\n"
                            + "   " + "@Override\n"
                            + "    public int remove() {\n"
                            + "       int transaccion=-1;\n"
                            + "       String prepareDelete=\"delete from  " + tabla + " where \"" + "+" + keysTable + ";"
                            + "       try {\n"
                            + "            this.getConecion().con = this.getConecion().dataSource.getConnection();\n"
                            + "            this.getConecion().con.setAutoCommit(false);\n"
                            + "            transaccion=" + tabla + ".this.getConecion().transaccion(prepareDelete);\n"
                            + "       } catch (SQLException ex) {\n"
                            + "            System.out.println(\"Error SQL : \" + ex.toString());\n"
                            + "       } finally {\n"
                            + "          try {\n"
                            + "                this.getConecion().getconecion().commit();\n"
                            + "                this.getConecion().getconecion().setAutoCommit(true);\n"
                            + "                this.getConecion().con.close();\n"
                            + "           }  catch (SQLException ex) {\n"
                            + "                System.out.println(ex);\n"
                            + "            }\n"
                            + "        }"
                            + "    return transaccion;  "
                            + "    }\n"
                            + "\n"
                            + "   " + "@Override\n"
                            + "    public java.util.List<" + tabla + "> List() {\n"
                            + "        ArrayList<" + tabla + "> list" + tabla + "=new ArrayList();\n"
                            + "       String prepareQuery=\"select * from " + tabla + "\";\n"
                            + "       try {\n"
                            + "             ResultSet rs =" + tabla + ".super.getConecion().query(prepareQuery);\n"
                            + "             while (rs.next()) { \n"
                            + "            " + tabla + " tabla = new " + tabla + "();\n"
                            + CamposResulset + "\n"
                            + "             list" + tabla + ".add(tabla);\n"
                            + "             }\n"
                            + "        } catch (SQLException ex) {\n"
                            + "              System.out.println(\"Error Consulta : \" + ex.toString());\n"
                            + "        }\n"
                            + "        return list" + tabla + ";\n"
                            + "    }" + "\n"
                            + "}");
                    bw.close();

                }
            }

        } catch (Exception ex) {

        } finally {
            con.close();
        }

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
                    System.out.println("reference : " + tabla + " references  : " + forenK);
//                importaciones = importaciones + "import java.util.List;\n";
                } else if (condicion == 2) {
                    listForenKey.add(new forenKeys(tabla, forenK, fkColumnName));
                    System.out.println("reference : " + tabla + " references  : " + forenK);
                }
            }

        }
        return listForenKey;
    }

    public void crearViewBasic() throws IOException, SQLException, ClassNotFoundException {
        try {
            ArrayList<forenKeys> listForenKey = new ArrayList();
            listForenKey = forenKeys(2);
            //        sqlServer conecion = sqlServer.getDbCon();
            //Swing
//        String f = "src/JAJA";
//        String util = "src/util";
//        String persistencia = "src/JAJA/Persistencia.java";
//        String Utilidad = "src/JAJA/Util.java";
//        String rutaModelo = "src/JAJA";

            //WEB
            String f = "src/java/" + this.folder2;
            String util = "src/java/util";
            String rutaBeans = "";
            String referencias = "";
            File folder = new File(f);
            folder.mkdir();

//        File folderUtil = new File(util);
//        folderUtil.mkdir();
//        String ruta = "src/JAJA/prueba.java";
            BufferedWriter bw = null;

            int a = 1;
            int b = 0;
            int count = 0;
            String columnas = "";
            String catalogo = "";
            String columnasCreate = "";
            String createReference = "";
            String ColumnasDate = "";
            String contenido = "";
            boolean r = false;
            boolean CrearTabla = false;

            DatabaseMetaData metaDatos = con.getMetaData();
            String v[] = {"TABLE"};
            ResultSet rs = metaDatos.getTables(null, null, null, v);
            while (rs.next()) {
                porcentaje += 10;
                System.out.println("------------------------ :: " + porcentaje);
                progreso.setValue(porcentaje);
                progreso.setStringPainted(true);
                String tabla = rs.getString(3);
                catalogo = rs.getString(1);
                referencias = "";
                contenido = "";
                CrearTabla = false;

                for (String table : Listablas) {
                    if (table.trim().equalsIgnoreCase(tabla)) {
                        CrearTabla = true;
                    }
                }

                if (CrearTabla) {

                    rutaBeans = "src/java/" + this.folder2 + "/" + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans.java";
                    File archivo = new File(rutaBeans);

                    contenido = "<br />\n"
                            + "<h:link outcome=\"/" + tabla + "/list\" value=\"" + tabla + "\" />";

                    b = 0;
                    columnas = "";
                    columnasCreate = "";
                    ColumnasDate = "";
                    createReference = "";
                    r = false;

                    File folderweb = new File("web/" + tabla);
                    folderweb.mkdir();

                    for (forenKeys foren : listForenKey) {
                        if (foren.getTableReference().equalsIgnoreCase(tabla)) {
                            if (b == 0) {
                                b++;
                                referencias = referencias + " public List<" + foren.getTableReference() + "> getItems() {\n"
                                        + "        list_objecto.clear();\n"
                                        + "        list_objecto = objecto.List();\n"
                                        + "        return list_objecto;\n"
                                        + "    }\n";
                            }
                        }

                    }

                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("package " + this.folder2 + ";\n"
                            + "\n"
                            + "import " + this.folder + "." + tabla + ";\n"
                            + "import javax.inject.Named;\n"
                            + "import javax.enterprise.context.SessionScoped;\n"
                            + "import java.io.Serializable;\n"
                            + "import java.util.ArrayList;\n"
                            + "import java.util.List;\n"
                            + "import javax.annotation.PostConstruct;\n"
                            + "import javax.faces.application.FacesMessage;\n"
                            + "import javax.faces.context.FacesContext;\n"
                            + "\n"
                            + "\n"
                            + "@Named(value = \"" + tabla + "Beans\")\n"
                            + "@SessionScoped\n"
                            + "public class " + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans implements Serializable {\n"
                            + "\n"
                            + "    " + tabla + " objecto;\n"
                            + "    List<" + tabla + "> list_objecto = new ArrayList();\n"
                            + "\n"
                            + "    @PostConstruct\n"
                            + "    public void init() {\n"
                            + "        cargaDatos();\n"
                            + "    }\n"
                            + "\n"
                            + "    public void cargaDatos() {\n"
                            + "        list_objecto.clear();\n"
                            + "        list_objecto = objecto.List();\n"
                            + "    }\n"
                            + "\n"
                            + "    public " + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans() {\n"
                            + "        objecto = new " + tabla + "();\n"
                            + "    }\n"
                            + "\n"
                            + "    public String prepareEdit(" + tabla + " obj) {\n"
                            + "        objecto = obj;\n"
                            + "        return \"edit\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String prepradeCreate() {\n"
                            + "        objecto = new " + tabla + "();\n"
                            + "        return \"create\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String create() {\n"
                            + "        objecto.create();\n"
                            + "        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, \"Exito al " + tabla + "\", \"\");\n"
                            + "        FacesContext.getCurrentInstance().addMessage(null, facesMsg);\n"
                            + "         objecto = new " + tabla + "();\n"
                            + "        return null;\n"
                            + "    }\n"
                            + "\n"
                            + "    public String list() {\n"
                            + "        cargaDatos();\n"
                            + "        return \"list\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String delete(" + tabla + " obj) {\n"
                            + "        objecto = obj;\n"
                            + "        objecto.remove();\n"
                            + "        cargaDatos();\n"
                            + "        return \"list\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String edit() {\n"
                            + "        objecto.edit();\n"
                            + "        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, \"Exito al Editar\", \"\");\n"
                            + "        FacesContext.getCurrentInstance().addMessage(null, facesMsg);\n"
                            + "        return null;\n"
                            + "    }\n"
                            + "\n"
                            + "\n" + referencias + "\n"
                            + "    public " + tabla + " getObject() {\n"
                            + "        if (objecto == null) {\n"
                            + "            objecto = new " + tabla + "();\n"
                            + "        }\n"
                            + "        return objecto;\n"
                            + "    }\n"
                            + "\n"
                            + "    public void setObject(" + tabla + " obj) {\n"
                            + "        this.objecto = obj;\n"
                            + "    }\n"
                            + "\n"
                            + "    public List<" + tabla + "> getLista() {\n"
                            + "        return list_objecto;\n"
                            + "    }\n"
                            + "\n"
                            + "    public void setLista(List<" + tabla + "> lista) {\n"
                            + "        this.list_objecto = lista;\n"
                            + "    }\n"
                            + "\n"
                            + "}\n"
                            + "");
                    bw.close();

                    ResultSet rs2 = metaDatos.getColumns(catalogo, null, tabla, null);

                    while (rs2.next()) {
                        String nombreColumna = rs2.getString(4);
                        String tipoColumna = rs2.getString(6);
                        String isAutoIncrement = rs2.getString("IS_AUTOINCREMENT");
                        r = false;

                        columnas = columnas + "\n" + "              <h:column>\n"
                                + "              <f:facet name=\"header\">" + tabla + "</f:facet>\n"
                                + "              #{" + tabla + "." + nombreColumna + "}\n"
                                + "              </h:column>" + "\n";

                        for (forenKeys fk : listForenKey) {
                            if (fk.getTableReference().equalsIgnoreCase(tabla)) {

                                if (fk.getColumn().equalsIgnoreCase(nombreColumna)) {
                                    r = true;
                                    createReference = createReference + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
                                            + "                <h:selectOneMenu value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" >\n"
                                            + "                    <f:selectItems value=\"#{" + fk.getTableReference() + "Beans.items}\" var=\"" + nombreColumna + "\" \n"
                                            + "                                   itemLabel=\"#{" + nombreColumna + "." + fk.getColumn() + "}\" "
                                            + "                                   itemValue=\"#{" + nombreColumna + "." + fk.getColumn() + "}\"></f:selectItems>\n"
                                            + "                </h:selectOneMenu>" + "\n";
                                    break;
                                }

                            }
                        }

                        if (r == false && isAutoIncrement.equalsIgnoreCase("NO")) {
                            if (tipoColumna.equalsIgnoreCase("date")) {
                                columnasCreate = columnasCreate + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
                                        + "                <h:inputText label=\"" + nombreColumna + "\"  id=\"" + nombreColumna + "\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\"\n"
                                        + "                requiredMessage=\"Ingregse " + nombreColumna + "\" >" + "\n" + "  <f:convertDateTime pattern=\"MM/dd/yyyy\" />\n"
                                        + "                </h:inputText>";
                            } else if (tipoColumna.equalsIgnoreCase("datetime")) {
                                columnasCreate = columnasCreate + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
                                        + "                <h:inputText label=\"" + nombreColumna + "\"  id=\"" + nombreColumna + "\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\"\n"
                                        + "                requiredMessage=\"Ingregse " + nombreColumna + "\" >" + "\n" + "  <f:convertDateTime pattern=\"MM/dd/yyyy\" />\n"
                                        + "                </h:inputText>";
                            } else {
                                columnasCreate = columnasCreate + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
                                        + "                <h:inputText label=\"" + nombreColumna + "\"  id=\"" + nombreColumna + "\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\"\n"
                                        + "                requiredMessage=\"Ingregse " + nombreColumna + "\" />" + "\n";
                            }

                        }

                    }

                    bw = new BufferedWriter(new FileWriter("web/" + tabla + "/list.xhtml"));
                    bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                            + "<!DOCTYPE html>\n"
                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                            + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                            + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                            + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n\n"
                            + "    <ui:composition template=\"/template.xhtml\">\n"
                            + "        <ui:define name=\"title\">\n"
                            + "            <h:outputText value=\"" + tabla + "\"></h:outputText>\n"
                            + "        </ui:define>\n"
                            + "        <ui:define name=\"body\">\n\n"
                            + "        <h:form>\n"
                            + "            <h1>Lista " + tabla + "</h1>\n"
                            + "            <h:dataTable value=\"#{" + tabla + "Beans.lista}\" var=\"" + tabla + "\" >\n"
                            + columnas + "\n"
                            + "                <h:column>\n"
                            + "                    <f:facet name=\"header\">Opciones</f:facet>\n"
                            + "                    <h:commandButton value=\"Editar\" action=\"#{" + tabla + "Beans.prepareEdit(" + tabla + ")}\"></h:commandButton>\n"
                            + "                    <h:commandButton value=\"Borrar\" action=\"#{" + tabla + "Beans.delete(" + tabla + ")}\"></h:commandButton>\n"
                            + "                </h:column>      \n"
                            + "            </h:dataTable>\n"
                            + "            <br/>\n"
                            + "            <h:commandButton value=\"Nuevo\" action=\"#{" + tabla + "Beans.prepradeCreate()}\"></h:commandButton>\n"
                            + "             <br/>\n"
                            + "            <h:commandButton value=\"Atras\" action=\"/index\"></h:commandButton>"
                            + "             </h:form>\n"
                            + "         </ui:define>\n"
                            + "    </ui:composition>\n"
                            + "</html>");
                    bw.close();

                    bw = new BufferedWriter(new FileWriter("web/" + tabla + "/create.xhtml"));
                    bw.write("<?xml version='1.0' encoding='UTF-8' ?>\n"
                            + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\""
                            + " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                            + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                            + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                            + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n\n"
                            + "    <ui:composition template=\"/template.xhtml\">\n"
                            + "        <ui:define name=\"title\">\n"
                            + "            <h:outputText value=\"" + tabla + "\"></h:outputText>\n"
                            + "        </ui:define>\n"
                            + "        <ui:define name=\"body\">\n\n"
                            + "        <h3>Crear " + tabla + "</h3>\n"
                            + "        <h:panelGroup id=\"msg\" layout=\"block\">\n"
                            + "            <h:messages errorStyle=\"color: red\" infoStyle=\"color: green\" layout=\"table\"/>\n"
                            + "        </h:panelGroup>\n"
                            + "        <h:form>\n"
                            + "            <h:panelGrid columns=\"2\">\n"
                            + columnasCreate + "\n"
                            + createReference + "\n"
                            + "            </h:panelGrid>\n"
                            + "            <br/>"
                            + "            <h:commandButton value=\"guardar\" action=\"#{" + tabla + "Beans.create()}\"></h:commandButton>\n"
                            + "            <br/>\n"
                            + "            <h:commandButton value=\"List\" action=\"#{" + tabla + "Beans.list()}\" immediate=\"true\"></h:commandButton>\n"
                            + "        </h:form>\n"
                            + "    </ui:define>\n"
                            + "    </ui:composition>\n"
                            + "</html>");
                    bw.close();
                    bw = new BufferedWriter(new FileWriter("web/" + tabla + "/edit.xhtml"));
                    bw.write("<?xml version='1.0' encoding='UTF-8' ?>\n"
                            + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\""
                            + " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                            + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                            + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                            + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n\n"
                            + "    <ui:composition template=\"/template.xhtml\">\n"
                            + "        <ui:define name=\"title\">\n"
                            + "            <h:outputText value=\"" + tabla + "\"></h:outputText>\n"
                            + "        </ui:define>\n"
                            + "        <ui:define name=\"body\">\n\n"
                            + "        <h3>Editar " + tabla + "</h3>\n"
                            + "        <h:panelGroup id=\"msg\" layout=\"block\">\n"
                            + "            <h:messages errorStyle=\"color: red\" infoStyle=\"color: green\" layout=\"table\"/>\n"
                            + "        </h:panelGroup>\n"
                            + "        <h:form>\n"
                            + "            <h:panelGrid columns=\"2\">\n"
                            + columnasCreate + "\n"
                            + createReference + "\n"
                            + "            </h:panelGrid>\n"
                            + "            <br/>"
                            + "            <h:commandButton value=\"editar\" action=\"#{" + tabla + "Beans.edit()}\"></h:commandButton>\n"
                            + "            <br/>\n"
                            + "            <h:commandButton value=\"List\" action=\"#{" + tabla + "Beans.list()}\" immediate=\"true\"></h:commandButton>\n"
                            + "        </h:form>\n"
                            + "      </ui:define>\n"
                            + "    </ui:composition>\n"
                            + "</html>");
                    bw.close();
                }
            }
            templets(2);

        } catch (Exception ex) {

        } finally {
            con.close();
        }

    }

    public void templets(int condicion) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("template : " + condicion);
        String templet = "";
        String index = "";
        boolean CrearTabla = false;
        try {
            con = pool.dataSource.getConnection();

            if (condicion == 1) {

                String contenido = "";
                DatabaseMetaData metaDatos = con.getMetaData();
                String v[] = {"TABLE"};
                ResultSet rs = metaDatos.getTables(null, null, null, v);
                while (rs.next()) {
                    CrearTabla = false;
                    String tabla = rs.getString(3);

                    for (String table : Listablas) {
                        if (table.trim().equalsIgnoreCase(tabla)) {
                            CrearTabla = true;
                        }
                    }

                    if (CrearTabla) {
                        contenido += "<br/>\n"
                                + "<h:link outcome=\"/" + tabla + "/list\" value=\"" + tabla + "\" />";
                    }

                }
                BufferedWriter bw = null;

                templet = "<?xml version='1.0' encoding='UTF-8' ?>\n"
                        + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                        + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                        + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\"\n"
                        + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\">\n"
                        + "\n"
                        + "    <h:head>\n"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                        + "        <title><ui:insert name=\"title\"></ui:insert></title>        \n"
                        + "    </h:head>\n"
                        + "\n"
                        + "    <h:body>\n"
                        + "        <h1>\n"
                        + "            <ui:insert name=\"title\"></ui:insert>\n"
                        + "        </h1>\n"
                        + "        <p>\n"
                        + "            <ui:insert name=\"body\"></ui:insert>\n"
                        + "        </p>\n"
                        + "    </h:body>\n"
                        + "\n"
                        + "</html>";

                bw = new BufferedWriter(new FileWriter("web/template.xhtml"));
                bw.write(templet);
                bw.close();

                index = "<?xml version='1.0' encoding='UTF-8' ?>\n"
                        + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                        + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                        + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\">\n"
                        + "    <h:head>\n"
                        + "        <title>Facelet Title</title>\n"
                        + "    </h:head>\n"
                        + "    <h:body>\n"
                        + "        <h3>Menu</h3>\n"
                        + contenido + "\n"
                        + "    </h:body>\n"
                        + "</html>";

                bw = new BufferedWriter(new FileWriter("web/index.xhtml"));
                bw.write(index);
                bw.close();
            } else if (condicion == 2) {
                String contenido = "";
                DatabaseMetaData metaDatos = con.getMetaData();
                String v[] = {"TABLE"};
                ResultSet rs = metaDatos.getTables(null, null, null, v);
                while (rs.next()) {
                    CrearTabla = false;
                    String tabla = rs.getString(3);

                    for (String table : Listablas) {
                        if (table.trim().equalsIgnoreCase(tabla)) {
                            CrearTabla = true;
                        }
                    }

                    if (CrearTabla) {
                        contenido += "                    <b:dropMenu value=\"" + tabla + "\">\n"
                                + "                        <b:navLink value=\"List\" outcome=\"/" + tabla + "/list\" ></b:navLink>\n"
                                + "                        <b:navLink value=\"Crear\" outcome=\"/" + tabla + "/create\"></b:navLink>\n"
                                + "                    </b:dropMenu>\n";
                    }

                }
                BufferedWriter bw = null;

                templet = "\n"
                        + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                        + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\"\n"
                        + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                        + "      xmlns:b=\"http://bootsfaces.net/ui\"\n"
                        + "      xmlns:p=\"http://primefaces.org/ui\"  \n"
                        + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                        + "      xmlns:jsf=\"http://xmlns.jcp.org/jsf\">\n"
                        + "\n"
                        + "    <h:head>\n"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                        + "    \n"
                        + "        <meta charset=\"utf-8\"></meta>\n"
                        + "        <meta http-equiv=\"refresh\" content=\"300\"/>\n"
                        + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"></meta>\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                        + "        <meta name=\"description\" content=\"\"></meta>\n"
                        + "        <meta name=\"author\" content=\"\"></meta>\n"
                        + "\n"
                        + "    </h:head>\n"
                        + "\n"
                        + "    <h:body>\n"
                        + "        <b:navBar brand=\"JCM\" inverse=\"true\">\n"
                        + "            <b:navbarLinks>\n"
                        + "              <b:dropMenu value=\"Menu\">\n"
                        + contenido + "\n"
                        + "              </b:dropMenu>\n"
                        + "            </b:navbarLinks>\n"
                        + "        </b:navBar>\n"
                        + "  \n"
                        + "  <b:row>                \n"
                        + "            <b:column span=\"1\"> </b:column>\n"
                        + "            <b:column medium-screen=\"5\">\n"
                        + "                <ui:insert name=\"title\">  </ui:insert>\n"
                        + "            </b:column>\n"
                        + "        </b:row>\n"
                        + "\n"
                        + "        <b:container>\n"
                        + "            <b:row>                \n"
                        + "                <b:column span=\"15\">\n"
                        + "                    <ui:insert name=\"body\">  </ui:insert>\n"
                        + "                </b:column>\n"
                        + "            </b:row>\n"
                        + "        </b:container>  \n"
                        + "\n"
                        + "    </h:body>\n"
                        + "\n"
                        + "</html>\n"
                        + "";

                bw = new BufferedWriter(new FileWriter("web/template.xhtml"));
                bw.write(templet);
                bw.close();

                index = "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                        + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                        + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                        + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n"
                        + "\n"
                        + "        <ui:composition template=\"/template.xhtml\">\n"
                        + "            <ui:define name=\"title\">\n"
                        + "            </ui:define>\n"
                        + "             <ui:define name=\"body\">\n"
                        + "\n"
                        + "             </ui:define>\n"
                        + "        </ui:composition>\n"
                        + "</html>";

                bw = new BufferedWriter(new FileWriter("web/index.xhtml"));
                bw.write(index);
                bw.close();
            }

        } catch (Exception ex) {

        } finally {
            con.close();
        }

    }

    public void crearViewPrimefacesBootfaces() throws SQLException {
        try {
            con = pool.dataSource.getConnection();
            ArrayList<forenKeys> listForenKey = new ArrayList();
            listForenKey = forenKeys(2);
            //        sqlServer conecion = sqlServer.getDbCon();
            //Swing
//        String f = "src/JAJA";
//        String util = "src/util";
//        String persistencia = "src/JAJA/Persistencia.java";
//        String Utilidad = "src/JAJA/Util.java";
//        String rutaModelo = "src/JAJA";

            //WEB
            String f = "src/java/" + this.folder2;
            String rutaBeans = "";
            String referencias = "";
            File folder = new File(f);
            folder.mkdir();

//        File folderUtil = new File(util);
//        folderUtil.mkdir();
//        String ruta = "src/JAJA/prueba.java";
            BufferedWriter bw = null;

            int a = 1;
            int b = 0;
            int count = 0;
            String columnas = "";
            String catalogo = "";
            String columnasCreate = "";
            String createReference = "";
            String ColumnasDate = "";
//            String contenido = "";
            boolean r = false;
            boolean CrearTabla = false;

            DatabaseMetaData metaDatos = con.getMetaData();
            String v[] = {"TABLE"};
            ResultSet rs = metaDatos.getTables(null, null, null, v);
            while (rs.next()) {
                porcentaje += 10;
                System.out.println("------------------------ :: " + porcentaje);
                progreso.setValue(porcentaje);
                progreso.setStringPainted(true);
                String tabla = rs.getString(3);
                catalogo = rs.getString(1);
                referencias = "";
//                contenido = "";
                CrearTabla = false;
                System.out.println("buscamos tabla : " + tabla);
                for (String table : Listablas) {
                    if (table.trim().equalsIgnoreCase(tabla)) {
                        CrearTabla = true;
                    }
                }

                if (CrearTabla) {
                    System.out.println("pasoooooooooooooooo");
                    rutaBeans = "src/java/" + this.folder2 + "/" + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans.java";
                    File archivo = new File(rutaBeans);

//                    contenido = "<br />\n"
//                            + "<h:link outcome=\"/" + tabla + "/list\" value=\"" + tabla + "\" />";
                    b = 0;
                    columnas = "";
                    columnasCreate = "";
                    ColumnasDate = "";
                    createReference = "";
                    r = false;

                    File folderweb = new File("web/" + tabla);
                    folderweb.mkdir();

                    for (forenKeys foren : listForenKey) {
                        if (foren.getTableReference().equalsIgnoreCase(tabla)) {
                            if (b == 0) {
                                b++;
                                referencias = referencias + " public List<" + foren.getTableReference() + "> getItems() {\n"
                                        + "        list_objecto.clear();\n"
                                        + "        list_objecto = objecto.List();\n"
                                        + "        return list_objecto;\n"
                                        + "    }\n";
                            }
                        }

                    }

                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("package " + this.folder2 + ";\n"
                            + "\n"
                            + "import " + this.folder + "." + tabla + ";\n"
                            + "import javax.inject.Named;\n"
                            + "import javax.enterprise.context.SessionScoped;\n"
                            + "import java.io.Serializable;\n"
                            + "import java.util.ArrayList;\n"
                            + "import java.util.List;\n"
                            + "import javax.annotation.PostConstruct;\n"
                            + "import javax.faces.application.FacesMessage;\n"
                            + "import javax.faces.context.FacesContext;\n"
                            + "\n"
                            + "\n"
                            + "@Named(value = \"" + tabla + "Beans\")\n"
                            + "@SessionScoped\n"
                            + "public class " + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans implements Serializable {\n"
                            + "\n"
                            + "    " + tabla + " objecto;\n"
                            + "    List<" + tabla + "> list_objecto = new ArrayList();\n"
                            + "\n"
                            + "    @PostConstruct\n"
                            + "    public void init() {\n"
                            + "        cargaDatos();\n"
                            + "    }\n"
                            + "\n"
                            + "    public void cargaDatos() {\n"
                            + "        list_objecto.clear();\n"
                            + "        list_objecto = objecto.List();\n"
                            + "    }\n"
                            + "\n"
                            + "    public " + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans() {\n"
                            + "        objecto = new " + tabla + "();\n"
                            + "    }\n"
                            + "\n"
                            + "    public String prepareEdit(" + tabla + " obj) {\n"
                            + "        objecto = obj;\n"
                            + "        return \"edit\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String prepradeCreate() {\n"
                            + "        objecto = new " + tabla + "();\n"
                            + "        return \"create\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String create() {\n"
                            + "        objecto.create();\n"
                            + "        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, \"Información\", \"Exito Creada\"));\n"
                            + "         objecto = new " + tabla + "();\n"
                            + "        return null;\n"
                            + "    }\n"
                            + "\n"
                            + "    public String list() {\n"
                            + "        cargaDatos();\n"
                            + "        return \"list\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String delete(" + tabla + " obj) {\n"
                            + "        objecto = obj;\n"
                            + "        objecto.remove();\n"
                            + "        cargaDatos();\n"
                            + "        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, \"Información\", \"Exito al Borrar\"));\n"
                            + "        return \"list\";\n"
                            + "    }\n"
                            + "\n"
                            + "    public String edit() {\n"
                            + "        objecto.edit();\n"
                            + "        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, \"Información\", \"Exito al Editar\"));\n"
                            + "        return null;\n"
                            + "    }\n"
                            + "\n"
                            + "\n" + referencias + "\n"
                            + "    public " + tabla + " getObject() {\n"
                            + "        if (objecto == null) {\n"
                            + "            objecto = new " + tabla + "();\n"
                            + "        }\n"
                            + "        return objecto;\n"
                            + "    }\n"
                            + "\n"
                            + "    public void setObject(" + tabla + " obj) {\n"
                            + "        this.objecto = obj;\n"
                            + "    }\n"
                            + "\n"
                            + "    public List<" + tabla + "> getLista() {\n"
                            + "        return list_objecto;\n"
                            + "    }\n"
                            + "\n"
                            + "    public void setLista(List<" + tabla + "> lista) {\n"
                            + "        this.list_objecto = lista;\n"
                            + "    }\n"
                            + "}\n"
                            + "");
                    bw.close();

                    ResultSet rs2 = metaDatos.getColumns(catalogo, null, tabla, null);

                    while (rs2.next()) {
                        String nombreColumna = rs2.getString(4);
                        String tipoColumna = rs2.getString(6);
                        String isAutoIncrement = rs2.getString("IS_AUTOINCREMENT");
                        r = false;

                        columnas = columnas + "\n" + "                        <p:column headerText=\"" + nombreColumna + "\">\n"
                                + "                            <h:outputText value=\"#{" + tabla + "." + nombreColumna + "}\" />\n"
                                + "                        </p:column>\n";

                        for (forenKeys fk : listForenKey) {
                            if (fk.getTableReference().equalsIgnoreCase(tabla)) {

                                if (fk.getColumn().equalsIgnoreCase(nombreColumna)) {
                                    r = true;
                                    createReference = createReference + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
                                            + "                 <b:selectOneMenu id=" + nombreColumna + " value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" >\n"
                                            + "                    <f:selectItems value=\"#{" + fk.getTableReference() + "Beans.items}\" var=\"" + nombreColumna + "\" \n"
                                            + "                                   itemLabel=\"#{" + nombreColumna + "." + fk.getColumn() + "}\" "
                                            + "                                   itemValue=\"#{" + nombreColumna + "." + fk.getColumn() + "}\"></f:selectItems>\n"
                                            + "                </b:selectOneMenu>" + "\n"
                                            + "                <h:message for=\"" + nombreColumna + "\" style=\"color: red\"></h:message>";
                                    break;
                                }

                            }
                        }

                        if (r == false && isAutoIncrement.equalsIgnoreCase("NO")) {
                            if (tipoColumna.equalsIgnoreCase("date")) {
                                columnasCreate = columnasCreate + "\n" + " <h:outputText value=\"" + nombreColumna + " :\" />\n"
                                        + "                      <b:datepicker id=\"" + nombreColumna + "\" mode=\"toggle-icon\" showWeek=\"true\" firstDay=\"1\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\" required-message=\"Debe ingresar Fecha\"  ></b:datepicker>\n"
                                        + "                        <h:message for=\"" + nombreColumna + "\" style=\"color: red\"></h:message>  ";
                            } else if (tipoColumna.equalsIgnoreCase("datetime")) {
                                columnasCreate = columnasCreate + "\n" + " <h:outputText value=\"" + nombreColumna + " :\" />\n"
                                        + "                      <b:datepicker id=\"" + nombreColumna + "\" mode=\"toggle-icon\" showWeek=\"true\" firstDay=\"1\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\" required-message=\"Debe ingresar Fecha\"  ></b:datepicker>\n"
                                        + "                        <h:message for=\"" + nombreColumna + "\" style=\"color: red\"></h:message>  ";
                            } else {
                                columnasCreate = columnasCreate + "\n" + "                       <h:outputText value=\"" + nombreColumna + " :\" />\n"
                                        + "                        <b:inputText value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" tooltip=\"Ingrese " + nombreColumna + "\" id=\"" + nombreColumna + "\" required=\"true\"\n"
                                        + "                                     required-message=\"Ingrese " + nombreColumna + "\"/>\n"
                                        + "                        <h:message for=\"" + nombreColumna + "\" style=\"color: red\"></h:message>  ";
                            }

                        }

                    }

                    bw = new BufferedWriter(new FileWriter("web/" + tabla + "/list.xhtml"));
                    bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                            + "<!DOCTYPE html>\n"
                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                            + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                            + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                            + "      xmlns:b=\"http://bootsfaces.net/ui\"\n"
                            + "      xmlns:p=\"http://primefaces.org/ui\" \n"
                            + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n\n"
                            + "    <ui:composition template=\"/template.xhtml\">\n"
                            + "        <ui:define name=\"title\">\n"
                            + "            <h1>Lista " + tabla + "</h1>\n"
                            + "        </ui:define>\n"
                            + "        <ui:define name=\"body\">\n\n"
                            + "        <h:form>\n"
                            + "         <b:growl id=\"growlMsg\" globalOnly=\"true\" placementFrom=\"bottom\"\n"
                            + "                         show-detail=\"true\" show-summary=\"false\" allowDismiss=\"true\"\n"
                            + "                         delay=\"10000\" escape=\"true\" /> \n"
                            + "             <p:dataTable id=\"tac\" var=\"" + tabla + "\" value=\"#{" + tabla + "Beans.lista}\" rows=\"10\"\n"
                            + "                                 paginator=\"true\"\n"
                            + "                                 paginatorTemplate=\"{CurrentPageReport} {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}\"\n"
                            + "                                 rowsPerPageTemplate=\"5,10,15\"> "
                            + columnas + "\n"
                            + "                    <p:column headerText=\"Opciones\">\n"
                            + "                      <b:commandButton value=\"Editar\" icon-size=\"1x\"  action=\"#{" + tabla + "Beans.prepareEdit(" + tabla + ")}\"  \n"
                            + "                                         iconAwesome=\"pencil\"></b:commandButton>\n"
                            + "                      <b:commandButton value=\"Borrar\" look=\"danger\" icon-size=\"1x\" action=\"#{" + tabla + "Beans.delete(" + tabla + ")}\"\n"
                            + "                                         iconAwesome=\"remove\"></b:commandButton>\n"
                            + "                    </p:column> \n"
                            + "            </p:dataTable>\n"
                            + "            <br/>\n"
                            + "             <b:row>                                    \n"
                            + "                    <b:column medium-screen=\"1\"> <b:commandButton value=\"Nuevo\" look=\"primary\" action=\"#{categoriaBeans.prepradeCreate()}\"></b:commandButton></b:column>\n"
                            + "                    <b:column medium-screen=\"1\">  <b:commandButton value=\"Atras\" action=\"/index\"></b:commandButton> </b:column>\n"
                            + "                </b:row>"
                            + "             </h:form>\n"
                            + "         </ui:define>\n"
                            + "    </ui:composition>\n"
                            + "</html>");
                    bw.close();

                    bw = new BufferedWriter(new FileWriter("web/" + tabla + "/create.xhtml"));
                    bw.write("<?xml version='1.0' encoding='UTF-8' ?>\n"
                            + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                            + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                            + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                            + "      xmlns:b=\"http://bootsfaces.net/ui\"\n"
                            + "      xmlns:p=\"http://primefaces.org/ui\" \n"
                            + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n"
                            + "\n"
                            + "    <ui:composition template=\"/template.xhtml\">\n"
                            + "        <ui:define name=\"title\">\n"
                            + "         <h1>Crear " + tabla + "</h1>"
                            + "        </ui:define>\n"
                            + "        <ui:define name=\"body\">          \n"
                            + "            <b:panel>\n"
                            + "                <h:form id=\"form\">\n"
                            + "                    <b:growl id=\"growlMsg\" globalOnly=\"true\" placementFrom=\"bottom\"\n"
                            + "                                 show-detail=\"true\" show-summary=\"false\" allowDismiss=\"true\"\n"
                            + "                                 delay=\"10000\" escape=\"true\" /> \n"
                            + "                    <b:panelGrid colSpans=\"2,8,2\" id=\"datos\">\n"
                            + columnasCreate + "\n"
                            + createReference + "\n"
                            + "                    </b:panelGrid>\n"
                            + "                    <br/> \n"
                            + "                    <b:commandButton styleClass=\"btn btn-primary btn-sm m\" value=\"Guardar\" look=\"primary\" action=\"#{" + tabla + "Beans.create()}\" update=\"form:datos, growlMsg\"/>\n"
                            + "                    <a class=\"btn btn-primary btn-sm m\" href=\"#{" + tabla + "Beans.list()}\">Cancelar</a>\n"
                            + "                </h:form>  \n"
                            + "            </b:panel>\n"
                            + "        </ui:define>\n"
                            + "    </ui:composition>\n"
                            + "</html>");
                    bw.close();
                    bw = new BufferedWriter(new FileWriter("web/" + tabla + "/edit.xhtml"));
                    bw.write("<?xml version='1.0' encoding='UTF-8' ?>\n"
                            + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                            + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
                            + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                            + "      xmlns:b=\"http://bootsfaces.net/ui\"\n"
                            + "      xmlns:p=\"http://primefaces.org/ui\" \n"
                            + "      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\">\n"
                            + "\n"
                            + "    <ui:composition template=\"/template.xhtml\">\n"
                            + "        <ui:define name=\"title\">\n"
                            + "             <h1>Editar " + tabla + "</h1>"
                            + "        </ui:define>\n"
                            + "        <ui:define name=\"body\">          \n"
                            + "            <b:panel>\n"
                            + "                <h:form id=\"form\">\n"
                            + "                    <b:growl id=\"growlMsg\" globalOnly=\"true\" placementFrom=\"bottom\"\n"
                            + "                                 show-detail=\"true\" show-summary=\"false\" allowDismiss=\"true\"\n"
                            + "                                 delay=\"10000\" escape=\"true\" /> \n"
                            + "                    <b:panelGrid colSpans=\"2,8,2\" id=\"datos\">\n"
                            + columnasCreate + "\n"
                            + createReference + "\n"
                            + "                    </b:panelGrid>\n"
                            + "                    <br/> \n"
                            + "                    <b:commandButton styleClass=\"btn btn-primary btn-sm m\" value=\"Editar\" look=\"primary\" action=\"#{" + tabla + "Beans.edit()}\" update=\"form:datos, growlMsg\"/>\n"
                            + "                    <a class=\"btn btn-primary btn-sm m\" href=\"#{" + tabla + "Beans.list()}\">Cancelar</a>\n"
                            + "                </h:form>  \n"
                            + "            </b:panel>\n"
                            + "        </ui:define>\n"
                            + "    </ui:composition>\n"
                            + "</html>");
                    bw.close();
                }
            }
            templets(2);

        } catch (Exception ex) {

        } finally {
            con.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel mns;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == Hilo1) {
            try {
                mapeoEntity();
                if (boolControl) {
                    System.out.println("paso hacer beans. temp : " + temp);
                    if (this.temp == 0) {
                        System.out.println("basico");
                        crearViewBasic();
                    } else if (this.temp == 1) {
                        System.out.println("bootfaces");
                        crearViewPrimefacesBootfaces();
                    }

                }
                Hilo1.stop();
                //corredor1();            
            } catch (IOException ex) {
                Logger.getLogger(CreacionJCM.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CreacionJCM.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CreacionJCM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
