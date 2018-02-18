package JavaBasics;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class FormatNumbers {
    public static void main(String[] args) {
        Locale locale = new Locale("da", "DK");
        double doubleValue = 1_234_567.89;
        NumberFormat numF = NumberFormat.getNumberInstance();
        System.out.println(numF.format(doubleValue));
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        System.out.println(numberFormat.format(doubleValue));
        NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance();
        System.out.println(numberFormat1.format(doubleValue));
    }
}
