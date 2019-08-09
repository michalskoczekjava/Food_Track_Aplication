package com.github.quantumquality;

import java.util.List;

public class CashRegister {

    private Manager manager;
    private FoodType foodType;

    public void newOrder(FoodType foodType) {
        manager.newOrder(foodType);
    }


    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
