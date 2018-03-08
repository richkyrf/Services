/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import static F.ErorMessage.cekeror;
import Koneksi.MysqlCon;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class RunUpd {

    String SQL;
    Connection con;
    String Erorm = null;
    SQLException e;
    PreparedStatement pstmt;
    int returnkey;

    boolean setreturnkey = false;

    public void setQuery(boolean s) {
        setreturnkey = s;
    }

    public void setQuery(String Query) {
        SQL = Query;
    }

    public void seterorm(String p) {
        Erorm = p;
    }

    public int excute() {
        MysqlCon koneksi = new MysqlCon();
        con = koneksi.getConnection();
        int rowsUpdated = 0;
        try {
            String changeLastName = SQL;
            PreparedStatement pstmtx = con.prepareStatement(changeLastName);
            //////system.out.printlnln(pstmtx);
            if (setreturnkey) {
                pstmtx = con.prepareStatement(changeLastName, RETURN_GENERATED_KEYS);
            }
            rowsUpdated = pstmtx.executeUpdate();
            if (setreturnkey) {
                ResultSet rs = pstmtx.getGeneratedKeys();
                if (rs.next()) {
                    returnkey = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            out.println("E40" + ex);
            String em = cekeror(ex);
            if (Erorm != null) {
                showMessageDialog(null, Erorm + "\n " + em);
            }
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                out.println("E41" + ex);
            }
        }
        return rowsUpdated;
    }

    public int getreturnkey() {
        return returnkey;
    }
}
