package JavaBasics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Boy");
        list.add("Cat");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.print(value + ", ");
        }
        for (String value : list) {
            System.out.print(value + ", ");
        }
        //java8 method references
        list.forEach(System.out::println);
        System.out.println("");
        //Set<String> = map.getKeys();
        //Iterator<String> iterator = keys.iterator();
        //while

    }
}
