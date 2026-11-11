package be.abis.sos.utils;

import java.text.DecimalFormat;

public class NumberUtils {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatNumber(double d) {
        return df.format(d);
    }
}
