package JavaBasics;

import java.text.NumberFormat;

public class ConvertingPrimitiveValues {
    public static void main(String[] args) {
        long longValue = 10_000_000;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        String formatted = formatter.format(longValue);
        System.out.println(formatted);
        System.out.println(Long.toString(longValue));
    }
}
