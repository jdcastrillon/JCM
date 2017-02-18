package coneciones;

import java.sql.*;
import java.util.Properties;

public class TestBD {

    public static String driver = "org.postgresql.Driver";
    public static String connectString = "jdbc:postgresql://localhost:5432/Inventario";
    public static String user = "postgres";
    public static String password = "Juan";//ya esta listo
    public static String query;
    public static Statement stat;
    public static ResultSet rs;
    public static Connection con;

    public boolean conectar(Properties p) throws ClassNotFoundException {
        boolean r = false;
        try {
            String url = "";
            if (p.getProperty("BD").equalsIgnoreCase("postgresql")) {
                url = "jdbc:" + p.getProperty("BD") + "://"
                        + p.getProperty("Servidor") + ":" + p.getProperty("Puerto") + "/" + p.getProperty("NameBD");
            } else if (p.getProperty("BD").equalsIgnoreCase("sqlserver")) {
                url = "jdbc:" + p.getProperty("BD") + "://"
                        + p.getProperty("Servidor") + ":" + p.getProperty("Puerto") + ";databaseName=" + p.getProperty("NameBD");
            }
            System.out.println(url);
            System.out.println("--- : " + p.getProperty("driver"));
            Class.forName(p.getProperty("driver"));
            con = DriverManager.getConnection(url, p.getProperty("user"), p.getProperty("password"));
            stat = con.createStatement();
            r = true;
            return r;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return r;
        }
    }
    
    public Connection getconecion(){
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

    public void cerrarConexion() {
        try {
            stat.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en cerrar la base de datos" + e.toString());
        }
    }

//    public static void main(String[] args) throws ClassNotFoundException {
////        conectar();
//        Properties p = new Properties();
//        p.put("user", "postgres");
//        p.put("password", "Juan");
//        p.put("BD", "postgresql");
//        p.put("Servidor", "localhost");
//        p.put("Puerto", "5432");
//        p.put("NameBD", "compraventa");
//        p.put("driver", "org.postgresql.Driver");
//
//        boolean a = TestBD.conectar(p);
//        if (a) {
//            System.out.println("bien");
//        } else {
//            System.out.println("no conecto");
//        }
//        TestBD.cerrarConexion();
//    }
}
