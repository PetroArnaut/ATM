package com.java.hillel;


import java.util.GregorianCalendar;
import java.util.Scanner;

public class Security {


    public static boolean checkPinCode(Card currentCard) {
        Scanner scanner = new Scanner(System.in);
        int temp = 0;
        while (temp < 3) {
                System.out.println("input pin code (4 digits)");
                String pinCode = scanner.next();
                temp++;
                if (pinCode.equals(currentCard.getPinCode()))
                    return true;
            }
        return false;
    }

    public static boolean checkDate(Card currentCard) {
        return (currentCard.getDate().before(new GregorianCalendar()));
    }

    public static void blockCard() {
        System.out.println("Your card is blocked");
    }
}