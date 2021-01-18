package com.itacademy.homework;

import java.util.Calendar;

public class ElectricCar extends Car {

    private int butteryLevelPercentage;
    private boolean isClosed;
    public static final int MAX_PERCENT = 100;

    public ElectricCar(String name, int carNumber, Calendar releaseDate, CarModel carModel,
                       boolean isMoving, int butteryLevelPercentage, boolean isClosed) {
        super(name, carNumber, releaseDate, carModel, isMoving);
        this.butteryLevelPercentage = butteryLevelPercentage;
        this.isClosed = isClosed;
    }

    public void printMissingCharge() {
        if (butteryLevelPercentage < MAX_PERCENT) {
            System.out.println("The required additional charge level is " + (MAX_PERCENT - butteryLevelPercentage) + " %");
        } else {
            System.out.println("Battery fully charged. ");
        }
    }

    public void printMissingCharge(int levelPercent) {
        if (butteryLevelPercentage < levelPercent) {
            System.out.println("The required additional charge level is " + (levelPercent - butteryLevelPercentage) + " %");
        } else {
            System.out.println("Battery fully charged. ");
        }
    }

    public void close() {
        isClosed = true;
        System.out.println("Electric car is closed.");
    }

    public int getButteryLevelPercentage() {
        return butteryLevelPercentage;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    protected void toStop() {
        super.toStop();
        System.out.println("ElectricCar is stop");
    }

    @Override
    public void toMove() {
        setMoving(true);
        System.out.println("ElectricCar is moving");
    }

}
