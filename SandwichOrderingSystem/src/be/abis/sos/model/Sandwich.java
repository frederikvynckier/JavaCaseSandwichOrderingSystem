package be.abis.sos.model;

import be.abis.sos.enumeration.Language;
import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.exception.IngredientNotFoundException;
import be.abis.sos.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich {

    private String nameDutch;
    private String nameFrench;
    private List<Ingredient> ingredients = new ArrayList<>();
    private SandwichType sandwichType;
    private double price;

    public Sandwich(String nameDutch, String nameFrench, SandwichType sandwichType, double price) {
        this.nameDutch = nameDutch;
        this.nameFrench = nameFrench;
        this.sandwichType = sandwichType;
        this.price = price;
    }

    public Sandwich(String nameDutch, String nameFrench, List<Ingredient> ingredients, SandwichType sandwichType, double price) {
        this.nameDutch = nameDutch;
        this.nameFrench = nameFrench;
        this.ingredients = ingredients;
        this.sandwichType = sandwichType;
        this.price = price;
    }

    public String getNameDutch() {
        return nameDutch;
    }

    public void setNameDutch(String nameDutch) {
        this.nameDutch = nameDutch;
    }

    public String getNameFrench() {
        return nameFrench;
    }

    public void setNameFrench(String nameFrench) {
        this.nameFrench = nameFrench;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public SandwichType getSandwichType() {
        return sandwichType;
    }

    public void setSandwichType(SandwichType sandwichType) {
        this.sandwichType = sandwichType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) throws IngredientNotFoundException {
        try {
            ingredients.remove(ingredient);
        } catch (Exception e) {
            throw new IngredientNotFoundException("Ingredient not found");
        }
    }

    public void addIngredients(Ingredient...ingredients) {
        for (Ingredient ingredient : ingredients) {
            addIngredient(ingredient);
        }
    }

    public void removeIngredients() {
        ingredients.clear();
    }


    public String toString(Language language) {

        String name = "";
        String ingredientsList = "";

        switch (language) {
            case LANGUAGE_DUTCH:
                name = nameDutch;
                if (!ingredients.isEmpty()) {
                    ingredientsList = ingredients.stream().map(Ingredient::getNameDutch).collect(Collectors.joining(","));
                    name += " (" + ingredientsList + ")";
                }
                break;
            case LANGUAGE_FRENCH:
                name = nameFrench;
                if (!ingredients.isEmpty()) {
                    ingredientsList = ingredients.stream().map(Ingredient::getNameFrench).collect(Collectors.joining(","));
                    name += " (" + ingredientsList + ")";
                }
                break;
            default:
                return "Language not supported";
        }

        return name;

    }

    public String toFileString() {

        String stringDutch = nameDutch;
        String stringFrench = nameFrench;

        if (!ingredients.isEmpty()) {

            String ingredientsDutch = ingredients.stream().map(Ingredient::getNameDutch).collect(Collectors.joining(","));
            String ingredientsFrench = ingredients.stream().map(Ingredient::getNameFrench).collect(Collectors.joining(","));

            stringDutch += " (" + ingredientsDutch + ")";
            stringFrench += " (" + ingredientsFrench + ")";
        }

        return String.valueOf(sandwichType.getId()) + ";" + stringDutch + ";" + stringFrench + ";" + NumberUtils.formatNumber(price);
    }

}
