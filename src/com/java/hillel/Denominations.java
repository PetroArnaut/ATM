package com.java.hillel;

public class Denominations {

    private static int twenties;
    private static int fifties;
    private static int oneHundreds;
    private static int twoHundreads;
    private static double totalMoney;

    Denominations(double totalMoney) {
        this.totalMoney = totalMoney;
        twoHundreads = (int) (totalMoney / 2 / 200);
        totalMoney = totalMoney / 2;
        oneHundreds = (int) (totalMoney / 2 / 100);
        totalMoney = totalMoney / 2;
        fifties = (int) (totalMoney / 2 / 50);
        totalMoney = totalMoney / 2;
        twenties = (int) (totalMoney / 20);

    }

    public static int calculateDenominations(double summ) {
        int countOfDenominations = 0;
        while (summ != 0) {
            if (twoHundreads * 200 > summ) {
                countOfDenominations = (int) (summ / 200);
                twoHundreads = twoHundreads - (int) (summ / 200);
                summ = summ / 200;
            } else {
                countOfDenominations = countOfDenominations + twoHundreads;
                summ = summ - twoHundreads * 200;
                twoHundreads = 0;
            }

            if (oneHundreds * 100 > summ) {
                countOfDenominations = (int) (summ / 100);
                oneHundreds = oneHundreds - (int) (summ / 100);
                summ = summ / 100;
            } else {
                countOfDenominations = countOfDenominations + oneHundreds;
                summ = summ - oneHundreds * 100;
                oneHundreds = 0;
            }

            if (fifties * 50 > summ) {
                countOfDenominations = (int) (summ / 50);
                fifties = fifties - (int) (summ / 50);
                summ = summ / 50;
            } else {
                countOfDenominations = countOfDenominations + fifties;
                summ = summ - fifties * 50;
                fifties = 0;
            }

            if (twenties * 20 > summ) {
                countOfDenominations = (int) (summ / 20);
                twenties = twenties - (int) (summ / 20);
                summ = summ / 20;
            } else {
                countOfDenominations = countOfDenominations + twenties;
                summ = summ - twenties * 20;
                twenties = 0;
            }
        }

        return countOfDenominations;
    }
}