package com.itacademy.homework.menu;

import com.itacademy.homework.enums.ProductType;
import com.itacademy.homework.exception.InvalidNumberException;
import com.itacademy.homework.exception.NoRequiredAmountOfMoneyException;
import com.itacademy.homework.models.Customer;
import com.itacademy.homework.models.Product;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Serializable {

  Scanner scan;

  public Menu() {
    this.scan = new Scanner(System.in);
  }

  public void goMenu() {
    List<Product> productList = new ArrayList<>();
    productList.add(new Product("Milk", ProductType.FOOD, LocalDate.of(2021, 1,
        13), 2));
    productList.add(new Product("Bread", ProductType.FOOD, LocalDate.of(2021, 1,
        12), 1));
    productList.add(new Product("Trousers", ProductType.CLOTHES, LocalDate.of(2020, 3,
        10), 55));
    productList.add(new Product("T-shirt", ProductType.CLOTHES, LocalDate.of(2020, 4,
        22), 15));
    productList.add(new Product("TV", ProductType.TECHNICS, LocalDate.of(2017, 11,
        01), 370));
    productList.add(new Product("Computer", ProductType.TECHNICS, LocalDate.of(2020, 01,
        02), 1000));

    List<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer("Hello", "235689", 100));
    customerList.add(new Customer("Palm", "4582oi", 156));
    customerList.add(new Customer("1", "1", 20));
    customerList.add(new Customer("Film", "2hygf985", 1000));

    int exit = 0;
    Customer customer = null;
    while (exit != -1) {
      System.out.println("Enter your login: ");
      String login = scan.nextLine();
      System.out.println("Enter your password: ");
      String password = scan.nextLine();
      for (int i = 0; i < customerList.size(); i++) {
        if (customerList.get(i).getLogin().equals(login) &&
            customerList.get(i).getPassword().equals(password)) {
          customer = customerList.get(i);
          System.out.println("Login and password are correct. Hello.");
          exit = -1;
        }
      }
      if (customer == null) {
        System.out.println("Login and password are incorrect. Try again");
      }
    }
    int number = 0;

    while (number != 4) {
      System.out.println("MENU: ");
      System.out.println("To view the list of products, press 1");
      System.out.println("To purchase goods, press 2.");
      System.out.println("To view a list of purchased products, press 3.");
      System.out.println("To exit the store, press 4. ");
      System.out.println("Print shopping list to file, press 5");
      number = scan.nextInt();

      switch (number) {
        case 1:
          printProductList(productList);
          break;
        case 2:
          try {
            enterIdProduct(productList, customer);
          } catch (InvalidNumberException | NoRequiredAmountOfMoneyException e) {
            System.err.println(e.getMessage());
          }
          break;
        case 3:
          printPurchasedGoods(customer.getPurchasedGoods());
          break;
        case 4:
          System.out.println("Exit. Come back for shopping.");
          break;
        case 5:
          printShoppingList(customer.getPurchasedGoods());
          serializeObject(customer.getPurchasedGoods());
          deSerialiseAndPrintObject(customer.getPurchasedGoods());
          break;
        default:
          System.out.println("You entered the wrong number. Try again.");
      }
    }
    scan.close();
  }

  public void printProductList(List<Product> products) {
    for (int i = 0; i < products.size(); i++) {
      System.out.println(i + " - " + products.get(i).toString());
    }
  }

  public void enterIdProduct(List<Product> products, Customer customer)
      throws InvalidNumberException, NoRequiredAmountOfMoneyException {
    System.out.println("Enter the ids of the selected product. -1 to exit");
    int id = scan.nextInt();
    while (id != -1) {
      if (id >= 0 && id < products.size()) {
        if (customer.getAmountOfMoney() > products.get(id).getCost()) {
          int customerAmountOfMoney = customer.getAmountOfMoney();
          customer.setAmountOfMoney(customerAmountOfMoney - products.get(id).getCost());
          Product pr = products.remove(id);
          customer.getPurchasedGoods().add(pr);
        } else {
          throw new NoRequiredAmountOfMoneyException
              ("There is no required amount of money. Fund your account.");
        }
      } else {
        throw new InvalidNumberException("Invalid number entered.Try again.");
      }
      System.out.println("Item purchased " + id);
      id = scan.nextInt();
    }
  }

  public void printPurchasedGoods(List<Product> purchasedGoods) {
    for (int i = 0; i < purchasedGoods.size(); i++) {

      System.out.println(purchasedGoods.toString());
    }
  }

  public void printShoppingList(List<Product> purchasedGoods) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter
        ("shopping-list.txt", true))) {
      String s = purchasedGoods.toString();
      out.write(s);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void serializeObject(List<Product> purchasedGoods) {
    ObjectOutputStream oos = null;
    try {
      FileOutputStream fos = new FileOutputStream("purchased-goods-file.txt");
      oos = new ObjectOutputStream(fos);
      oos.writeObject(purchasedGoods);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (oos != null) {
          oos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void deSerialiseAndPrintObject(List<Product> purchasedGoods) {
    try (ObjectInputStream ois = new ObjectInputStream
        (new FileInputStream("purchased-goods-file.txt"))) {
      List<Product> deSerObject = (List<Product>) ois.readObject();
      System.out.println("Deserialized purchased of goods: " + deSerObject.toString());
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

}
