package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class firebirdCon {
        static Connection connection = null;
public static void connectfirebirdfirst(){
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            DriverManager.setLoginTimeout(1);
            connection = DriverManager.getConnection(
                    "jdbc:firebirdsql://192.168.1.32:3051/" + "D:\\GDB\\BKL.GDB",
                    "", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException E) {
            JOptionPane.showMessageDialog( null,"Gagal Koneksi Firebird \n Keluar dari program ");
            System.exit(1);
        }
}
    public static Connection getfirebirdcon() {
        return connection;
    }
}
