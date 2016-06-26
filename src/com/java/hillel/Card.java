package com.java.hillel;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Card {

    private CardType type;
    private String cardNumber;
    Calendar date;
    private double amount = 10000;
    private String pinCode;

    private Random rnd;

    public Card(CardType type, String cardNumber) {
        this.type = type;
        this.cardNumber = cardNumber;
        pinCode = "1234";
        date = new GregorianCalendar(2017, 9, 0);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPinCode() {
        return pinCode;
    }

    public CardType getType() {
        return type;
    }

    public Calendar getDate() {
        return date;
    }
}