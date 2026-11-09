package be.abis.sos.model;

public class Ingredient {

    private String nameDutch;
    private String nameFrench;

    public Ingredient(String nameDutch, String nameFrench) {
        this.nameDutch = nameDutch;
        this.nameFrench = nameFrench;
    }

    public String getNameFrench() {
        return nameFrench;
    }

    public String getNameDutch() {
        return nameDutch;
    }
}
