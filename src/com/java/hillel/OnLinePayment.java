package com.java.hillel;

import java.util.Scanner;

public class OnLinePayment implements Operation{

    private static Scanner scanner = new Scanner(System.in);

    public void operation(Card currentCard) {
        System.out.println("enter amount");
        int temp = scanner.nextInt();
        if (temp < currentCard.getAmount()) {
            System.out.println("Payment is OK");
            currentCard.setAmount(currentCard.getAmount() - temp);
        } else {
            System.out.println("It is not enough money in your card");
        }
    }
}