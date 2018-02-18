package JavaBasics.model;

public class Olive {
    public String name = "Kalamata";
    public long color = 0x2E0854;
    public int oil = 3;

    public Olive() {
    }

    public Olive(String name, long color, int oil) {
        this.name = name;
        this.color = color;
        this.oil = oil;
    }

    public String getName() {
        return name;
    }

    public long getColor() {
        return color;
    }

    public int getOil() {
        return oil;
    }

    public void setName(String name) {
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
