package F;

import java.util.Date;

public class History {

    public static void STambah(String Activity) {
        Date Sekarang = new Date();
        String Now = F.Datetostringwidthformat.getstringfromdate(Sekarang, "yyyy-MM-dd");
        RunUpd runUpd = new F.RunUpd();
        runUpd.setQuery("INSERT INTO `tuserhistory`(`User`, `UserActivity`, `DateOfActivity`) VALUES ('" + F.Variablebanking.SUsername + "','" + Activity + "','" + Now + "')");
        runUpd.excute();
    }
}
