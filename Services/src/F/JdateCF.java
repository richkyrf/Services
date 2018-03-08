package F;

import static F.Datetostringwidthformat.getstringfromdate;
import com.toedter.calendar.JDateChooser;

public class JdateCF extends JDateChooser {

    public JdateCF() {
        this.setFont(new java.awt.Font("Tahoma", 0, 18));
        this.setDateFormatString("dd/MM/yyyy");
    }
    public String GetString(){
        return  getstringfromdate(this.getDate(),"dd/mm/yyyy");
    }

}
