package com.itacademy.homework.store;

import com.itacademy.homework.movable.Movable;

public class Store<T extends Movable> {

  private int amountOfMoneyOnStore = 2000;
  private final T[] arrayProducts;

  public Store(T[] arrayProducts) {

    this.arrayProducts = arrayProducts;
  }

  public void printProducts() {
    for (int i = 0; i < arrayProducts.length; i++) {
      System.out.println("Element " + i + "= " + arrayProducts[i]);
    }

  }

  public T purchase(int indexProduct, int amountOfMoney) throws Exception {
    T prod = arrayProducts[indexProduct];
    if (prod == null) {
      throw new Exception("The item you selected is not available. Please select another product.");
    }
    if (prod.getPrice() < amountOfMoney) {
      arrayProducts[indexProduct] = null;
      amountOfMoneyOnStore += prod.getPrice();
    } else {
      System.out.println("You don't have enough money to buy a product. ");
    }
    return prod;
  }

  public void sell(T storeProduct, int myPrice) {
    if (myPrice < storeProduct.getPrice() && myPrice < amountOfMoneyOnStore) {
      for (int i = 0; i < arrayProducts.length; i++) {
        if (arrayProducts[i] == null) {
          arrayProducts[i] = storeProduct;
          amountOfMoneyOnStore -= myPrice;

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


