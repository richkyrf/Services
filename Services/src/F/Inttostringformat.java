package F;

import static java.lang.Math.abs;
import java.text.DecimalFormat;
import java.text.ParseException;

public class Inttostringformat {

    public static String Intformatdigit(int Number) {
        int value = 0;
        value = Number;
        String output;
        if (value < 0) {
            value = abs(value);
            String pattern = "#,###,###";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = "(" + myFormatter.format(value) + ")";
        } else {
            String pattern = "#,###,###";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            output = myFormatter.format(value);
        }
        return output;
    }

    public static int StringformatInt(String numbers) throws ParseException {
        DecimalFormat df = new DecimalFormat("#,###,###");
        int i = df.parse(numbers).intValue();
        return i;
    }

    public Inttostringformat() {
        Intformatdigit(5000000);
    }
}
