package com.itacademy.homework.models;

import com.itacademy.homework.enums.ProductType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Product implements Serializable {

  private static final long serialVersionUID = 0L;
  private final UUID uuid;
  private final String name;
  private final ProductType type;
  private final LocalDate productionDate;
  private final int cost;

  public Product(String name, ProductType type, LocalDate productionDate, int cost) {
    this.name = name;
    this.type = type;
    this.productionDate = productionDate;
    this.cost = cost;
    this.uuid = UUID.randomUUID();
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public ProductType getType() {
    return type;
  }

  public LocalDate getProductionDate() {
    return productionDate;
  }

  public int getCost() {
    return cost;
  }

  @Override
  public String toString() {
    return "Product{" +
        "uuid=" + uuid +
        ", name='" + name + '\'' +
        ", type=" + type +
        ", productionDate=" + productionDate +
        ", cost=" + cost +
        '}';
  }
}
