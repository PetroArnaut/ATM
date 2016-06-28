package com.java.hillel;

public class Main {

    public static void main(String[] args) throws Exception {


        ATM atm = ATM.getInstance(20000);
        Person person = new Person();
        System.out.println("Insert your card");
        Thread.sleep(1000);
        while (!person.insertCard()) {
            System.out.println("Pls insert your card correct");
            Thread.sleep(1000);
        }
        atm.start(person);
    }
}