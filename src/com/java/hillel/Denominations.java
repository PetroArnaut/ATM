package com.java.hillel;

public class Denominations {

    private static int tens;
    private static int twenties;
    private static int fifties;
    private static int twoHundreads;
    private static double totalMoney;
    private static final int MAX_DENOMINATIONS = 50;

    Denominations(double totalMoney) {
        this.totalMoney = totalMoney;
        twoHundreads = (int) (totalMoney / 2 / 200);
        totalMoney = totalMoney / 2;
        fifties = (int) (totalMoney / 5 * 4 / 50);
        totalMoney = totalMoney / 5;
        twenties = (int) (totalMoney / 2 / 20);
        totalMoney = totalMoney / 2;
        tens = (int) (totalMoney / 10);
    }

    public static int calculateSummByDenominations(int summ) {
        int countOfDenominations = 0;
        int totalSumm = 0;
        while (countOfDenominations <= MAX_DENOMINATIONS && summ > 9) {

            if ((summ - 200) >= 0) {
                totalSumm += 200;
                countOfDenominations++;
                twoHundreads--;
                summ -= 200;
                continue;
            }
            if ((summ - 50) >= 0 && fifties != 0) {
                totalSumm += 50;
                countOfDenominations++;
                fifties--;
                summ -= 50;
                continue;
            }
            if ((summ - 20) >= 0 && twenties != 0) {
                totalSumm += 20;
                countOfDenominations++;
                twenties--;
                summ -= 20;
                continue;
            }
            if ((summ - 10) >= 0 && tens != 0) {
                totalSumm += 10;
                countOfDenominations++;
                tens--;
                summ -= 10;
                continue;
            }
        }

        return totalSumm;
    }
}