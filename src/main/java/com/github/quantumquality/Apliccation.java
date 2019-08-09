package com.github.quantumquality;


import javax.swing.*;
import java.io.IOException;

public class Apliccation {
    public static void main(String[] args) {

        Kitchen kitchen = new Kitchen();
        CollectionPoint collectionPoint = new CollectionPoint();
        CashRegister cashRegister = new CashRegister();
        Manager manager = new Manager(cashRegister, kitchen, collectionPoint);

        kitchen.setManager(manager);
        collectionPoint.setManager(manager);
        cashRegister.setManager(manager);

        System.out.println("Dzień dobry! Oto nasze MENU: ");
        System.out.println("Burger");
        System.out.println("Frytki");
        System.out.println("Zielsko");
        System.out.println("Nachosy");
        System.out.println("Seruś");

        for (int i = 0; ; i++) {

            String input = JOptionPane.showInputDialog("Co chcesz zamówić ?");
            FoodType foodType = FoodType.fromNameIgnoreCase(input);
            if (input.equalsIgnoreCase("q")) {
                try {
                    manager.createFile("Zamowienia", manager.listaBeeperow);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } else if (foodType != null) {
                cashRegister.newOrder(FoodType.fromNameIgnoreCase(input));
            } else {
                System.out.println("Nie mamy tego w menu");
            }

            System.out.println(manager.listaBeeperow);
            System.out.println("Co chcesz zamówić ?");
        }
    }
}

