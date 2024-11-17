package perezsoto.alejandro.pmdmtarea02;

public class Item {
    private String name;
    private int image;
    private String description;
    private String abilities;

    public Item(String name, int image, String description, String abilities) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.abilities = abilities;
    }
    // Getters para los atributos privados

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getAbilities() {
        return abilities;
    }
}
