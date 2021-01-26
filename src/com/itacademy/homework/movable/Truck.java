package com.itacademy.homework.movable;

import com.itacademy.homework.enams.CarModel;
import java.util.Calendar;

public class Truck extends Car {

  Truck.SteeringWheel steeringWheel = new Truck.SteeringWheel();
  private String truckBodyType;
  private int carryingCapacity;
  private int price;

  public Truck(String name, int carNumber, Calendar releaseDate, CarModel carModel,
      boolean isMovable, String truckBodyType, int truckWeight, int price) {
    super(name, carNumber, releaseDate, carModel, isMovable);
    this.truckBodyType = truckBodyType;
    this.carryingCapacity = truckWeight;
    this.price = price;
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
    } else {
      return false;
    }
  }

  @Override
  public int getPrice() {
    return price;
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

  @Override
  public String toString() {
    return "Truck{" +
        "truckBodyType='" + truckBodyType + '\'' +
        ", carryingCapacity=" + carryingCapacity +
        ", price=" + price +
        '}';
  }

  public static class SteeringWheel {

    public static void right() {
      System.out.println("Turn the steering wheel to the right.");
    }

    public static void left() {
      System.out.println("Turn the steering wheel to the left");
    }
  }
}





