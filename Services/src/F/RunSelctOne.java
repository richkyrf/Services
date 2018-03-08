/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import Koneksi.MysqlCon;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class RunSelctOne {

    String SQL;
    Connection con;
    String Erorm;
    boolean iskosong = false;

    public void setQuery(String Query) {
        SQL = Query + " LIMIT 1";
    }

    public void seterorm(String ErorM) {
        Erorm = ErorM;
    }

    public String excute() {
        String Hasil = null;
        MysqlCon koneksi = new MysqlCon();
        con = koneksi.getConnection();
        int rowsUpdated = 0;
        ResultSet rs = null;
        try {
            String changeLastName = SQL;
            PreparedStatement pstmt = con.prepareStatement(changeLastName);
            //////system.out.printlnln(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Hasil = rs.getString(1);
            }
        } catch (SQLException sqle) {
            out.println("E38" + sqle);
            if (Erorm != null) {
                showMessageDialog(null, Erorm);
            }
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                out.println("E39" + ex);
            }
        }
        return Hasil;
    }

}
