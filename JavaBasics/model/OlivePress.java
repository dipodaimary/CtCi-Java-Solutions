package JavaBasics.model;

import java.util.List;

public class OlivePress implements Press {
    public int getOil(List<Olive> olives) {
        int totalOil = 0;
        for (Olive o : olives) {
            System.out.println(o.name);
            totalOil += o.crush();
        }
        return totalOil;
    }

}
