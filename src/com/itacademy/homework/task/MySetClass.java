package com.itacademy.homework.task;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class MySetClass {

  private final Set<Card> myCard = new HashSet<>();
  private final Set<Cargo> myCargo = new LinkedHashSet<>();

  public void addCard() {
    myCard.add(new Card(3));
    myCard.add(new Card(8));
    myCard.add(new Card(1));
    myCard.add(new Card(5));
    myCard.add(new Card(5));
    System.out.println(myCard);
  }

  public void addCargo() {
    myCargo.add(new Cargo(60));
    myCargo.add(new Cargo(25));
    myCargo.add(new Cargo(300));
    myCargo.add(new Cargo(30));
    myCargo.add(new Cargo(150));
    System.out.println(myCargo);
  }

  private int sumCargo() {
    int sum = 0;
    for (Cargo element :
        myCargo) {
      sum += element.getWeight();
    }
    return sum;
  }

  public Cargo ceiling() {
    if (sumCargo() > Cargo.MAX_WEIGHT) {
      Cargo maxCargo = Collections.max(myCargo);
      int delta = sumCargo() - Cargo.MAX_WEIGHT;
      System.out.println("Difference " + delta);
      return maxCargo;
    }
    return null;
  }

  public void removeElement(Cargo element) {
    System.out.println("Element for reduce sum " + element);
    myCargo.remove(element);
  }

  public void unloadCargo() {
    Iterator<Cargo> iterator = myCargo.iterator();
    while (iterator.hasNext()) {
      Cargo next = iterator.next();
      System.out.println(next + " has been unloaded");
      iterator.remove();
    }
  }

  public static class Card {

    private final int id;

    public Card(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "Card{" +
          "id=" + id +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Card card = (Card) o;
      return id == card.id;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
  }

  public static class Cargo implements Comparable<Cargo> {

    private static final int MAX_WEIGHT = 500;
    private final int weight;

    public Cargo(int weight) {
      this.weight = weight;
    }

    public static int getMaxWeight() {
      return MAX_WEIGHT;
    }

    public int getWeight() {
      return weight;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Cargo cargo = (Cargo) o;
      return weight == cargo.weight;
    }

    @Override
    public int hashCode() {
      return Objects.hash(weight);
    }

    @Override
    public String toString() {
      return "Cargo{" +
          "weight=" + weight +
          '}';
    }

    @Override
    public int compareTo(Cargo cargo) {
      return this.weight - cargo.weight;

    }
  }
}
