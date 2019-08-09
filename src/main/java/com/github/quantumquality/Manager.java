package com.github.quantumquality;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Manager {

    private CashRegister cashRegister;
    private Kitchen kitchen;
    private CollectionPoint collectionPoint;
    private FoodType foodType;

    List<Beeper> listaBeeperow = new ArrayList<>();


    public Manager(CashRegister cashRegister, Kitchen kitchen, CollectionPoint collectionPoint) {
        this.cashRegister = cashRegister;
        this.kitchen = kitchen;
        this.collectionPoint = collectionPoint;
    }


    public void newOrder(FoodType foodType) {
        Beeper beeper = new Beeper(foodType.name());
        prepareMeal(beeper);
        listaBeeperow.add(beeper);
    }

    public void createFile(String file, List<Beeper> beeperList) throws IOException {
        FileWriter writer = new FileWriter(file + ".txt");
        int size = beeperList.size();
        for (int i = 0; i < size; i++) {
            String str = beeperList.get(i).toString();
            writer.write(str);
            if (i < size - 1)//This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
        writer.close();
    }

    public void prepareMeal(Beeper beeper) {
        kitchen.makeAMeal(beeper);
    }

    public void mealReady(Beeper beeper) {
        callCustomer(beeper);
    }

    public void callCustomer(Beeper beeper) {
        collectionPoint.callAClient(beeper);
    }

    public void orderReceived(Beeper beeper) {
        listaBeeperow.add(beeper);
    }
}
