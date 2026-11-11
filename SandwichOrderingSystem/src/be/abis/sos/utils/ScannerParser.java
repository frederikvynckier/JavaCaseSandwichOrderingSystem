package be.abis.sos.utils;

import java.util.Scanner;

public class ScannerParser {

    public static int readInt(Scanner scanner, String message) {

        while (true) {
            if (!message.trim().isEmpty()) {
                System.out.println(message);
            }

            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
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
                System.out.println("Please enter a valid number");
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

            System.out.println("Value cannot be empty.");
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
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static boolean readBoolean(Scanner scanner, String message) {

        while (true) {
            if (message.contains("?")) {
                message = message.replace("?", "");
            }

            System.out.println(message + " (Y/N)?");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("y")) return true;
            if (input.equalsIgnoreCase("n")) return false;

            System.out.println("Please only use Y/N");
        }

    }

}
