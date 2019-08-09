package com.github.quantumquality;

public enum FoodType {

    BURGER(9000), FRYTKI(6000), ZIELSKO(5000), NACHOSY(3000), SERUŚ(7000);

    private int preparationDurationMillis;
    private int timeInMinutes;

    FoodType(int preparationDurationMillis) {
        this.preparationDurationMillis = preparationDurationMillis;
    }

    public static FoodType fromNameIgnoreCase(String name) {
        FoodType[] values = values();
        for (FoodType value : values) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
        throw new IllegalFoodException();
    }

    public int getPreparationDurationMillis() {
        return preparationDurationMillis;
    }

    public int getTimeInSeconds() {
        return preparationDurationMillis / 1000;
    }
}
