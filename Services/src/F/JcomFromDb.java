/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import static F.Parsestringeror.GetErorString;
import Koneksi.MysqlCon;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class JcomFromDb extends JComboBox {

    String SQL;
    Connection con;
    boolean setawalkosong = true;

    public void JcomFromDb() {
        setFont(new java.awt.Font("Tahoma", 0, 14));
    }

    public void setaawalkosong(boolean b) {
        setawalkosong = b;
    }

    public void setQuery(String Query) {
        SQL = Query;
    }

    public void excute() {
        MysqlCon koneksi = new MysqlCon();
        con = koneksi.getConnection();
        try {
            DefaultComboBoxModel modelbaru1 = new DefaultComboBoxModel();
            setModel(modelbaru1);
            ArrayList<String> groupNames = new ArrayList<>();
            String JenisTransaksi;
            String query = SQL;
            //////system.out.printlnln("SA = " + setawalkosong);
            if (setawalkosong) {
                JenisTransaksi = "-";
                groupNames.add(JenisTransaksi);
            }
            PreparedStatement stmt = con.prepareStatement(query);
            //////system.out.printlnln(stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JenisTransaksi = rs.getString(1);
                groupNames.add(JenisTransaksi);
            }
            DefaultComboBoxModel model1 = new DefaultComboBoxModel(groupNames.toArray());
            setModel(model1);
        } catch (SQLException e) {
            out.println("E24" + e);
            showMessageDialog(null, GetErorString(e));
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                out.println("E25" + ex);
            }
        }
    }
}
