package be.abis.sos.ui;

import be.abis.sos.enumeration.Language;
import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.model.*;
import be.abis.sos.repository.OrderRepository;
import be.abis.sos.repository.SandwichTypeRepository;
import be.abis.sos.service.SandwichService;
import be.abis.sos.utils.ScannerParser;

import java.time.LocalDate;
import java.util.*;

public class OrderUI {
    public static void main(String[] args) {
        int counter =0;
        OrderRepository repository = new OrderRepository();

        while(true) {
            // 1. Select language
            Scanner scanner = new Scanner(System.in);
            String message = "Please select 1. Add an Orders 2. Update an Orders 3. Remove an Orders 4. View Orders 5. Stop";
            int choice = ScannerParser.readInt(scanner, message, 1, 5);
            switch (choice) {
                case 1 -> {
                    message = "Please provide your name ";
                    String name = ScannerParser.readNonEmptyString(scanner, message);
                    message = "Please provide Sandich name";
                    String sandwich = ScannerParser.readNonEmptyString(scanner, message);

                    Student student1 = new Student(name, "");
                    Session session = new Session(
                            "Java Training",
                            LocalDate.now(),
                            LocalDate.now()
                    );
                    Order order1 = new Order(++counter,
                            student1,
                            session,
                            LocalDate.now(),
                            sandwich
                    );
                    repository.add(order1);

                    System.out.println("Orders added");

                    for (Order order : repository.getOrders()) {
                        System.out.println(order);
                    }
                }
                case 2 -> {
                     message = "Please provide the order number you would like to update";
                     choice = ScannerParser.readInt(scanner, message, 1, 500);
                     message = "Please provide Updated Sandwich name";
                     String sandwich = ScannerParser.readNonEmptyString(scanner, message);

                        Order order1 = new Order(choice,
                                sandwich
                        );
                    repository.update(order1);

                }
                    case 3 -> {
                    message = "Please provide the order number you would like to delete";
                        choice = ScannerParser.readInt(scanner, message, 1, 500);
                        repository.remove(choice);
                    }
                case 4 ->
                {
                    System.out.println("View all orders");
                    for (Order order : repository.getOrders()) {
                        System.out.println(order);
                    }
                }
                default -> throw new IllegalArgumentException("Invalid choice");
            }
            if(choice == 5) {
                break;
}
        } // end while

        //Locale.setDefault(language.getLocale());

        String baseName = "be.abis.sos.translations";
        ResourceBundle bundle = ResourceBundle.getBundle(baseName);

        // 2. Display all sandwiches
        SandwichService ss = new SandwichService();
       // listSandwiches(ss, language, bundle);

        // 3. Select action
//        while (true) {
//            choice = ScannerParser.readInt(scanner, bundle.getString("sandwich.actions"), 1, 5);
//            switch (choice) {
//                case 1: addSandwich(scanner, ss, language, bundle); break;
//                case 2: updateSandwich(scanner, ss, language, bundle); break;
//                case 3: removeSandwich(scanner, ss, language, bundle); break;
//                case 4: listSandwiches(ss, language, bundle); break;
//                case 5: scanner.close();return;
//            }
//        }
    }

    private static void listSandwiches(SandwichService ss, Language language, ResourceBundle bundle) {

        String seperator = "*".repeat(100);
        System.out.println(bundle.getString("sandwich.list"));
        System.out.println(seperator);
        ss.printAllSandwichesByTypeAndPrice(language);
        System.out.println(seperator);
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

        System.out.println("You defined this sandwich : " + sandwich.toString(language));

        if (ScannerParser.readBoolean(scanner, "Do you want to add this sandwich to the list")) {
            ss.addSandwich(sandwich);
        }
    }

    private static void updateSandwich(Scanner scanner, SandwichService ss, Language language, ResourceBundle bundle) {
        int i = ScannerParser.readInt(scanner, bundle.getString("sandwich.select"));
        Sandwich sandwich = ss.findSandwichById(i);
        System.out.println(sandwich.toString(language));
        double price = ScannerParser.readDouble(scanner, "Please enter the new price of the sandwich");
        sandwich.setPrice(price);
    }

    private static void removeSandwich(Scanner scanner, SandwichService ss, Language language, ResourceBundle bundle) {
        int i = ScannerParser.readInt(scanner, bundle.getString("sandwich.select"));
        Sandwich sandwich = ss.findSandwichById(i);
        System.out.println(sandwich.toString(language));
        boolean b =  ScannerParser.readBoolean(scanner, "Are you sure you want to remove this sandwich");
        if (b) {
            ss.removeSandwich(sandwich);
        }

    }

    private static void addOrder()
    {




        //AddOrder();
    }

}