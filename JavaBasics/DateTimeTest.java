package JavaBasics;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeTest {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        GregorianCalendar gc = new GregorianCalendar(2009, 1, 28);//0 january, 1 february etc
        gc.add(GregorianCalendar.DATE, 4);
        Date d2 = gc.getTime();
        System.out.println(d2);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(d2));

        //from java 8
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDate ld = LocalDate.of(2009, 1, 28);//new api month number goes from 1 to 12
        System.out.println(ld);

        //DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        System.out.println(dtf.format(ld));
    }
}
