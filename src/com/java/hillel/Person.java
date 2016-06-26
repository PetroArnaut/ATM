package com.java.hillel;

import java.util.Random;

public class Person {

    private Random random = new Random();
    Card card = new Card(CardType.MASTER_CARD, "123456789");


    public boolean insertCard() {
        return (random.nextInt(10) / 8 == 0);
    }

    public Card getCard() {
        return card;
    }
}