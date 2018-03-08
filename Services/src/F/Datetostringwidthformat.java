package F;

import static java.lang.System.out;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.util.Locale.ENGLISH;

public class Datetostringwidthformat {

    private static String Tanggal;

    public static String getstringfromdate(Date tanggal, String SFromatTanggal) {
        try {
            SimpleDateFormat formattanggal = new SimpleDateFormat(SFromatTanggal);
            Tanggal = formattanggal.format(tanggal);
        } catch (Exception e) {
            out.println("E1" + e);
        }
        return Tanggal;
    }

    public static Date getdatefromstring(String tgl, String FormatTanggal) {
        Date date = null;
        try {
            DateFormat format = new SimpleDateFormat(FormatTanggal, ENGLISH);
            date = format.parse(tgl);
        } catch (Exception e) {
            out.println("E2" + e);
        }
        return date;
    }

    private Datetostringwidthformat() {
    }
}
