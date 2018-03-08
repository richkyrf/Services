package F;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.SwingConstants;

public class NumberRenderer extends FormatRenderer {


    /*
     *  Use the default currency formatter for the default locale
     */
    public static NumberRenderer getCurrencyRenderer() {
        return new NumberRenderer(NumberFormat.getCurrencyInstance());
    }

    /*
     *  Use the default integer formatter for the default locale
     */
    public static NumberRenderer getIntegerRenderer() {
        return new NumberRenderer(NumberFormat.getIntegerInstance());
    }

    /*
     *  Use the default percent formatter for the default locale
     */
    public static NumberRenderer getPercentRenderer() {
        return new NumberRenderer(NumberFormat.getPercentInstance());
    }

    public static NumberRenderer getumberrender() {
        DecimalFormat df = new DecimalFormat("#,###,###,###");
        return new NumberRenderer(df);
    }

    /*
    *  Use the specified number formatter and right align the text
     */
    public NumberRenderer(NumberFormat formatter) {
        super(formatter);
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
