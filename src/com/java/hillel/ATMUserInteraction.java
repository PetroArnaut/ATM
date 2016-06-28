package com.java.hillel;

import java.util.Scanner;

public class ATMUserInteraction {

    private static Scanner scanner = new Scanner(System.in);

    public static String printMenu() {

        System.out.println("select");
        System.out.println("1 - Check balance");
        System.out.println("2 - Get money");
        System.out.println("3 - Mobile payment");
        System.out.println("4 - Print bill");
        return scanner.next();
    }

    public static boolean needToContinue() {
        System.out.println("Continue (y / n)");
        return scanner.next().equals("y");
    }
}