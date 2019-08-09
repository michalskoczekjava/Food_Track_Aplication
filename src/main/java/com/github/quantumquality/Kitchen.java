package com.github.quantumquality;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Kitchen {

    private Manager manager;
    private String orderName;

    public String getOrderName() {
        return orderName;
    }

    //    stworzyc kolecja (arraylist) beeperow
    List<Beeper> listaBeeperow = new ArrayList<>();


    public void makeAMeal(Beeper beeper) {
        System.out.println("Przygotowujemy Twoje zamówienie! Cierpliwości");
        MealPreparation mealPreparation = new MealPreparation(this, beeper);
        Timer timer = new Timer();
        timer.schedule(mealPreparation, beeper.getFoodType().getPreparationDurationMillis());
    }

    public void mealIsReady(Beeper beeper) {
        manager.mealReady(beeper);
        System.out.println("Zamówienie gotowe!" + beeper.getFoodType().name());
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
