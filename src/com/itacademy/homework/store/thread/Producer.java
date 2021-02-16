package com.itacademy.homework.store.thread;

import com.itacademy.homework.movable.HomoSapiens;
import com.itacademy.homework.movable.Movable;
import com.itacademy.homework.store.Store;

public class Producer implements Runnable {

  Store<Movable> store;

  public Producer(Store<Movable> store) {
    this.store = store;
  }

  @Override
  public void run() {
    while (true) {
      HomoSapiens men = new HomoSapiens("Teddi", 26);
      store.sell(men, 16);
    }
  }
}
