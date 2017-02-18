package coneciones;

//import JAJA.categoria;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlServer {

    public static String driver = "org.postgresql.Driver";
    public static String connectString = "jdbc:postgresql://localhost:5432/compraventa";
    public static String user = "sa";
    public static String password = "ju94da99";//ya esta listo
    public static String query;
    public static Statement stat;
    public static ResultSet rs;
    public static Connection con;
    private static sqlServer db;

    private sqlServer() {
        boolean r = false;
        try {
            Class.forName(driver);
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=FairPlay;user=" + user + ";password=" + password + ";";
            con = DriverManager.getConnection(connectionUrl);
            stat = con.createStatement();
            r = true;
            System.out.println("conecto");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sqlServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static synchronized sqlServer getDbCon() {
        if (db == null) {
            System.out.println("nuevo");
            db = new sqlServer();
        }
        return db;

    }

    public ResultSet query(String query) throws SQLException {
        stat = db.con.createStatement();
        ResultSet res = stat.executeQuery(query);
        return res;
    }

    public int transaccion(String insertQuery) throws SQLException {
        stat = db.con.createStatement();
        int result = stat.executeUpdate(insertQuery);
        return result;
    }

    public Connection getconecion() {
        return con;
    }

    public static boolean ejecuteQuery(String x) throws SQLException {
        boolean r = true;
        try {
            rs = stat.executeQuery(x);
        } catch (SQLException e) {
            System.out.println("ERROR AL HACER QUERY " + e.toString());

            r = false;
        }
        return r;
    }

    public static boolean ejecuteUpdate(String query) {
        boolean r = true;
        try {
            stat.executeUpdate(query);
            r = true;
        } catch (SQLException e) {
            System.out.println("ERROR Al HACER UPDTAPE" + e.toString());
            r = false;
        }
        return r;
    }

    public static void cerrarConexion() {
        try {
            stat.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en cerrar la base de datos" + e.toString());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
////
        sqlServer conecion = sqlServer.getDbCon();
//       categoria cate=new categoria();
//       cate.setidcategoria(new BigDecimal(37));
//       cate.setdescripcion("kikiki-----++++-----");
//       cate.remove();
//     
    }
}
