package com.itacademy.homework.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {

private String login;
private String password;
private int amountOfMoney;
private List<Product> purchasedGoods;

  public Customer(String login, String password, int amountOfMoney) {
    this.login = login;
    this.password = password;
    this.amountOfMoney = amountOfMoney;
    purchasedGoods=new ArrayList<Product>();

  }
  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public int getAmountOfMoney() {
    return amountOfMoney;
  }

  public List<Product> getPurchasedGoods() {
    return purchasedGoods;
  }

  public void setAmountOfMoney(int amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", amountOfMoney=" + amountOfMoney +
        '}';
  }
}
