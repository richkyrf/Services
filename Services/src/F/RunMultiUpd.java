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
import java.sql.SQLException;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class RunMultiUpd {

    List<String> SQL;
    Connection con;
    String Erorm = null;
    SQLException e;
    PreparedStatement pstmt;

    public void setQuery(List<String> Query) {
        SQL = Query;
    }

    public void seterorm(String p) {
        Erorm = p;
    }

    public int excute() {
        MysqlCon koneksi = new MysqlCon();
        con = koneksi.getConnection();
        setAutoCommit(false);
        int rowsUpdated = 0;
        try {
            List<String> changeLastName = SQL;
            int size = changeLastName.size();
            for (int i = 0; i < size; i++) {
                PreparedStatement pstmtx = con.prepareStatement(changeLastName.get(i));
                System.out.println(pstmtx);
                pstmtx.executeUpdate();
            }
            con.commit();
            rowsUpdated = 1;
        } catch (SQLException ex) {
            out.println("E32" + e);
            setRollback();
            String em = cekeror(ex);
            if (Erorm != null) {
                showMessageDialog(null, Erorm + "\n " + em);
            }
        } finally {
            setAutoCommit(true);
            try {
                con.close();
            } catch (Exception ex) {
                out.println("E33" + e);
            }
        }
        return rowsUpdated;
    }

    void setAutoCommit(boolean b) {
        try {
            con.setAutoCommit(b);
        } catch (Exception ex) {
            out.println("E34" + e);
        }
    }

    void setRollback() {
        try {
            con.rollback();
        } catch (Exception ex) {
            out.println("E35" + e);
        }
    }

}
