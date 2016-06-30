package com.java.hillel;

public class ATMFactory {


    public Operation getChoice(String type) {

        switch (type) {
            case "1":
                return new CheckBalance();
            case "2":
                return new Cash();
            case "3":
                return new OnLinePayment();
            case "4":
                return new Bill();
            default:
                return new ReturnCard();
        }
    }
}