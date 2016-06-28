package com.java.hillel;

public class ATMFactory {


    public Operation getChoice(String type) {

        Operation operation;
        switch (type) {
            case "1":
                operation = new CheckBalance();
                break;
            case "2":
                operation = new Cash();
                break;
            case "3":
                operation = new OnLinePayment();
                break;
            case "4":
                operation = new Bill();
                break;
            default:
                operation = new ReturnCard();
        }
        return  operation;
    }
}