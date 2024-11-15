package perezsoto.alejandro.pmdmtarea02;

public class SuperMarioData {

    private final int image;
    private final String namePJ;
    private final String description;
    private final String Abilities;

    public SuperMarioData(int image, String namePJ, String description, String Abilities) {
        this.image = image;
        this.namePJ = namePJ;
        this.description = description;
        this.Abilities = Abilities;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return namePJ;
    }

    public String getDescription() {
        return description;
    }

    public String getAbilities() {
        return Abilities;
    }
}
