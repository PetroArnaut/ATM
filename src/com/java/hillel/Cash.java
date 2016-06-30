package com.java.hillel;

import java.util.Scanner;

public class Cash implements Operation {

    private static final double COMMISSION = 1.5;

    public void operation(Card card) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter amount");
        int temp = scanner.nextInt();
        if (temp + getCommission(temp, card) < card.getAmount()) {
            int summByDenominations = Denominations.calculateSummByDenominations(temp);
            if (summByDenominations != temp) {
                System.out.println("I can take only " + summByDenominations);
                System.out.println("continue (y / n)");
                if(scanner.next().equals("y"))
                    getCash(summByDenominations, card);
            } else {
                getCash(temp, card);
            }
        } else {
            System.out.println("It is not enough money in your card");
        }
    }

    private void getCash(int summ, Card card) {
        System.out.println("Comission on your card is " + getCommission(summ, card));
        System.out.println("Pls take your money");
        card.setAmount(card.getAmount() - summ - getCommission(summ, card));
    }

    private double getCommission(double summ, Card card) {
        if (card.getType().equals(CardType.MAESTRO))
            return 0;
        return summ * COMMISSION / 100;
    }
}