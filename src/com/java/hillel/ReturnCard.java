package com.java.hillel;

public class ReturnCard implements Operation {
    @Override
    public void operation(Card card) {
        System.out.println("Please take your card");
    }
}
