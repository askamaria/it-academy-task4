package com.itacademy.homework.task;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MyMapClass {

  private final Map<String, String> myMap = new HashMap<>();

  public void addUsers() {

    myMap.put("Lucik", "Zet56zuboy");
    myMap.put("Maria", "poweR_1");
    myMap.put("Aska", "Neko_23");
    myMap.put("Cat", "Kitty_56");
    printCollection();
  }

  public void addNewUser(String login, String password) {
    Pattern patternLogin = Pattern.compile("^(?i)[a-z_]+$");
    if (!patternLogin.matcher(login).find()) {
      System.out.println("Login is not valid");
      return;
    }
    if (!password.matches("^(?i)[0-9a-z]+$")) {
      System.out.println("Password is not valid");
      return;
    }

    if (!myMap.containsKey(login)) {
      myMap.put(login, password);
    }
  }

  public void printCollection() {
    System.out.println(myMap);
  }

  public void removeUser(String login) {
    String result = myMap.remove(login);
    if (result != null) {
      System.out.println("Deleted user: " + login);
    } else {
      System.out.println("The user does not exist");
    }
  }

}
