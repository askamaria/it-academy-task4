package com.itacademy.homework.enams;

public enum CarModel {

  MERCEDES("mercedes", "germany", 1901),
  BMW("bmw", "germany", 1916),
  MAZDA("mazda", "japan", 1960),
  TESLA("tesla", "usa", 2007),
  LADA("lada", "russia", 1966);
  private String carModelName;
  private String carModelCountry;
  private int carModelYear;

  CarModel(String carModelName, String carModelCountry, int carModelYear) {
    this.carModelName = carModelName;
    this.carModelCountry = carModelCountry;
    this.carModelYear = carModelYear;
  }

  public String getCarModelName() {
    return carModelName;
  }

  public void setCarModelName(String carModelName) {
    this.carModelName = carModelName;
  }

  public String getCarModelCountry() {
    return carModelCountry;
  }

  public void setCarModelCountry(String carModelCountry) {
    this.carModelCountry = carModelCountry;
  }

  public int getCarModelYear() {
    return carModelYear;
  }

  public void setCarModelYear(int carModelYear) {
    this.carModelYear = carModelYear;
  }

  @Override
  public String toString() {
    return "CarModel{" +
        "carModelName='" + carModelName + '\'' +
        ", carModelCountry='" + carModelCountry + '\'' +
        ", carModelYear=" + carModelYear +
        '}';
  }
}
