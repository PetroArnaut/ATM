package com.java.hillel;

import java.util.GregorianCalendar;
import java.util.Scanner;


public class ATM {
    private double totalMoney;
    private Card currentCard;
    private Scanner scanner = new Scanner(System.in);
    private static final double COMMISSION = 1.5;
    private static final int MAX_NOTES = 50;

    ATM(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void start(Person person) {
        currentCard = person.getCard();
        printMenu();
    }

    private void function(String op) {
        switch (op) {
            case "1":
                System.out.println(currentCard.getAmount());
                break;
            case "2":
                getMoney();
                break;
            case "3":
                onLinePayment();
                break;
            default:
                break;
        }
    }

    private void getMoney() {
        System.out.println("enter amount");
        int temp = scanner.nextInt();
        if (temp + getCommission(temp) < currentCard.getAmount()) {
            if(countNotes(temp) > MAX_NOTES)
                System.out.println("I cant dive you this suum");
            else {
                System.out.println("Coomission on your card is " + getCommission(temp));
                System.out.println("Pls take your money");
                System.out.println(countNotes(temp) + " notes");
                currentCard.setAmount(currentCard.getAmount() - temp - getCommission(temp));
            }
        } else {
            System.out.println("It is not enough money in your card");
        }
    }

    private void onLinePayment() {
        System.out.println("enter amount");
        int temp = scanner.nextInt();
        if (temp < currentCard.getAmount()) {
            System.out.println("Payment is OK");
            currentCard.setAmount(currentCard.getAmount() - temp);
        } else {
            System.out.println("It is not enough money in your card");
        }
    }


    private boolean checkPinCode(String pinCode) {
        return pinCode.equals(currentCard.getPinCode());
    }


    private void blockCard() {
        System.out.println("Your card is blocked");
    }

    private void returnCard() {
        System.out.println("Pls take your card");
    }

    private void printMenu() {
        int temp = 0;
        if(checkDate()) {
            System.out.println("Your card is not valid");
            returnCard();
            return;
        }
        while (true) {
            if (temp < 3) {
                System.out.println("input pin code (4 digits)");
                String pinCode = scanner.next();
                temp++;
                if (checkPinCode(pinCode))
                    break;
            } else {
                blockCard();
                return;
            }
        }
        while (true) {
            System.out.println("select");
            System.out.println("1 - Check balance");
            System.out.println("2 - Get money");
            System.out.println("3 - Mobile payment");
            String op = scanner.next();
            function(op);
            System.out.println("Continue? (y / n)");
            if (scanner.next().equals("y"))
                continue;
            else {
                returnCard();
                break;
            }
        }
    }

    private boolean checkDate() {
        return (currentCard.getDate().before(new GregorianCalendar()));
    }

    private double getCommission(double summ) {
        if (currentCard.getType().equals(CardType.MAESTRO))
            return 0;
        return summ * COMMISSION / 100;
    }

    private int countNotes(int summ) {
        int result = 0;
        result += summ / 200;
        summ = summ % 200;
        result += summ / 100;
        summ = summ % 100;
        result += summ / 50;
        summ = summ % 50;
        result += summ / 20;
        return result;
    }
}