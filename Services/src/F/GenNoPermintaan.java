/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import static F.Datetostringwidthformat.getstringfromdate;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import static javax.swing.JOptionPane.showMessageDialog;

public class GenNoPermintaan {

    public static String GetNoPermintaanKerja(int JenisPerbaikan) {
        NumberFormat nf = new DecimalFormat("00000");
        String NoPermintaan = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPermintaan` FROM `tbpermintaan` order by `NoPermintaan` desc limit 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPermintaan = "00001" + "-" + getstringfromdate(new Date(), "YY") + "-SP";
            }
            while (rs.next()) {
                String autonumbers = rs.getString("NoPermintaan");
                autonumbers = autonumbers.substring(0, 5);
                int p = 1 + parseInt(autonumbers);
                if (p != 99999) {
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-SP";
                } else if (p == 99999) {
                    p = 1;
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-SP";
                }
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal mengambil Data");
        } finally {
            runSelct.closecon();
        }
        return NoPermintaan;
    }

    public static String GetNoPerintahKerja(int JenisPerbaikan) {
        NumberFormat nf = new DecimalFormat("00000");
        String NoPermintaan = null;
        String JP;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPerintahKerja` FROM `tbperintahkerja` order by `NoPerintahKerja` desc limit 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPermintaan = "00001" + "-" + getstringfromdate(new Date(), "YY") + "-SPK";
            }
            while (rs.next()) {
                String autonumbers = rs.getString("NoPerintahKerja");
                autonumbers = autonumbers.substring(0, 5);
                int p = 1 + parseInt(autonumbers);
                if (p != 99999) {
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-SPK";
                } else if (p == 99999) {
                    p = 1;
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-SPK";
                }
            }
        } catch (SQLException e) {
            out.println("E7" + e);
            showMessageDialog(null, "Gagal mengambil Data");
        } finally {
            runSelct.closecon();
        }
        return NoPermintaan;
    }

    public static String GenNoPermintaanBarang() {
        NumberFormat nf = new DecimalFormat("00000");
        String NoPermintaan = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPermintaanBarang` from `tbpermintaanbarang` order by `No` desc limit 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPermintaan = "00001" + getstringfromdate(new Date(), "YY") + "-" + "-PB";
            }
            while (rs.next()) {
                String autonumbers = rs.getString("NoPermintaanBarang");
                autonumbers = autonumbers.substring(0, 5);
                int p = 1 + parseInt(autonumbers);
                if (p != 99999) {
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-PB";
                } else if (p == 99999) {
                    p = 1;
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-PB";
                }
            }
        } catch (SQLException e) {
            out.println("E8" + e);
            showMessageDialog(null, "Gagal mengambil Data");
        } finally {
            runSelct.closecon();
        }
        return NoPermintaan;
    }

    public static String GenNoStockOpname() {
        NumberFormat nf = new DecimalFormat("00000");
        String NoPermintaan = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoOpnameSPK` from `tbopnamespk` order by `No` desc limit 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoPermintaan = "00001" + "-" + getstringfromdate(new Date(), "YY") + "-" + "OSPK";
            }
            while (rs.next()) {
                String autonumbers = rs.getString("NoOpnameSPK");
                autonumbers = autonumbers.substring(0, 5);
                int p = 1 + parseInt(autonumbers);
                if (p != 99999) {
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-OSPK";
                } else if (p == 99999) {
                    p = 1;
                    NoPermintaan = nf.format(p) + "-" + getstringfromdate(new Date(), "YY") + "-OSPK";
                }
            }
        } catch (SQLException e) {
            out.println("E9" + e);
            showMessageDialog(null, "Gagal mengambil Data");
        } finally {
            runSelct.closecon();
        }
        return NoPermintaan;
    }

    private GenNoPermintaan() {
    }
}
