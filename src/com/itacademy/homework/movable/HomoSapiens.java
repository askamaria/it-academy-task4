package com.itacademy.homework.movable;

public class HomoSapiens implements Movable {

  private final String name;
  private final int price;
  private Eyes eyes;

  public HomoSapiens(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public HomoSapiens(String name, int price, String eyeColor) {
    this.name = name;
    this.price = price;
    this.eyes = this.new Eyes(eyeColor);
  }

  @Override
  public int getPrice() {
    return price;
  }

  public void toEvolves() {
    System.out.println("Homo sapiens is evolves.");
  }

  public String getName() {
    return name;
  }

  @Override
  public void toMove() {
    System.out.println("Human steps feet");
  }

  @Override
  public String toString() {
    return "HomoSapiens{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }

  public class Eyes {

    private String color;

    public Eyes(String color) {
      this.color = color;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }
  }
}
