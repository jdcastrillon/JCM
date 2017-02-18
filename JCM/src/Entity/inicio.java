/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Modelo.forenKeys;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import view.Start;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author ASUS_01
 */
public class inicio {

    public static void main(String[] juan) throws SQLException, IOException {
        inicio a=new inicio();
//        a.mapeoEntity();
      
    }

    public void start() {
        new Start().setVisible(true);
    }

//    public void mapeoEntity() throws IOException, SQLException {
//        postgres conecion = postgres.getDbCon();
//        ArrayList<forenKeys> listForenKey = new ArrayList();
//        listForenKey = forenKeys(conecion, 1);
//        //        sqlServer conecion = sqlServer.getDbCon();
//        //Swing
////        String f = "src/JAJA";
////        String util = "src/util";
////        String persistencia = "src/JAJA/Persistencia.java";
////        String Utilidad = "src/JAJA/Util.java";
////        String rutaModelo = "src/JAJA";
//
//        //WEB
//        String f = "src/java/JAJA";
//        String util = "src/java/util";
//        String persistencia = "src/java/JAJA/Persistencia.java";
//        String Utilidad = "src/java/JAJA/Util.java";
//        String rutaModelo = "src/java/JAJA";
//        String rutaBeans = "";
////        File folder = new File(f);
////        folder.mkdir();
//
////        File folderUtil = new File(util);
////        folderUtil.mkdir();
////        String ruta = "src/JAJA/prueba.java";
//        String camposBD = "";
//        String GeterSeter = "";
//        String prepareInsert = "";
//        String InsertValores = "";
//        String TipoDato = "";
//        String CamposBDCopy = "";
//        String prepareEdit = "";
//        String fkTableName = "";
//        String CamposResulset = "";
//        boolean esKey = false;
//        ArrayList<String> primaryKey = new ArrayList();
//        String keysTable = "";
//        String importaciones = "";
//        boolean TieneCampos = false;
//        boolean TieneLLaves = false;
//        boolean TienePrimary = false;
//        int posicion = 0;
//
//        BufferedWriter bw = null;
//
////        bw = new BufferedWriter(new FileWriter(persistencia));
////        bw.write("\n"
////                + "package JAJA;"
////                + "import coneciones.postgres;"
////                + "import java.util.List;\n"
////                + "\n"
////                + "abstract class Persistencia {\n"
////                + "\n"
////                + "    postgres conecion = postgres.getDbCon();\n"
////                + "\n"
////                + "    public abstract int create();\n"
////                + "\n"
////                + "    public abstract int edit();\n"
////                + "\n"
////                + "    public abstract int remove();\n"
////                + "\n"
////                + "    public abstract List List();\n"
////                + "\n"
////                + "\n"
////                + "    public postgres getConecion() {\n"
////                + "      return conecion;\n"
////                + "    }\n"
////                + "\n"
////                + "    public void setConecion(postgres conecion) {\n"
////                + "      this.conecion = conecion;\n"
////                + "    }\n"
////                + "\n"
////                + "}\n"
////                + "");
////        bw.close();
//
//        int a = 1;
//        int count = 0;
//        DatabaseMetaData metaDatos = conecion.getconecion().getMetaData();
//        String v[] = {"TABLE"};
//        ResultSet rs = metaDatos.getTables(null, null, null, v);
//        
//        int rowcount = 0;
//        if (rs.last()) {
//            rowcount = rs.getRow();
//            rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
//        }
//        
//        System.out.println("-------------- cantidad: " + rowcount);
//        while (rs.next()) {
//            camposBD = "";
//            GeterSeter = "";
//            prepareInsert = "";
//            InsertValores = "";
//            importaciones = "";
//            keysTable = "";
//            primaryKey.clear();
//            prepareEdit = "";
//            TieneCampos = false;
//            TieneLLaves = false;
//            TienePrimary = false;
//            fkTableName = "";
//            CamposResulset = "";
//            posicion = 1;
//
//            String catalogo = rs.getString(1);
//            String tabla = rs.getString(3);
//            String tabla2 = rs.getString(4);
//            System.out.println("-- " + rs.getString(2));
//            System.out.println("-- " + rs.getString(4));
////            System.out.println("TABLA=" + tabla + " -- "  +tabla2);
////
////            rutaModelo = "src/java/JAJA/" + tabla + ".java";
////            rutaBeans = "src/java/Beans/" + tabla + ".java";
////            File archivo = new File(rutaModelo);
////            File archivoBean = new File(rutaModelo);
////
////            ResultSet rs3 = metaDatos.getPrimaryKeys(null, null, tabla);
////            while (rs3.next()) {
//////                System.out.println("---");
////                String pkey = rs3.getString("COLUMN_NAME");
////                primaryKey.add(pkey);
//////                System.out.println("primary key = " + pkey);
////            }
////
////            ResultSet rs2 = metaDatos.getColumns(catalogo, null, tabla, null);
////
////            while (rs2.next()) {
////                String nombreColumna = rs2.getString(4);
////                String tipoColumna = rs2.getString(6);
////                CamposBDCopy = nombreColumna;
////                esKey = false;
////                String isAutoIncrement = rs2.getString("IS_AUTOINCREMENT");
//////                System.out.println("columna " + nombreColumna + " - tipo : " + tipoColumna);
//////                System.out.println("-------------AUTOINCREMENT " + isAutoIncrement);
////
////                if (tipoColumna.equalsIgnoreCase("varchar")) {
////                    CamposBDCopy = "\"" + "'" + "\"" + "+" + nombreColumna + "+" + "\"" + "'" + "\"";
////                    TipoDato = "String";
////                } else if (tipoColumna.equalsIgnoreCase("date")) {
////                    CamposBDCopy = "\"" + "'" + "\"" + "+" + nombreColumna + "+" + "\"" + "'" + "\"";
////                    TipoDato = "Date";
////                    importaciones = importaciones + "import java.util.Date;\n";
////                } else if (tipoColumna.contains("numeric")) {
////                    TipoDato = "BigDecimal";
////                    importaciones = importaciones + "import java.math.BigDecimal;\n";
////
////                } else if (tipoColumna.equalsIgnoreCase("datetime")) {
////                    CamposBDCopy = "\"" + "'" + "\"" + "+" + nombreColumna + "+" + "\"" + "'" + "\"";
////                    TipoDato = "Date";
////                    importaciones = importaciones + "import java.util.Date;\n";
////                } else if (tipoColumna.equalsIgnoreCase("datetime")) {
////                    TipoDato = "Date";
////                }
////
////                for (String key : primaryKey) {
////                    if (key.equalsIgnoreCase(nombreColumna)) {
////                        keysTable = keysTable + "\"" + nombreColumna + "=\"" + "+" + CamposBDCopy + "+" + "\"" + " and " + "\"" + "+";
////                        esKey = true;
////                        TienePrimary = true;
//////                        System.out.println("es primary");
////                        break;
////                    }
////                }
////
////                camposBD = camposBD + "public " + TipoDato + " " + nombreColumna + ";\n";
////                if (isAutoIncrement.equalsIgnoreCase("NO")) {
////                    prepareInsert = prepareInsert + nombreColumna + ",";
////                    InsertValores = InsertValores + "+" + CamposBDCopy + "+" + "\"" + "," + "\"";
////                    TieneCampos = true;
////                }
////                if (esKey == false) {
////                    prepareEdit = prepareEdit + "\"" + nombreColumna + "=\"" + "+" + CamposBDCopy + "+" + "\"" + "," + "\"+";
////                    TieneLLaves = true;
////                }
////                CamposResulset = CamposResulset + "tabla.set" + nombreColumna.substring(0, 1).toUpperCase() + "" + nombreColumna.substring(1, nombreColumna.length()) + "(rs.get" + TipoDato + "(" + posicion + "));\n";
////                GeterSeter = GeterSeter + "\n" + "public " + TipoDato + " get" + nombreColumna.substring(0, 1).toUpperCase() + "" + nombreColumna.substring(1, nombreColumna.length()) + "() {\n"
////                        + " return " + nombreColumna + ";\n"
////                        + "}\n"
////                        + "\n"
////                        + "public void set" + nombreColumna.substring(0, 1).toUpperCase() + "" + nombreColumna.substring(1, nombreColumna.length()) + "(" + TipoDato + " " + nombreColumna + ") {\n"
////                        + "   this." + nombreColumna + " = " + nombreColumna + ";\n"
////                        + "}\n";
////                posicion++;
////            }
////            if (TieneCampos) {
////                InsertValores = InsertValores.substring(0, InsertValores.length() - 4);
////                prepareInsert = prepareInsert.substring(0, prepareInsert.length() - 1);
////            }
////            if (TieneLLaves) {
////                prepareEdit = prepareEdit.substring(0, prepareEdit.length() - 4);
////            }
////            if (TienePrimary) {
//////                System.out.println("--" + keysTable);
////                keysTable = keysTable.substring(0, keysTable.length() - 9);
//////                System.out.println("-- :: " + keysTable);
////            }
////
//////            System.out.println("-- : " + prepareEdit);
////            for (forenKeys foren : listForenKey) {
////                if (foren.getTableReference().equalsIgnoreCase(tabla)) {
////                    fkTableName = fkTableName + "List<" + foren.getTable() + "> List_" + foren.getTable() + " = new ArrayList();\n";
////                    importaciones = importaciones + "import java.util.List;\n";
////                }
////
////            }
////
////            bw = new BufferedWriter(new FileWriter(archivo));
////            bw.write("package JAJA;\n"
////                    + "import java.sql.SQLException;\n"
////                    + "import java.util.ArrayList;\n"
////                    + "import java.io.Serializable;\n"
////                    + "import java.sql.ResultSet;\n"
////                    + importaciones + "\n"
////                    + "public class " + tabla + " extends Persistencia implements Serializable{\n"
////                    + "\n" + camposBD + "\n"
////                    + "\n" + fkTableName + "\n"
////                    + "public " + tabla + "() {\n"
////                    + "  super();"
////                    + "}\n"
////                    + "\n" + GeterSeter + "\n"
////                    + "\n" + "@Override\n"
////                    + "public int create() {\n"
////                    + " int transaccion=-1;\n"
////                    + " String prepareInsert=\"insert into " + tabla + " (" + prepareInsert + ") values (" + "\"" + InsertValores + "+" + "\"" + ")" + "\";"
////                    + "\n try {\n"
////                    + "    transaccion=" + tabla + ".super.getConecion().transaccion(prepareInsert);\n"
////                    + " } catch (SQLException ex) {\n"
////                    + "    System.out.println(\"Error SQL : \" + ex.toString());\n"
////                    + " }\n"
////                    + "return transaccion;  "
////                    + "}\n"
////                    + "\n"
////                    + "@Override\n"
////                    + "public int edit() {\n"
////                    + " int transaccion=-1;\n"
////                    + " String prepareEdit=\"update " + tabla + " set \"+" + prepareEdit + "\" where \"" + "+" + keysTable + ";"
////                    + "\n try {\n"
////                    + "    transaccion=" + tabla + ".super.getConecion().transaccion(prepareEdit);\n"
////                    + " } catch (SQLException ex) {\n"
////                    + "    System.out.println(\"Error SQL : \" + ex.toString());\n"
////                    + " }\n"
////                    + "return transaccion;  "
////                    + "}\n"
////                    + "\n"
////                    + "@Override\n"
////                    + "public int remove() {\n"
////                    + " int transaccion=-1;\n"
////                    + " String prepareDelete=\"delete from  " + tabla + " where \"" + "+" + keysTable + ";"
////                    + "\n try {\n"
////                    + "    transaccion=" + tabla + ".super.getConecion().transaccion(prepareDelete);\n"
////                    + " } catch (SQLException ex) {\n"
////                    + "    System.out.println(\"Error SQL : \" + ex.toString());\n"
////                    + " }\n"
////                    + "return transaccion;  "
////                    + "}\n"
////                    + "\n"
////                    + "@Override\n"
////                    + "public java.util.List<" + tabla + "> List() {\n"
////                    + "  ArrayList<" + tabla + "> list" + tabla + "=new ArrayList();\n"
////                    + " String prepareQuery=\"select * from " + tabla + "\";\n"
////                    + "        try {\n"
////                    + "            ResultSet rs =" + tabla + ".super.getConecion().query(prepareQuery);\n"
////                    + " while (rs.next()) { \n"
////                    + tabla + " tabla = new " + tabla + "();\n"
////                    + "\n" + CamposResulset + "\n"
////                    + "\n list" + tabla + ".add(tabla);\n"
////                    + "}\n"
////                    + "        } catch (SQLException ex) {\n"
////                    + "            System.out.println(\"Error Consulta : \" + ex.toString());\n"
////                    + "        }\n"
////                    + "        return list" + tabla + ";\n"
////                    + "}" + "\n"
////                    + "}");
////            bw.close();
//
//        }
//    }
//
//    public ArrayList<forenKeys> forenKeys(postgres conecion, int condicion) throws SQLException {
////        postgres conecion = postgres.getDbCon();
//        ArrayList<forenKeys> listForenKey = new ArrayList();
//        DatabaseMetaData metaDatos = conecion.getconecion().getMetaData();
//        String v[] = {"TABLE"};
//        ResultSet rs = metaDatos.getTables(null, null, null, v);
//        while (rs.next()) {
//            String tabla = rs.getString(3);
//            ResultSet rs4 = metaDatos.getExportedKeys(null, null, tabla);
//            while (rs4.next()) {
////                fkTableName = fkTableName + "List<" + rs4.getString("FKTABLE_NAME") + "> List_" + rs4.getString("FKTABLE_NAME") + " = new ArrayList();\n";
//                String forenK = rs4.getString("FKTABLE_NAME");
//                String fkColumnName = rs4.getString("FKCOLUMN_NAME");
//                if (condicion == 1) {
//                    listForenKey.add(new forenKeys(tabla, forenK));
//                    System.out.println("reference : " + tabla + " references  : " + forenK);
////                importaciones = importaciones + "import java.util.List;\n";
//                } else if (condicion == 2) {
//                    listForenKey.add(new forenKeys(tabla, forenK, fkColumnName));
//                    System.out.println("reference : " + tabla + " references  : " + forenK);
//                }
//            }
//
//        }
//        return listForenKey;
//    }
//
//    public void generarControladoresWeb() throws IOException, SQLException {
//        postgres conecion = postgres.getDbCon();
//        ArrayList<forenKeys> listForenKey = new ArrayList();
//        listForenKey = forenKeys(conecion, 2);
//        //        sqlServer conecion = sqlServer.getDbCon();
//        //Swing
////        String f = "src/JAJA";
////        String util = "src/util";
////        String persistencia = "src/JAJA/Persistencia.java";
////        String Utilidad = "src/JAJA/Util.java";
////        String rutaModelo = "src/JAJA";
//
//        //WEB
//        String f = "src/java/Beans";
//        String util = "src/java/util";
//        String persistencia = "src/java/JAJA/Persistencia.java";
//        String rutaBeans = "";
//        String referencias = "";
//        File folder = new File(f);
//        folder.mkdir();
//
////        File folderUtil = new File(util);
////        folderUtil.mkdir();
////        String ruta = "src/JAJA/prueba.java";
//        BufferedWriter bw = null;
//
//        int a = 1;
//        int b = 0;
//        int count = 0;
//        String columnas = "";
//        String catalogo = "";
//        String columnasCreate = "";
//        String createReference = "";
//        String ColumnasDate = "";
//        boolean r = false;
//
//        DatabaseMetaData metaDatos = conecion.getconecion().getMetaData();
//        String v[] = {"TABLE"};
//        ResultSet rs = metaDatos.getTables(null, null, null, v);
//        while (rs.next()) {
//            String tabla = rs.getString(3);
//            catalogo = rs.getString(1);
//            referencias = "";
//            rutaBeans = "src/java/Beans/" + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans.java";
//            File archivo = new File(rutaBeans);
//            b = 0;
//            columnas = "";
//            columnasCreate = "";
//            ColumnasDate = "";
//            createReference = "";
//            r = false;
//
//            File folderweb = new File("web/" + tabla);
//            folderweb.mkdir();
//
//            for (forenKeys foren : listForenKey) {
//                if (foren.getTableReference().equalsIgnoreCase(tabla)) {
//                    if (b == 0) {
//                        b++;
//                        referencias = referencias + " public List<" + foren.getTableReference() + "> getItems() {\n"
//                                + "        list_objecto.clear();\n"
//                                + "        list_objecto = objecto.List();\n"
//                                + "        return list_objecto;\n"
//                                + "    }\n";
//                    }
//                }
//
//            }
//
//            bw = new BufferedWriter(new FileWriter(archivo));
//            bw.write("package Beans;\n"
//                    + "\n"
//                    + "import JAJA." + tabla + ";\n"
//                    + "import javax.inject.Named;\n"
//                    + "import javax.enterprise.context.SessionScoped;\n"
//                    + "import java.io.Serializable;\n"
//                    + "import java.util.ArrayList;\n"
//                    + "import java.util.List;\n"
//                    + "import javax.annotation.PostConstruct;\n"
//                    + "import javax.faces.application.FacesMessage;\n"
//                    + "import javax.faces.context.FacesContext;\n"
//                    + "\n"
//                    + "\n"
//                    + "@Named(value = \"" + tabla + "Beans\")\n"
//                    + "@SessionScoped\n"
//                    + "public class " + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans implements Serializable {\n"
//                    + "\n"
//                    + "    " + tabla + " objecto;\n"
//                    + "    List<" + tabla + "> list_objecto = new ArrayList();\n"
//                    + "\n"
//                    + "    @PostConstruct\n"
//                    + "    public void init() {\n"
//                    + "        cargaDatos();\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public void cargaDatos() {\n"
//                    + "        list_objecto.clear();\n"
//                    + "        list_objecto = objecto.List();\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public " + tabla.substring(0, 1).toUpperCase() + "" + tabla.substring(1, tabla.length()) + "Beans() {\n"
//                    + "        objecto = new " + tabla + "();\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public String prepareEdit(" + tabla + " obj) {\n"
//                    + "        objecto = obj;\n"
//                    + "        return \"edit\";\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public String prepradeCreate() {\n"
//                    + "        objecto = new " + tabla + "();\n"
//                    + "        return \"create\";\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public String create() {\n"
//                    + "        objecto.create();\n"
//                    + "        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, \"Exito al " + tabla + "\", \"\");\n"
//                    + "        FacesContext.getCurrentInstance().addMessage(null, facesMsg);\n"
//                    + "         objecto = new " + tabla + "();\n"
//                    + "        return null;\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public String list() {\n"
//                    + "        cargaDatos();\n"
//                    + "        return \"list\";\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public String delete(" + tabla + " obj) {\n"
//                    + "        objecto = obj;\n"
//                    + "        objecto.remove();\n"
//                    + "        cargaDatos();\n"
//                    + "        return \"list\";\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public String edit() {\n"
//                    + "        objecto.edit();\n"
//                    + "        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, \"Exito al Editar\", \"\");\n"
//                    + "        FacesContext.getCurrentInstance().addMessage(null, facesMsg);\n"
//                    + "        return null;\n"
//                    + "    }\n"
//                    + "\n"
//                    + "\n" + referencias + "\n"
//                    + "    public " + tabla + " getObject() {\n"
//                    + "        if (objecto == null) {\n"
//                    + "            objecto = new " + tabla + "();\n"
//                    + "        }\n"
//                    + "        return objecto;\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public void setObject(" + tabla + " obj) {\n"
//                    + "        this.objecto = obj;\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public List<" + tabla + "> getLista() {\n"
//                    + "        return list_objecto;\n"
//                    + "    }\n"
//                    + "\n"
//                    + "    public void setLista(List<" + tabla + "> lista) {\n"
//                    + "        this.list_objecto = lista;\n"
//                    + "    }\n"
//                    + "\n"
//                    + "}\n"
//                    + "");
//            bw.close();
//
//            ResultSet rs2 = metaDatos.getColumns(catalogo, null, tabla, null);
//
//            while (rs2.next()) {
//                String nombreColumna = rs2.getString(4);
//                String tipoColumna = rs2.getString(6);
//                String isAutoIncrement = rs2.getString("IS_AUTOINCREMENT");
//                r = false;
//
//                columnas = columnas + "\n" + "              <h:column>\n"
//                        + "              <f:facet name=\"header\">" + tabla + "</f:facet>\n"
//                        + "              #{" + tabla + "." + nombreColumna + "}\n"
//                        + "              </h:column>" + "\n";
//
//                for (forenKeys fk : listForenKey) {
//                    if (fk.getTableReference().equalsIgnoreCase(tabla)) {
//
//                        if (fk.getColumn().equalsIgnoreCase(nombreColumna)) {
//                            r = true;
//                            createReference = createReference + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
//                                    + "                <h:selectOneMenu value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" >\n"
//                                    + "                    <f:selectItems value=\"#{" + fk.getTableReference() + "Beans.items}\" var=\"" + nombreColumna + "\" \n"
//                                    + "                                   itemLabel=\"#{" + nombreColumna + "." + fk.getColumn() + "}\" "
//                                    + "                                   itemValue=\"#{" + nombreColumna + "." + fk.getColumn() + "}\"></f:selectItems>\n"
//                                    + "                </h:selectOneMenu>" + "\n";
//                            break;
//                        }
//
//                    }
//                }
//
//                if (r == false && isAutoIncrement.equalsIgnoreCase("NO")) {
//                    if (tipoColumna.equalsIgnoreCase("date")) {
//                        columnasCreate = columnasCreate + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
//                                + "                <h:inputText label=\"" + nombreColumna + "\"  id=\"" + nombreColumna + "\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\"\n"
//                                + "                requiredMessage=\"Ingregse " + nombreColumna + "\" >" + "\n" + "  <f:convertDateTime pattern=\"MM/dd/yyyy\" />\n"
//                                + "                </h:inputText>";
//                    } else if (tipoColumna.equalsIgnoreCase("datetime")) {
//                        columnasCreate = columnasCreate + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
//                                + "                <h:inputText label=\"" + nombreColumna + "\"  id=\"" + nombreColumna + "\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\"\n"
//                                + "                requiredMessage=\"Ingregse " + nombreColumna + "\" >" + "\n" + "  <f:convertDateTime pattern=\"MM/dd/yyyy\" />\n"
//                                + "                </h:inputText>";
//                    } else {
//                        columnasCreate = columnasCreate + "\n" + "                <h:outputLabel value=\"" + nombreColumna + "\" />\n"
//                                + "                <h:inputText label=\"" + nombreColumna + "\"  id=\"" + nombreColumna + "\" value=\"#{" + tabla + "Beans.object." + nombreColumna + "}\" required=\"true\"\n"
//                                + "                requiredMessage=\"Ingregse " + nombreColumna + "\" />" + "\n";
//                    }
//
//                }
//
//            }
//
//            bw = new BufferedWriter(new FileWriter("web/" + tabla + "/list.xhtml"));
//            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
//                    + "<!DOCTYPE html>\n"
//                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
//                    + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
//                    + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\">\n"
//                    + "    <h:head>\n"
//                    + "        <title>" + tabla + "</title>\n"
//                    + "    </h:head>\n"
//                    + "    <h:body>\n"
//                    + "        <h:form>\n"
//                    + "            <h1>Lista " + tabla + "</h1>\n"
//                    + "            <h:dataTable value=\"#{" + tabla + "Beans.lista}\" var=\"" + tabla + "\" >\n"
//                    + columnas + "\n"
//                    + "                <h:column>\n"
//                    + "                    <f:facet name=\"header\">Opciones</f:facet>\n"
//                    + "                    <h:commandButton value=\"Editar\" action=\"#{" + tabla + "Beans.prepareEdit(" + tabla + ")}\"></h:commandButton>\n"
//                    + "                    <h:commandButton value=\"Borrar\" action=\"#{" + tabla + "Beans.delete(" + tabla + ")}\"></h:commandButton>\n"
//                    + "                </h:column>      \n"
//                    + "\n"
//                    + "            </h:dataTable>\n"
//                    + "            <br/>\n"
//                    + "            <h:commandButton value=\"Nuevo\" action=\"#{" + tabla + "Beans.prepradeCreate()}\"></h:commandButton>\n"
//                    + "        </h:form>\n"
//                    + "    </h:body>\n"
//                    + "</html>");
//            bw.close();
//
//            bw = new BufferedWriter(new FileWriter("web/" + tabla + "/create.xhtml"));
//            bw.write("<?xml version='1.0' encoding='UTF-8' ?>\n"
//                    + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\""
//                    + " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
//                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
//                    + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
//                    + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\">\n"
//                    + "    <h:head>\n"
//                    + "        <title>" + tabla + "</title>\n"
//                    + "    </h:head>\n"
//                    + "    <h:body>\n"
//                    + "        <h3>Crear " + tabla + "</h3>\n"
//                    + "        <h:panelGroup id=\"msg\" layout=\"block\">\n"
//                    + "            <h:messages errorStyle=\"color: red\" infoStyle=\"color: green\" layout=\"table\"/>\n"
//                    + "        </h:panelGroup>\n"
//                    + "        <h:form>\n"
//                    + "            <h:panelGrid columns=\"2\">\n"
//                    + columnasCreate + "\n"
//                    + createReference + "\n"
//                    + "            </h:panelGrid>\n"
//                    + "            <br/>"
//                    + "            <h:commandButton value=\"guardar\" action=\"#{" + tabla + "Beans.create()}\"></h:commandButton>\n"
//                    + "            <br/>\n"
//                    + "            <h:commandButton value=\"List\" action=\"#{" + tabla + "Beans.list()}\" immediate=\"true\"></h:commandButton>\n"
//                    + "        </h:form>\n"
//                    + "    </h:body>\n"
//                    + "</html>");
//            bw.close();
//            bw = new BufferedWriter(new FileWriter("web/" + tabla + "/edit.xhtml"));
//            bw.write("<?xml version='1.0' encoding='UTF-8' ?>\n"
//                    + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\""
//                    + " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
//                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
//                    + "      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"\n"
//                    + "      xmlns:h=\"http://xmlns.jcp.org/jsf/html\">\n"
//                    + "    <h:head>\n"
//                    + "        <title>" + tabla + "</title>\n"
//                    + "    </h:head>\n"
//                    + "    <h:body>\n"
//                    + "        <h3>Editar " + tabla + "</h3>\n"
//                    + "        <h:panelGroup id=\"msg\" layout=\"block\">\n"
//                    + "            <h:messages errorStyle=\"color: red\" infoStyle=\"color: green\" layout=\"table\"/>\n"
//                    + "        </h:panelGroup>\n"
//                    + "        <h:form>\n"
//                    + "            <h:panelGrid columns=\"2\">\n"
//                    + columnasCreate + "\n"
//                    + createReference + "\n"
//                    + "            </h:panelGrid>\n"
//                    + "            <br/>"
//                    + "            <h:commandButton value=\"editar\" action=\"#{" + tabla + "Beans.edit()}\"></h:commandButton>\n"
//                    + "            <br/>\n"
//                    + "            <h:commandButton value=\"List\" action=\"#{" + tabla + "Beans.list()}\" immediate=\"true\"></h:commandButton>\n"
//                    + "        </h:form>\n"
//                    + "    </h:body>\n"
//                    + "</html>");
//            bw.close();
//        }
//    }

}
