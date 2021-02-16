package com.itacademy.homework;

import com.itacademy.homework.movable.Car;
import com.itacademy.homework.movable.ElectricCar;
import com.itacademy.homework.movable.Movable;
import com.itacademy.homework.store.thread.Consumer;
import com.itacademy.homework.store.synchronizedblock.ElectricCarClassTest;
import com.itacademy.homework.store.thread.Producer;
import com.itacademy.homework.store.Store;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    ElectricCar electricCar = new ElectricCar(56, 45000, 22);
    ElectricCarClassTest electricCarClassTest = new ElectricCarClassTest(electricCar);
    Thread electricCarThread = new Thread(electricCarClassTest);
    electricCarThread.start();
    electricCarThread.join(1000);

    System.out.println("----------------------------------");

    Thread car = new Car();
    car.start();
    for (int i = 0; i < 3; i++) {
      System.out.println("Main iteration: " + i);
      Thread.sleep(1000);
      if (i == 1) {
        car.join();
      }
    }

    Store<Movable> store = new Store<>(new Movable[10]);
    Producer producer = new Producer(store);
    Consumer consumer = new Consumer(store);
    Thread producerThread = new Thread(producer);
    producerThread.setDaemon(true);
    producerThread.start();
    System.out.println(producerThread.isAlive());
    new Thread(consumer).start();
    while (true) {
      System.err.println(producerThread.getState());
      Thread.sleep(300);
    }
  }
}




