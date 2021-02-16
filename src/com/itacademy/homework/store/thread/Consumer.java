package com.itacademy.homework.store.thread;

import com.itacademy.homework.movable.Movable;
import com.itacademy.homework.store.Store;

public class Consumer implements Runnable {

  Store<Movable> store;

  public Consumer(Store<Movable> store) {
    this.store = store;
  }

  @Override
  public void run() {
    while (true) {
      for (int i = 0; i < store.getArrayProducts().length; i++) {
        try {
          Movable purchase = store.purchase(i, 256);
          System.out.println("bought: " + purchase);
        } catch (Exception e) {
        }
      }
    }
  }
}

