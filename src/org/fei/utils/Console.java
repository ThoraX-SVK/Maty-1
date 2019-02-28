package org.fei.utils;

import java.util.Scanner;

public class Console {

    public static int readInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);

        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Zadaný vstup nie je číslo! Ukončujem program...");
            System.exit(0);
        }

        return 0;
    }

}
