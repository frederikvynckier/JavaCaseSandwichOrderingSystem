package be.abis.sos.utils;

import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.exception.SandwichParseException;
import be.abis.sos.model.Ingredient;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichTypeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SandwichParser {

    public static Sandwich parse(String s) {

        SandwichTypeRepository str = new SandwichTypeRepository();

        Sandwich sandwich = null;


        String[] fields = s.split(";");
        if (fields.length != 4) {
            throw new SandwichParseException("Wrong number of fields : " + fields.length + " instead of 4");
        }

        SandwichType st;
        try {
            int id = Integer.parseInt(fields[0]);
            st = str.findSandwichType(id);
        } catch (Exception e) {
            throw new SandwichParseException("Wrong sandwich type : " + fields[0]);
        }

        String nameDutch = parseSandwichName(fields[1].trim());
        String nameFrench = parseSandwichName(fields[2].trim());

        List<String> ingredientsDutch = parseIngredients(fields[1].trim());
        List<String> ingredientsFrench = parseIngredients(fields[2].trim());

        if (ingredientsDutch.size() != ingredientsFrench.size()) {
            throw new SandwichParseException("Number of ingredients in Dutch and French don't match");
        }

        List<Ingredient> ingredients = new ArrayList<>();

        for (int i = 0; i < ingredientsDutch.size(); i++) {

            Ingredient ingredient = new Ingredient(ingredientsDutch.get(i), ingredientsFrench.get(i));
            ingredients.add(ingredient);
        }

        double price;
        try {
            price = Double.parseDouble(fields[3]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        sandwich = new Sandwich(nameDutch, nameFrench, ingredients, st, price);

        return sandwich;
    }


    private static List<String> parseIngredients(String s) {

        List<String> ingredients = new ArrayList<>();

        int start = s.indexOf("(");
        int end = s.indexOf(")");
        if (start > 0 && end > start) {
            String ingredientString = s.substring(start + 1, end);
            ingredients = Arrays.stream(ingredientString.split(",")).map(String::trim).toList();
        } else if ((start > 0 && end == -1) || (start == -1 && end > 0)) {
            throw new SandwichParseException("Ingredients should be between brackets");
        }

        return ingredients;
    }

    private static String parseSandwichName(String s) {

        int start = s.indexOf("(");
        if (start < 0){
            return s.trim();
        }
        return s.substring(0,start).trim();

    }

}
