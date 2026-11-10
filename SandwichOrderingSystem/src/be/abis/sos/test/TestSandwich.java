package be.abis.sos.test;

import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.model.Ingredient;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichRepository;

import java.io.IOException;

public class TestSandwich {
    public static void main(String[] args) {

        Ingredient i1 = new Ingredient("Ei", "Oeuf");
        Ingredient i2 = new Ingredient("Kaas", "Fromage");
        Sandwich s1 = new Sandwich("Sandwich 1 NL", "Sandwich 1 FR", SandwichType.SANDWICH_TYPE_FISH, 5.0);
        Sandwich s2 = new Sandwich("Sandwich 2 NL", "Sandwich 2 FR", SandwichType.SANDWICH_TYPE_MEAT, 5.5);

        s1.addIngredient(i1);
        s2.addIngredients(i1,i2);

        SandwichRepository sr = new SandwichRepository();
        try {
            sr.readSandwiches();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
