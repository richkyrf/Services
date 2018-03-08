/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import Koneksi.MysqlCon;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRExporterParameter;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import static net.sf.jasperreports.engine.util.JRLoader.loadObject;

/**
 *
 * @author JACK
 */
public class FLaporan2 {

    HashMap hashs = new HashMap();
    String Filename;
    String Erorm;
    String outputFileName = "D:/Test/p.txt";

    public void sethashmap(HashMap h) {
        hashs = h;
    }

    public void setfilename(String F) {
        Filename = F;
    }

    public void setErorm(String E) {
        Erorm = E;
    }

    public void excute() {
        MysqlCon koneksi = new MysqlCon();
        Connection con = koneksi.getConnection();
        try {
            InputStream files = new FileInputStream("D:/Test/p.jasper");
            JasperReport jasperReport;
            jasperReport = (JasperReport) loadObject(files);
            JasperPrint jasperPrint = fillReport(jasperReport, hashs, con);
            JRTextExporter exporter = new JRTextExporter();
            exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
            exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outputFileName);
            exporter.exportReport();
            String everything;
            BufferedReader br = new BufferedReader(new FileReader("D:/Test/p.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                everything = sb.toString();
            } finally {
                br.close();
            }
            //////system.out.printlnln(everything);
            directPrint.DirectPrint.directprinting(everything);
            //viewReport(jasperPrint, false);
        } catch (Exception ex) {
            out.println("E5" + ex);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                out.println("conclose Lpermintaan Service" + e);
            }
        }
    }
}
