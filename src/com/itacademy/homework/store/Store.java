package com.itacademy.homework.store;

import com.itacademy.homework.movable.Movable;

public class Store<T extends Movable> {

  private final T[] arrayProducts;
  private int amountOfMoneyOnStore = 2000;
  private int counter;

  public Store(T[] arrayProducts) {
    this.arrayProducts = arrayProducts;
    counter = 0;
  }

  public void printProducts() {
    for (int i = 0; i < arrayProducts.length; i++) {
      System.out.println("Element " + i + "= " + arrayProducts[i]);
    }
  }

  public synchronized T purchase(int indexProduct, int amountOfMoney) throws Exception {
    T prod = arrayProducts[indexProduct];
    Thread.sleep(1000L);
    while (counter == 0) {
      wait();
    }

    if (prod == null) {
      throw new Exception("The item you selected is not available. Please select another product.");
    }
    if (prod.getPrice() < amountOfMoney) {
      arrayProducts[indexProduct] = null;
      amountOfMoneyOnStore += prod.getPrice();
    } else {
      System.out.println("You don't have enough money to buy a product. ");
    }
    counter--;
    System.out.println("Item purchased");
    System.out.println("quantity of goods in stock: " + counter);
    notify();
    return prod;
  }

  public synchronized void sell(T storeProduct, int myPrice) {
    try {
      Thread.sleep(500L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    while (counter == 5) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    counter++;
    System.out.println("Product added to store");
    System.out.println("quantity of goods in stock: " + counter);

    if (myPrice < storeProduct.getPrice() && myPrice < amountOfMoneyOnStore) {
      for (int i = 0; i < arrayProducts.length; i++) {
        if (arrayProducts[i] == null) {
          arrayProducts[i] = storeProduct;
          amountOfMoneyOnStore -= myPrice;
          System.out.println(storeProduct + " sold");
          notify();
          return;
        }
      }
      System.out.println("The store is full of goods.");

    } else {
      System.out.println("You don't have enough money in store checkout to buy this product.");
    }
  }

  public int getAmountOfMoneyOnStore() {
    return amountOfMoneyOnStore;
  }

  public T[] getArrayProducts() {
    return arrayProducts;
  }
}


