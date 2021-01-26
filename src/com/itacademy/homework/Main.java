package com.itacademy.homework;

import com.itacademy.homework.enams.CarModel;
import com.itacademy.homework.movable.Car;
import com.itacademy.homework.movable.Caterpillar;
import com.itacademy.homework.movable.ElectricCar;
import com.itacademy.homework.movable.HomoSapiens;
import com.itacademy.homework.movable.Movable;
import com.itacademy.homework.movable.Truck;
import com.itacademy.homework.store.Store;
import java.util.Calendar;

public class Main {

  public static final int CARGO_WEIGHT = 1500;

  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(1989, Calendar.JANUARY, 2);
    Car carTruck = new Truck("BMW-truck", 5626, calendar, CarModel.BMW, false,
        "Big", 1860, 12500);
    System.out.println(carTruck);
    //Создание экземпляра типа Truck для вызова метода из класса Truck.
    Truck newTruck = new Truck("LadaTruck", 2356, calendar, CarModel.LADA,
        true, "Big", 1250, 16860);
    printTruckAbleToCarryCapacity(newTruck);
    System.out.println(newTruck);
    ElectricCar electricCar = new ElectricCar("Tesla 2106", 8975, calendar, CarModel.TESLA,
        true, 56, true, 50000, 28);

    System.out.println("----------------------------------");
    ElectricCar.Seat seat = electricCar.new Seat();
    System.out.println("Temperature under the seat is " + seat.getTempUnderTheSeat() + " Degrees.");
    Truck.SteeringWheel.right();
    Truck.SteeringWheel.left();
    System.out.println(electricCar);

    System.out.println("----------------------------------");
    Caterpillar caterpillar3 = new Caterpillar("grey", 158);
    Caterpillar.CaterpillarHead caterpillarHead = caterpillar3.new CaterpillarHead("round");
    caterpillarHead.Chew();
    System.out.println("Color of caterpillar's head is " + caterpillarHead.getOuterColor());
    Movable caterpillar = new Caterpillar("green", 25);
    Movable caterpillar2 = new Caterpillar("red", 58);
    Movable homoSapiens = new HomoSapiens("Eddi", 1000);
    HomoSapiens homoSapiens1 = new HomoSapiens("Elli", 4595);
    HomoSapiens homoSapiensWithEye = new HomoSapiens("Peter", 123, "blue");

    System.out.println("----------------------------------");

    Movable[] storeArray = new Movable[5];
    storeArray[0] = homoSapiens;
    storeArray[1] = caterpillar;
    storeArray[2] = electricCar;
    storeArray[3] = carTruck;
    storeArray[4] = caterpillar2;
    Store<Movable> store = new Store<>(storeArray);
    System.out.println("Shop before purchasing goods");
    store.printProducts();
    System.out.println(
        "Amount of money on store before payment of good: " + store.getAmountOfMoneyOnStore());
    Movable purchase = null;
    try {
      purchase = store.purchase(1, 60);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      purchase = store.purchase(1, 60);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    System.out.println(
        "Good: " + purchase + "\nAmount of money on store after payment of good: " + store
            .getAmountOfMoneyOnStore());
    System.out.println("Shop after purchasing goods");
    store.printProducts();
    try {
      purchase = store.purchase(2, 1000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("---------------------------");
    store.sell(caterpillar2, 50);
    store.printProducts();
    System.out.println(
        "Amount of money on store after payment of new good: " + store.getAmountOfMoneyOnStore());
    store.sell(caterpillar2, 10);


  }

  private static void printTruckAbleToCarryCapacity(Truck truck) {
    System.out.println("Is truck able to carry capacity of " + CARGO_WEIGHT + "? " +
        truck.isTruckAbleToCarryCapacity(CARGO_WEIGHT));

  }

}
