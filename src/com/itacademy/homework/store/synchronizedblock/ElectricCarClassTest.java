package com.itacademy.homework.store.synchronizedblock;

import com.itacademy.homework.movable.ElectricCar;

public class ElectricCarClassTest extends Thread {

  ElectricCar electricCar;

  public ElectricCarClassTest(ElectricCar electricCar) {
    this.electricCar = electricCar;
  }

  @Override
  public void run() {
    electricCar.printMissingCharge();
  }
}
