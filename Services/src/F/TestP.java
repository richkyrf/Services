package F;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author JACK
 */
public class TestP {

    public static String StPrint(String NoPermintaanBarang, String Mechanik, String Pimpinan, String PrintedBy) {
        System.out.println("F.TestP.StPrint() =" + NoPermintaanBarang + "=" + Mechanik + "=" + Pimpinan + "=" + PrintedBy + "=");
        try {
            NumberFormat formatter = new DecimalFormat("#,###,###");
            Object[][] data = null;
            RunSelct runSelct = new RunSelct();
            runSelct.setQuery("SELECT a.`No`, a.`NoPerintahKerja`, a.`NoPermintaanBarang`, a.`Tgl`, a.`Plat`, a.`Sopir`, a.`User`,`NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,KaMekanikb,`Keterangan`,`Keteranganpb` FROM `tbpermintaanbarang` a join  `tbdetailpermintaanbarang` b on a.`NoPermintaanBarang`=b.`NoPermintaanBarang`where a.`NoPermintaanBarang` = '" + NoPermintaanBarang + "'");
            ResultSet rs = runSelct.excute();
            rs.last();
            rs.beforeFirst();
            int i = 0;
            data = new Object[12][16];
            for (int x = 0; x < 10; x++) {
                data[x][0] = "";
                data[x][1] = "";
                data[x][2] = "";
                data[x][3] = "";
                data[x][4] = "";
                data[x][5] = "";
                data[x][6] = "";
                data[x][7] = "";
                data[x][8] = "";
                data[x][9] = "";
                data[x][10] = "";
                data[x][11] = "";
                data[x][12] = "";
                data[x][13] = "";
                data[x][14] = "";
            }
            if (!rs.isBeforeFirst()) {
                data[i][0] = "";
                data[i][1] = "";
                data[i][2] = "";
                data[i][3] = "";
                data[i][4] = "";
                data[i][5] = "";
                data[i][6] = "";
                data[i][7] = "";
                data[i][8] = "";
                data[i][9] = "";
                data[i][10] = "";
                data[i][11] = "";
                data[i][12] = "";
                data[i][13] = "";
                data[i][14] = "";
            }
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getObject(2);
                data[i][2] = rs.getObject(3);
                data[i][3] = rs.getObject(4);
                data[i][4] = rs.getObject(5);
                data[i][5] = rs.getObject(6);
                data[i][6] = rs.getObject(7);
                data[i][7] = rs.getObject(8);
                data[i][8] = rs.getObject(9);
                data[i][9] = rs.getObject(10);
                System.out.println("F.TestP.StPrint() 19 "+rs.getObject(10));
                data[i][10] = rs.getObject(11);
                System.out.println("F.TestP.StPrint() 10 "+rs.getObject(11));
                data[i][11] = rs.getObject(12);
                System.out.println("F.TestP.StPrint() 11 "+rs.getObject(12));
                data[i][12] = rs.getObject(13);
                System.out.println("F.TestP.StPrint() 12 "+rs.getObject(13));
                data[i][13] = rs.getObject(14);
                System.out.println("F.TestP.StPrint() 13 "+rs.getObject(14));
                data[i][14] = rs.getObject(15);
                System.out.println("F.TestP.StPrint() 14 "+rs.getObject(15));
                i++;
            }
            String x;
            x = "";
            if (data[0][1] == null) {
                data[0][1] = "";
            }
            String km;
            if ("0".equals(data[0][12].toString())) {
                km = "Putus";
            } else {
                km = formatter.format(data[0][10]);
            }
            x += String.format("%-80s%n", "                             SURAT PERMINTAAN BARANG                            ");
            x += String.format("%-80s%n", "  --------------------------------------------------------------------------  ");
            x += String.format("%-56s%-24s%n", "  No Permintaan Barang:" + (subobj(data[0][2], 34)), "Plat : " + subobj(data[0][4], 12));
            x += String.format("%-56s%-24s%n", "  No SPK              :" + (subobj(data[0][1], 34)), "KM   :" + subobj(km, 12));
            x += String.format("%-80s%n", "  Tanggal             :" + (subobj(F.Datetostringwidthformat.getstringfromdate(F.Datetostringwidthformat.getdatefromstring(data[0][3].toString(), "yyyy-MM-dd HH:mm"), "dd/MM/yyyy HH:mm"), 34)));
            x += String.format("%-80s%n", "  Sopir/Mekanik       :" + (subobj(data[0][5], 34)));
            x += String.format("%-80s%n", "  +---+---------+----------------------------------------+--------+---------+");
            x += String.format("%-80s%n", "  |No |Kd Barang|Jenis Permintaan                        |Jumlah  |Satuan   |");
            x += String.format("%-80s%n", "  +---+---------+----------------------------------------+--------+---------+");

            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[0][7], 3), "|", subobj(data[0][8], 9), "|", subobj(data[0][9], 34), "|", subobj(data[0][10], 8), "|", subobj(data[0][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[1][7], 3), "|", subobj(data[1][8], 9), "|", subobj(data[1][9], 34), "|", subobj(data[1][10], 8), "|", subobj(data[1][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[2][7], 3), "|", subobj(data[2][8], 9), "|", subobj(data[2][9], 34), "|", subobj(data[2][10], 8), "|", subobj(data[2][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[3][7], 3), "|", subobj(data[3][8], 9), "|", subobj(data[3][9], 34), "|", subobj(data[3][10], 8), "|", subobj(data[3][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[4][7], 3), "|", subobj(data[4][8], 9), "|", subobj(data[4][9], 34), "|", subobj(data[4][10], 8), "|", subobj(data[4][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[5][7], 3), "|", subobj(data[5][8], 9), "|", subobj(data[5][9], 34), "|", subobj(data[5][10], 8), "|", subobj(data[5][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[6][7], 3), "|", subobj(data[6][8], 9), "|", subobj(data[6][9], 34), "|", subobj(data[6][10], 8), "|", subobj(data[6][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[7][7], 3), "|", subobj(data[7][8], 9), "|", subobj(data[7][9], 34), "|", subobj(data[7][10], 8), "|", subobj(data[7][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[8][7], 3), "|", subobj(data[8][8], 9), "|", subobj(data[8][9], 34), "|", subobj(data[8][10], 8), "|", subobj(data[8][11], 8), "|");
            x += String.format("%-3s%-3s%-1s%-9s%-1s%-40s%-1s%-8s%-1s%-8s%-1s%n", "  |", subobj(data[9][7], 3), "|", subobj(data[9][8], 9), "|", subobj(data[9][9], 34), "|", subobj(data[9][10], 8), "|", subobj(data[9][11], 8), "|");
            x += String.format("%-80s%n", "  +---+---------+----------------------------------------+--------+---------+");
            
            x += String.format("%-80s%n", "  Ket:" + subobj(data[0][14], 74));
            x += String.format("%-80s%n", "      " + subobj(data[0][14], 75,148));
            
            x += String.format("%-80s%n", "  +-----------------------+-----------------------+------------------------+    ");
            x += String.format("%-3s%-23s%-1s%-23s%-1s%-24s%-5s%n", "  |", "Di keluarkan oleh", "|", "Di Ketahui oleh", "|", "Di Ajukan oleh", "|    ");
            x += String.format("%-80s%n", "  +-----------------------+-----------------------+------------------------+    ");
            x += String.format("%-3s%-23s%-1s%-23s%-1s%-24s%-5s%n", "  |", subobj("", 22), "|", subobj(data[0][12], 23), "|", subobj(data[0][5], 23), "|    ");
            x += String.format("%-3s%-23s%-1s%-23s%-1s%-24s%-5s%n", "  |", subobj("Stock Keeper", 22), "|", subobj("KA.Mekanik", 22), "|", subobj("Sopir/Mekanik", 23), "|    ");
            x += String.format("%-3s%-23s%-1s%-23s%-1s%-24s%-5s%n", "  |", subobj(F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy"), 22), "|", subobj(F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy"), 22), "|", subobj(F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy"), 23), "|    ");
            x += String.format("%-80s%n", "  +-----------------------+-----------------------+------------------------+    ");
            x += String.format("%-80s%n", "  Di Print Oleh " + F.Variablebanking.SUsername + " Pada " + F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy"));
            x += String.format("%-80s%n", "");
            x += String.format("%-80s%n", "");
            x += String.format("%-80s%n", "");
            System.out.println("START");
            System.out.println(x);
            System.out.println("END");
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Ambil Data");
            e.printStackTrace();
            return null;
        }
    }

    static String subobj(Object x, int l) {
        if (x != null) {
            if (x.toString().length() > l) {
                return x.toString().substring(0, l);
            } else {

                return x.toString();
            }
        } else {
            return "";
        }
    }

    static String subobj(Object x, int k, int l) {
        if (x != null) {
            if (x.toString().length() > l) {
                return x.toString().substring(k, l);
            } else {
                try {
                    return x.toString().substring(k, x.toString().length());
                } catch (Exception e) {
                    return "";
                }
            }
        } else {
            return "";
        }
    }

}
