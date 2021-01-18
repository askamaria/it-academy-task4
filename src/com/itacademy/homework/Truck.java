package com.itacademy.homework;

import java.util.Calendar;

public class Truck extends Car {

    private String truckBodyType;
    private int carryingCapacity;

    public Truck(String name, int carNumber, Calendar releaseDate, CarModel carModel,
                 boolean isMovable, String truckBodyType, int truckWeight) {
        super(name, carNumber, releaseDate, carModel, isMovable);
        this.truckBodyType = truckBodyType;
        this.carryingCapacity = truckWeight;
    }

    public void cargoLoading() {
        System.out.println("Loading load is completed!");
    }

    public void cargoLoading(int cargoWeight) {
        System.out.println("Loading cargo of " + cargoWeight + "kg is completed!");
    }

    public boolean isTruckAbleToCarryCapacity(int cargoWeight) {
        if (carryingCapacity >= cargoWeight) {
            return true;
        } else
            return false;
    }

    public String getTruckBodyType() {
        return truckBodyType;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    protected void toStop() {
        super.toStop();
        System.out.println("Truck is stop.");
    }

    @Override
    public void toMove() {
        setMoving(true);
        System.out.println("Truck is moving");
    }


}
