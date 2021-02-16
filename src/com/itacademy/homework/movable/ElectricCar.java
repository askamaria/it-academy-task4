package com.itacademy.homework.movable;

import com.itacademy.homework.enams.CarModel;
import java.util.Calendar;

public class ElectricCar extends Car {

  public static final int MAX_PERCENT = 100;
  private final int butteryLevelPercentage;
  private boolean isClosed;
  private final int price;
  private final int tempUnderTheSeat;


  public ElectricCar(String name, int carNumber, Calendar releaseDate, CarModel carModel,
      boolean isMoving, int butteryLevelPercentage, boolean isClosed, int price,
      int tempUnderTheSeat) {
    super(name, carNumber, releaseDate, carModel, isMoving);
    this.butteryLevelPercentage = butteryLevelPercentage;
    this.isClosed = isClosed;
    this.price = price;
    this.tempUnderTheSeat = tempUnderTheSeat;
  }

  public ElectricCar(int butteryLevelPercentage, int price, int tempUnderTheSeat) {
    this.butteryLevelPercentage = butteryLevelPercentage;
    this.price = price;
    this.tempUnderTheSeat = tempUnderTheSeat;
  }

  public void printMissingCharge() {
    synchronized (this) {
      if (butteryLevelPercentage < MAX_PERCENT) {
        System.out.println(
            "The required additional charge level is " + (MAX_PERCENT - butteryLevelPercentage)
                + " %");
        System.out.println("I'm synchronized block!");
      } else {
        System.out.println("Battery fully charged. ");

      }
    }
  }

//  public void printMissingCharge(int levelPercent) {
//    if (butteryLevelPercentage < levelPercent) {
//      System.out.println(
//          "The required additional charge level is " + (levelPercent - butteryLevelPercentage)
//              + " %");
//    } else {
//      System.out.println("Battery fully charged. ");
//    }
//  }

//  public void close() {
//    isClosed = true;
//    System.out.println("Electric car is closed.");
//  }

//  public int getButteryLevelPercentage() {
//    return butteryLevelPercentage;
//  }

//  public boolean isClosed() {
//    return isClosed;
//  }

  @Override
  public int getPrice() {
    return price;
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

  @Override
  public String toString() {
    return "ElectricCar{" +
        "butteryLevelPercentage=" + butteryLevelPercentage +
        ", isClosed=" + isClosed +
        ", price=" + price +
        '}';
  }

  public class Seat {

    public void Back() {
      System.out.println("The seat moves back");
    }

    public void Forward() {
      System.out.println("The seat moves forward");
    }


    public int getTempUnderTheSeat() {
      return ElectricCar.this.tempUnderTheSeat;
    }

  }
}
