package com.itacademy.homework;

import java.util.Calendar;
import java.util.SortedMap;

public class Main {
    public static final int CARGO_WEIGHT = 1500;

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, Calendar.JANUARY, 2);
        Car carTruck = new Truck("BMW-truck", 5626, calendar, CarModel.BMW, false,
                "Big", 1860);
        System.out.println(carTruck);
        //Создание экземпляра типа Truck для вызова метода из класса Truck.
        Truck newTruck = new Truck("LadaTruck", 2356, calendar, CarModel.LADA,
                true, "Big", 1250);
        printTruckAbleToCarryCapacity(newTruck);
        System.out.println(newTruck);
        Car electricCar = new ElectricCar("Tesla 2106", 8975, calendar, CarModel.TESLA,
                true, 56, true);
        System.out.println(electricCar);
        Movable caterpillar = new Caterpillar("green");
        Movable homoSapiens = new HomoSapiens("Eddi");

    }

    private static void printTruckAbleToCarryCapacity(Truck truck) {
        System.out.println("Is truck able to carry capacity of " + CARGO_WEIGHT + "? " +
                truck.isTruckAbleToCarryCapacity(CARGO_WEIGHT));

    }

}
