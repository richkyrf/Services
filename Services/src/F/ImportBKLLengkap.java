package F;

import static F.Jfilechoiser.ReadFile;
import Koneksi.MysqlCon;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ImportBKLLengkap {

    public static void runimportbkl() {
        Thread thread = new TImportBKL();
        thread.start();
    }

    static void LoadData(HSSFSheet sheet, Connection con, String SQL) {
        PreparedStatement pstm;
        int rowNum = sheet.getLastRowNum() + 1;
        int colNum = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNum][colNum];
        try {
            for (int i = 1; i < rowNum; i++) {
                pstm = con.prepareStatement(SQL);
                HSSFRow row = sheet.getRow(i);
                ////////system.out.printlnln("B" + i);
                for (int j = 0; j < colNum; j++) {
                    ////////system.out.printlnln("C" + j);
                    HSSFCell cell = row.getCell(j);
                    String value = cell.toString();
                    data[i][j] = value;
                    ////////system.out.printlnln("[" + i + "]" + " " + "[" + j + "]" + value);
                    pstm.setString(j + 1, value);
                }
                try {
                    //////system.out.printlnln(pstm);
                    pstm.executeUpdate();
                } catch (SQLException e) {
                    out.println("E14" + e);
                    if (e.getErrorCode() != 1292 || e.getErrorCode() != 1062) {
                        out.println(e.getErrorCode());
                    }
                }
            }
        } catch (SQLException e) {
            out.println("E15" + e);
        }
    }

    static class TImportBKL extends Thread {

        @Override
        public synchronized void run() {
            try {
                Connection con = null;
                String FileLocation = ReadFile("Database", "DB");
                FileInputStream input = new FileInputStream(FileLocation);
                if (FileLocation != null) {
                    try {
                        MysqlCon koneksi = new MysqlCon();
                        con = koneksi.getConnection();
                        con.setAutoCommit(false);
                        POIFSFileSystem fs = new POIFSFileSystem(input);
                        HSSFWorkbook wb = new HSSFWorkbook(fs);
                        HSSFSheet sheet0 = wb.getSheetAt(0);
                        HSSFSheet sheet1 = wb.getSheetAt(1);
                        HSSFSheet sheet2 = wb.getSheetAt(2);
                        //HSSFSheet sheet3 = wb.getSheetAt(3);
                        String Sqlq0;
                        String Sqlq1;
                        String Sqlq2;
                        Sqlq0 = "INSERT INTO `tpks`(`AliasPKS`, `NamaPKS`, `AlamatPKS`) VALUES (?,?,?)";
                        Sqlq1 = "INSERT INTO `ttruck`(`NoPolisi`,`TypeTruck`) VALUES (?,?)";
                        Sqlq2 = "INSERT INTO `tdistribusidanrealisasido`(`NoKDRDO`, `AliasPKS`, `NoPolisi`, `TglDOKeluar`, `TglDOMasuk`, `Jarak`) VALUES (?,?,?,?,?,?)";
                        LoadData(sheet0, con, Sqlq0);
                        LoadData(sheet1, con, Sqlq1);
                        LoadData(sheet2, con, Sqlq2);
                        con.commit();
                        showMessageDialog(null, "Berhasil Import Kilometer ");
                    } catch (SQLException | IOException | HeadlessException e) {
                        try {
                            out.println("E" + e);
                            con.rollback();
                        } catch (Exception ee) {
                            out.println("E12" + e);
                            showMessageDialog(null, "Eror Gagal Import Kilometer");
                        } finally {
                            try {
                                con.close();
                            } catch (Exception ex) {
                                out.println("E13" + e);
                            }
                        }
                        showMessageDialog(null, "Gagal Import Kilometer");
                    }
                } else {
                    showMessageDialog(null, "Batal Import Kilometer");
                }
            } catch (FileNotFoundException | HeadlessException e) {
                showMessageDialog(null, "file Tidak Di Temukan");
            } catch (NullPointerException ee) {
                //////system.out.printlnln("Null E11");
            }
        }
    }
}
