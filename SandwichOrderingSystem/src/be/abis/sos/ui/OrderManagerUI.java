package be.abis.sos.ui;

import be.abis.sos.enumeration.Language;
import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.model.Ingredient;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichTypeRepository;
import be.abis.sos.service.SandwichService;
import be.abis.sos.utils.ScannerParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagerUI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Select language
        String message = "Please select your language\n1. Dutch\n2. French";
        int choice = ScannerParser.readInt(scanner, message, 1, 2);
        Language language = null;
        switch (choice) {
            case 1: language = Language.LANGUAGE_DUTCH; break;
            case 2: language = Language.LANGUAGE_FRENCH; break;
        }

        // 2. Display all sandwiches
        SandwichService ss = new SandwichService();
        listSandwiches(ss, language);
        // 3. Select action

        message = "What do you want to do\n1. Add a new sandwich\n2. Update the price of a sandwich\n3. Remove a sandwich\n4. List sandwiches\n5. Stop";
        choice = ScannerParser.readInt(scanner, message, 1, 5);
        switch (choice) {
            case 1: addSandwich(scanner, ss, language); break;
            case 2: updateSandwich(scanner, ss, language); break;
            case 3: removeSandwich(scanner, ss, language); break;
            case 4: listSandwiches(ss, language); break;
            case 5: scanner.close(); return;
        }
    }

    private static void listSandwiches(SandwichService ss, Language language) {

        String seperator = "*".repeat(100);
        System.out.println("LIST OF AVAILABLE SANDWICHES");
        System.out.println(seperator);
        ss.printAllSandwichesByTypeAndPrice(language);
        System.out.println(seperator);
    }

    private static void addSandwich(Scanner scanner, SandwichService ss, Language language) {

        SandwichTypeRepository str =  new SandwichTypeRepository();
        System.out.println("Which type of sandwich do you want to add?");
        str.printSandwichTypes(language);
        int id = ScannerParser.readInt(scanner,"", 1, str.getSandwichTypes().size());
        SandwichType sandwichType = str.findSandwichType(id);

        String nameDutch = ScannerParser.readNonEmptyString(scanner, "Please enter the dutch name of the sandwich");
        String nameFrench = ScannerParser.readNonEmptyString(scanner, "Please enter the dutch name of the sandwich");

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        if (ScannerParser.readBoolean(scanner, "Do you want to add ingredients")) {
            boolean addMoreIngredients = true;
            while (addMoreIngredients) {
                String ingredientDutch = ScannerParser.readNonEmptyString(scanner, "Please enter the dutch name of the ingredient");
                String ingredientFrench = ScannerParser.readNonEmptyString(scanner, "Please enter the french name of the ingredient");
                ingredients.add(new Ingredient(ingredientDutch, ingredientFrench));
                addMoreIngredients = ScannerParser.readBoolean(scanner, "Do you want to add more ingredients");
            }
        }

        double price = ScannerParser.readDouble(scanner, "Please enter the price of the sandwich");

        Sandwich sandwich;
        if (ingredients.size() == 0) {
            sandwich = new Sandwich(nameDutch, nameFrench, sandwichType, price  );
        } else {
            sandwich = new Sandwich(nameDutch, nameFrench,  ingredients, sandwichType, price  );
        }

        System.out.println("You defined this sandwich : " + sandwich.toString(language));

        if (ScannerParser.readBoolean(scanner, "Do you want to add this sandwich to the list")) {
            ss.addSandwich(sandwich);
        }
    }

    private static void updateSandwich(Scanner scanner, SandwichService ss, Language language) {
        int i = ScannerParser.readInt(scanner, "Please enter the number of the sandwich");
        Sandwich sandwich = ss.findSandwichById(i);
        System.out.println(sandwich.toString(language));
        double price = ScannerParser.readDouble(scanner, "Please enter the new price of the sandwich");
        sandwich.setPrice(price);
    }

    private static void removeSandwich(Scanner scanner, SandwichService ss, Language language) {
        int i = ScannerParser.readInt(scanner, "Please enter the number of the sandwich");
        Sandwich sandwich = ss.findSandwichById(i);

        boolean b =  ScannerParser.readBoolean(scanner, "Are you sure you want to remove this sandwich");
        if (b) {
            ss.removeSandwich(sandwich);
        }
    }
}