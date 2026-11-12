package be.abis.sos.ui;

import be.abis.sos.enumeration.Language;
import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.model.Ingredient;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichTypeRepository;
import be.abis.sos.service.SandwichService;
import be.abis.sos.utils.ScannerParser;

import java.util.*;

public class OrderManagerUI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Select language
        String message = "Please select your language\n1. Dutch\n2. French";
        int choice = ScannerParser.readInt(scanner, message, 1, 2);
        Language language = switch (choice) {
            case 1 -> Language.LANGUAGE_DUTCH;
            case 2 -> Language.LANGUAGE_FRENCH;
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        Locale.setDefault(language.getLocale());

        String baseName = "be.abis.sos.translations";
        ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        ScannerParser.setLanguage(language);

        // 2. Display all sandwiches
        SandwichService ss = new SandwichService();
        listSandwiches(ss, language);

        // 3. Select action
        while (true) {
            choice = ScannerParser.readInt(scanner, bundle.getString("sandwich.actions"), 1, 5);
            switch (choice) {
                case 1: addSandwich(scanner, ss, language, bundle); break;
                case 2: updateSandwich(scanner, ss, language, bundle); break;
                case 3: removeSandwich(scanner, ss, language, bundle); break;
                case 4: listSandwiches(ss, language); break;
                case 5: saveSandwiches(ss); scanner.close(); return;
            }
        }
    }

    private static void listSandwiches(SandwichService ss, Language language) {

        ss.printAllSandwichesByTypeAndPrice(language);

    }

    private static void saveSandwiches(SandwichService ss) {
        ss.saveSandwiches();
    }

    private static void addSandwich(Scanner scanner, SandwichService ss, Language language, ResourceBundle bundle) {

        SandwichTypeRepository str =  new SandwichTypeRepository();
        System.out.println(bundle.getString("sandwich.add.type"));
        str.printSandwichTypes(language);
        int id = ScannerParser.readInt(scanner,"", 1, str.getSandwichTypes().size());
        SandwichType sandwichType = str.findSandwichType(id);

        String nameDutch = ScannerParser.readNonEmptyString(scanner, bundle.getString("sandwich.add.namenl"));
        String nameFrench = ScannerParser.readNonEmptyString(scanner, bundle.getString("sandwich.add.namefr"));

        List<Ingredient> ingredients = new ArrayList<>();
        if (ScannerParser.readBoolean(scanner, bundle.getString("sandwich.add.ingredients"))) {
            boolean addMoreIngredients = true;
            while (addMoreIngredients) {
                String ingredientDutch = ScannerParser.readNonEmptyString(scanner, bundle.getString("ingredient.add.namenl"));
                String ingredientFrench = ScannerParser.readNonEmptyString(scanner, bundle.getString("ingredient.add.namefr"));
                ingredients.add(new Ingredient(ingredientDutch, ingredientFrench));
                addMoreIngredients = ScannerParser.readBoolean(scanner, bundle.getString("ingredient.add.another"));
            }
        }

        double price = ScannerParser.readDouble(scanner, bundle.getString("sandwich.add.price"));

        Sandwich sandwich;
        if (ingredients.isEmpty()) {
            sandwich = new Sandwich(nameDutch, nameFrench, sandwichType, price  );
        } else {
            sandwich = new Sandwich(nameDutch, nameFrench,  ingredients, sandwichType, price  );
        }

        System.out.println( bundle.getString("sandwich.add.summary") + "\n" + sandwich.toString(language));

        if (ScannerParser.readBoolean(scanner, bundle.getString("sandwich.add.list"))) {
            ss.addSandwich(sandwich);
        }
    }

    private static void updateSandwich(Scanner scanner, SandwichService ss, Language language, ResourceBundle bundle) {
        int i = ScannerParser.readInt(scanner, bundle.getString("sandwich.select"));
        Sandwich sandwich = ss.findSandwichById(i);
        System.out.println( bundle.getString("sandwich.selected") + "\n" + sandwich.toString(language));
        double price = ScannerParser.readDouble(scanner, bundle.getString("sandwich.update.price"));
        sandwich.setPrice(price);
    }

    private static void removeSandwich(Scanner scanner, SandwichService ss, Language language, ResourceBundle bundle) {
        int i = ScannerParser.readInt(scanner, bundle.getString("sandwich.select"));
        Sandwich sandwich = ss.findSandwichById(i);
        System.out.println( bundle.getString("sandwich.selected") + "\n" + sandwich.toString(language));
        boolean b =  ScannerParser.readBoolean(scanner, bundle.getString("sandwich.remove.confirm"));
        if (b) {
            ss.removeSandwich(sandwich);
        }
    }
}