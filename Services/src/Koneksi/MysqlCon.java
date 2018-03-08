package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MysqlCon {

    private Connection Con = null;
    //String url = "jdbc:mysql://192.168.1.32:1358/";
    String url = "jdbc:mysql://127.0.0.1/";
    String db = "dbbklacc";
    String user = "root";
    String pass = "";
    //String user = "databasedo";
    //String pass = "Win32&serVer";

    public String GetUrl() {
        return url;
    }

    public String GetDb() {
        return db;
    }

    public String GetUser() {
        return user;
    }

    public String GetPass() {
        return pass;
    }

    public Connection getConnection() {
        try {
            Con = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Eror Tidak Dapat Terhubung Dengan Server !!!");
        }
        return Con;
    }
}
