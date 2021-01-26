package com.itacademy.homework.movable;

public class Caterpillar implements Movable {

  private final String color;
  private final int price;

  public Caterpillar(String color, int price) {
    this.color = color;
    this.price = price;
  }

  @Override
  public int getPrice() {
    return price;
  }

  public void eat() {
    System.out.println("The caterpillar is eating a leaf.");
  }

  public String getColor() {
    return color;
  }

  @Override
  public void toMove() {
    System.out.println("The caterpillar is moving");
  }

  @Override
  public String toString() {
    return "Caterpillar{" +
        "color='" + color + '\'' +
        ", price=" + price +
        '}';
  }

  public class CaterpillarHead {

    public String mouth;

    public CaterpillarHead(String mouth) {
      this.mouth = mouth;
    }

    public void Chew() {
    }

    public String getOuterColor() {
      return Caterpillar.this.color;
    }
  }

}
