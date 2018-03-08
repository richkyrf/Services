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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class JcomFromDBtable extends JComboBox {

    String SQL1;
    String SQL2;
    Connection con1;
    Connection con2;
    Vector columnNames1;
    Vector columnNames2;

    public void setQuery1(String QueryTable) {
        SQL1 = QueryTable + " LIMIT 1";
    }

    public void setQuery2(String QueryTable2) {
        SQL2 = QueryTable2 + " LIMIT 1";
    }

    public void excute1() {
        MysqlCon koneksi = new MysqlCon();
        con1 = koneksi.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = con1.prepareStatement(SQL1);
            //////system.out.printlnln(pstmt);
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            java.sql.ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            Vector data = new Vector(columnCount);
            Vector row = new Vector(columnCount);
            columnNames1 = new Vector(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                columnNames1.addElement(md.getColumnLabel(i));
            }
            DefaultComboBoxModel modelbaru1 = new DefaultComboBoxModel();
            setModel(modelbaru1);
            DefaultComboBoxModel model1 = new DefaultComboBoxModel(columnNames1);
            setModel(model1);
        } catch (SQLException e) {
            out.println("E20" + e);
            showMessageDialog(null, "Gagal mengambil data Jcombobox");
        } finally {
            try {
                con1.close();
            } catch (Exception ex) {
                out.println("E21" + ex);
                ex.printStackTrace();
            }
        }
    }

    public void excute2() {
        MysqlCon koneksi = new MysqlCon();
        con2 = koneksi.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = con2.prepareStatement(SQL2);
            //////system.out.printlnln(pstmt);
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            java.sql.ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            Vector data = new Vector(columnCount);
            Vector row = new Vector(columnCount);
            columnNames2 = new Vector(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                columnNames2.addElement(md.getColumnLabel(i));
            }
        } catch (SQLException e) {
            out.println("E22" + e);
            e.printStackTrace();
            showMessageDialog(null, "Gagal mengambil data Jcombobox");
        } finally {
            try {
                con2.close();
            } catch (Exception ex) {
                out.println("E23" + ex);
            }
        }
    }

    public Vector getcoloumname() {
        return columnNames2;
    }
}
