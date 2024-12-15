package perezsoto.alejandro.pmdmtarea02;

/**
 * La clase Item representa un elemento de la lista que contiene información sobre un personaje o entidad.
 * Cada elemento Item incluye un nombre, una imagen, una descripción y sus habilidades.
 */
public class Item {

    private String name;
    private int image;
    private String description;
    private String abilities;

    /**
     * Constructor de la clase Item.
     *
     * @param name El nombre del elemento.
     * @param image El recurso de imagen asociado al elemento.
     * @param description La descripción del elemento.
     * @param abilities Las habilidades o características del elemento.
     */
    public Item(String name, int image, String description, String abilities) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.abilities = abilities;
    }

    /**
     * Obtiene el nombre del elemento.
     *
     * @return El nombre del elemento.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el recurso de imagen asociado al elemento.
     *
     * @return El recurso de imagen del elemento.
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene la descripción del elemento.
     *
     * @return La descripción del elemento.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene las habilidades o características del elemento.
     *
     * @return Las habilidades del elemento.
     */
    public String getAbilities() {
        return abilities;
    }
}
