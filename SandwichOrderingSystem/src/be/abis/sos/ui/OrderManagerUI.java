package be.abis.sos.ui;

import be.abis.sos.enumeration.Language;
import be.abis.sos.service.SandwichService;

import java.util.Scanner;

public class OrderManagerUI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Select language
        System.out.println("Please select your language\n1. Dutch\n2. French");
        int choice = Integer.parseInt(scanner.nextLine());
        Language language;
        switch (choice) {
            case 1: language = Language.LANGUAGE_DUTCH; break;
            case 2: language = Language.LANGUAGE_FRENCH; break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        // 2. Display all sandwiches
        SandwichService ss = new SandwichService();
        ss.printAllSandwichesByTypeAndPrice(language);

        // 3. Select action

        System.out.println("What do you want to do\n1. Add a new sandwich\n2. Update a sandwich\n3. Remove a sandwich");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: addSandwich(scanner); break;
            case 2: updateSandwich(scanner); break;
            case 3: removeSandwich(scanner); break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }
    }

    private static void addSandwich(Scanner scanner) {
        System.out.println("Please enter the name of the sandwich");
        String name = scanner.nextLine();
    }

    private static void updateSandwich(Scanner scanner) {
        System.out.println("Please enter the name of the sandwich to update");
        String name = scanner.nextLine();
    }

    private static void removeSandwich(Scanner scanner) {
        System.out.println("Please enter the name of the sandwich to remove");
        String name = scanner.nextLine();
    }
}