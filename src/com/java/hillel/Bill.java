package com.java.hillel;

public class Bill implements Operation{

    public void operation(Card card) {

        System.out.println("You have " + card.getAmount() + " in your account");
    }
}