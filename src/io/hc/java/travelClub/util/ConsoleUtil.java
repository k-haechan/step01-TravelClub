package io.hc.java.travelClub.util;

import java.util.Scanner;

public class ConsoleUtil {
    private Scanner scanner;

    public ConsoleUtil() {
        this.scanner = new Scanner(System.in);
    }

    public String getValueOf(String label) {
        System.out.print(label + " : ");
        return scanner.nextLine().trim();
    }
}