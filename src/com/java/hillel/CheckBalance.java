package com.java.hillel;

public class CheckBalance implements Operation{

    @Override
    public void operation(Card card) {
        System.out.println("Your balance is " + card.getAmount());
    }
}