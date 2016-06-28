package com.java.hillel;

public class ATM {
    private double totalMoney;
    private Card currentCard;
    private Denominations denominations;
    private static volatile ATM instance = null;

    private ATM(double totalMoney) {
        this.totalMoney = totalMoney;
        denominations = new Denominations(totalMoney);
    }

    public static ATM getInstance(double totalMoney) {
        if (instance == null)
            instance = new ATM(totalMoney);
        return instance;
    }

    public void start(Person person) {
        currentCard = person.getCard();
        if (Security.checkDate(person.getCard())) {
            System.out.println("Your card is not valid");
            return;
        }

        if(Security.checkPinCode(currentCard)) {
            while (true) {
                ATMFactory atmFactory = new ATMFactory();
                Operation operation = atmFactory.getChoice(ATMUserInteraction.printMenu());
                operation.operation(currentCard);
                if (operation instanceof ReturnCard)
                    break;
                if (!ATMUserInteraction.needToContinue()) {
                    new ReturnCard().operation(currentCard);
                    break;
                }
            }
        } else
            Security.blockCard();
    }

}