package be.abis.sos.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ScannerParser {

    static String baseName = "be.abis.sos.translations";
    static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

    public static int readInt(Scanner scanner, String message) {

        while (true) {
            if (!message.trim().isEmpty()) {
                System.out.println(message);
            }

            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(bundle.getString("number.valid"));
            }
        }
    }

    public static int readInt(Scanner scanner, String message, int min, int max) {

        while (true) {
            if (!message.trim().isEmpty()) {
                System.out.println(message);
            }

            String input = scanner.nextLine().trim();
            try {
                int i =  Integer.parseInt(input);
                if (i >= min && i <= max) {
                    return i;
                }
            } catch (NumberFormatException e) {
                System.out.println(bundle.getString("number.valid"));
            }
        }

    }

    public static String readNonEmptyString(Scanner scanner, String message) {

        while (true) {
            if (!message.trim().isEmpty()) {
                System.out.println(message);
            }

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(bundle.getString("string.empty"));
        }

    }


    public static double readDouble(Scanner scanner, String message) {

        while (true) {
            if (!message.trim().isEmpty()) {
                System.out.println(message);
            }

            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println(bundle.getString("number.valid"));
            }
        }
    }

    public static boolean readBoolean(Scanner scanner, String message) {

        while (true) {
            if (message.contains("?")) {
                message = message.replace("?", "");
            }

            System.out.println(message + " " + bundle.getString("boolean.choices") + "?");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(bundle.getString("boolean.yes"))) return true;
            if (input.equalsIgnoreCase(bundle.getString("boolean.no"))) return false;

            System.out.println(bundle.getString("boolean.valid"));
        }

    }

}
