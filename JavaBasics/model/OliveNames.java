package JavaBasics.model;

public enum OliveNames {
    KALAMATA("Kalamata"), LIGURIAN("Ligurian");
    private String name;

    OliveNames(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
