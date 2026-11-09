package be.abis.sos.enumeration;

public enum SandwichType {

    SANDWICH_TYPE_MEAT ("Vlees", "Viande", true),
    SANDWICH_TYPE_CHEESE ("Kaas", "Fromage", true),
    SANDWICH_TYPE_FISH ("Vis", "Poisson", true),
    SANDWICH_TYPE_SPECIAL ("Specials", "Spéciales", false),
    SANDWICH_TYPE_VEGE ("Vegetarische specials", "Spéciales végétariens", false);

    private String nameDutch;
    private String nameFrench;
    private boolean vegetablesPossible;

    SandwichType(String nameDutch, String nameFrench, boolean vegetablesPossible) {
        this.nameDutch = nameDutch;
        this.nameFrench = nameFrench;
        this.vegetablesPossible = vegetablesPossible;
    }

    public String getNameDutch() {
        return nameDutch;
    }

    public String getNameFrench() {
        return nameFrench;
    }

    public boolean isVegetablesPossible() {
        return vegetablesPossible;
    }
}
