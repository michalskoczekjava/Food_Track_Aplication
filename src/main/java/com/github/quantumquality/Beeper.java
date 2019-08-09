package com.github.quantumquality;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

public class Beeper {


    private final String uuid = UUID.randomUUID().toString();
    //    private final UUID uuid;
    private String orderName;
    private String contentOfOrder;
    private LocalDateTime createdAt;
    private LocalDateTime calledAt;
    private LocalDateTime timeOfReceive;
    private FoodType foodType;

    public FoodType getFoodType() {
        return foodType;
    }

    public Beeper(String orderName) {
        this.foodType = FoodType.valueOf(orderName);
        long a = System.currentTimeMillis();
        int j = foodType.getTimeInSeconds();
        for(int i = 0; i<= j; i++)


        System.out.println("czas oczekiwania: " + foodType.getTimeInSeconds() + " sekund");
        this.createdAt = LocalDateTime.now();
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public String getOrderName() {
        return orderName;
    }

    @Override                                       // nadpisujemy bo sa to metody klasy Object
    public int hashCode() {                         // funkcja matematyczna. zmienia dany obiekt w liczbe
        return Objects.hashCode(this.uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Beeper) {
            Beeper that = (Beeper) obj;
            return Objects.equals(this.uuid, that.uuid);

        }
        return false;
    }
    @Override
    public String toString() {
        return foodType.name() + " " + createdAt ;
    }
}
