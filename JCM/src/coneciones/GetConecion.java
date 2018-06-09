/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coneciones;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author admin
 */
public class GetConecion {

    public static poolConecciones pool = null;

    public static poolConecciones getControllerpool(Properties p) {
        if (pool == null) {
            try {
                BasicDataSource DataSource = new BasicDataSource();
                String driver = "";
                String User, pass, url;
                System.out.println("vamos aqui ");
                driver = p.getProperty("driver");
                User = p.getProperty("user");
                pass = p.getProperty("password");
                url = "jdbc:mysql://" + p.getProperty("Servidor") + ":" + p.getProperty("Puerto").trim() + "/" + p.getProperty("NameBD").trim();
                System.out.println("url : " + url);
                DataSource.setDriverClassName(driver);
                DataSource.setUsername(User);
                DataSource.setPassword(pass);
                DataSource.setUrl(url);
                DataSource.setMaxActive(50);
                pool = new poolConecciones(DataSource);
                System.out.println("Conecto");
            } catch (Exception ex) {
                System.out.println("Error de conecion : " + ex.toString());
                pool = null;
            }

        }
        return pool;
    }

    public static poolConecciones getPool() {
        return pool;
    }

    public static void setPool(poolConecciones pool) {
        GetConecion.pool = pool;
    }

}
