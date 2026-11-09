package be.abis.sos.model;

import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.exception.IngredientNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private String nameDutch;
    private String nameFrench;
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private SandwichType sandwichType;
    private double price;

    public Sandwich(String nameDutch, String nameFrench, SandwichType sandwichType, double price) {
        this.nameDutch = nameDutch;
        this.nameFrench = nameFrench;
        this.sandwichType = sandwichType;
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

}
