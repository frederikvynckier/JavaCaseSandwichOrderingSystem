package be.abis.sos.enumeration;

import be.abis.sos.model.Sandwich;

public enum SandwichType implements Comparable<SandwichType>{

    SANDWICH_TYPE_MEAT (1,"Vlees", "Viande", true),
    SANDWICH_TYPE_CHEESE (2, "Kaas", "Fromage", true),
    SANDWICH_TYPE_FISH (3, "Vis", "Poisson", true),
    SANDWICH_TYPE_SPECIAL (4, "Specials", "Spéciales", false),
    SANDWICH_TYPE_VEGE (5, "Vegetarische specials", "Spéciales végétariens", false);

    private final int id;
    private final String nameDutch;
    private final String nameFrench;
    private final boolean vegetablesPossible;

    SandwichType(int id, String nameDutch, String nameFrench, boolean vegetablesPossible) {
        this.id = id;
        this.nameDutch = nameDutch;
        this.nameFrench = nameFrench;
        this.vegetablesPossible = vegetablesPossible;
    }

    public int getId() {
        return id;
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
