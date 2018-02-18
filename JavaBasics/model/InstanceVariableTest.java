package JavaBasics.model;

import java.util.ArrayList;
import java.util.List;

public class InstanceVariableTest {
    public static void main(String[] args) {
        List<Olive> olives = new ArrayList<>();
        Olive olive1 = new Olive();
        olives.add(olive1);
        Olive olive2 = new Olive();
        olive2.setOil(1);
        olives.add(olive2);
        Olive olive3 = new Olive();
        olive3.setOil(4);
        olives.add(olive3);
        OlivePress press = new OlivePress();
        //press.getOil(olives);
        int totalOil = press.getOil(olives);
        System.out.println("Total oil: " + totalOil);

        // use of constructors;
        List<Olive> olives2 = new ArrayList<>();
//        Olive olive_a = new Olive("Kalamata", 0x2E0854, 3);
//        Olive olive_b = new Olive("Ligurian", 0x000000, 2);
//        Olive olive_c = new Olive("Kalamata", 0x2E0854, 3);
        olives2.add(new Olive(OliveNames.KALAMATA, 0x2E0854, 3));
        olives2.add(new Olive(OliveNames.LIGURIAN, 0x000000, 2));
        OlivePress press2 = new OlivePress();
        System.out.println(press2.getOil(olives2));
    }
}
