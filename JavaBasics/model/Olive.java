package JavaBasics.model;

public class Olive {
    //public String name = "Kalamata";
    public OliveNames name = OliveNames.KALAMATA;
    public long color = 0x2E0854;
    public int oil = 3;

    public Olive() {
    }

    public Olive(OliveNames name, long color, int oil) {
        this.name = name;
        this.color = color;
        this.oil = oil;
    }

    public OliveNames getName() {
        return name;
    }

    public long getColor() {
        return color;
    }

    public int getOil() {
        return oil;
    }

    public void setName(OliveNames name) {
        this.name = name;
    }

    public void setColor(long color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public int crush() {
        System.out.println("Ouch!!!");
        return oil;
    }
}
