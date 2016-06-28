package com.java.hillel;

import java.util.Scanner;

public class Cash implements Operation {

    private static final double COMMISSION = 1.5;

    public void operation(Card card) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter amount");
        int temp = scanner.nextInt();
        if (temp + getCommission(temp, card) < card.getAmount()) {
            if (Denominations.calculateSummByDenominations(temp) != temp)
                System.out.println("I cant give you this summ");
            else {
                System.out.println("Coomission on your card is " + getCommission(temp, card));
                System.out.println("Pls take your money");
                //System.out.println(Denominations.calculateSummByDenominations(temp) + " notes");
                card.setAmount(card.getAmount() - temp - getCommission(temp, card));
            }
        } else {
            System.out.println("It is not enough money in your card");
        }
    }

    private double getCommission(double summ, Card card) {
        if (card.getType().equals(CardType.MAESTRO))
            return 0;
        return summ * COMMISSION / 100;
    }
}