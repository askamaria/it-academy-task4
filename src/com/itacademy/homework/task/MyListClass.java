package com.itacademy.homework.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyListClass {

  private final List<Integer> myList = new ArrayList<>();
  private final List<Integer> djengaList = new ArrayList<>();

  public void addElementToList(int firstElement, int lastElement) {
    myList.add(0, firstElement);
    myList.add(lastElement);
  }

  public void printList() {
    System.out.println(myList);
  }

  public List<Integer> readList() {
    List<Integer> newList = new ArrayList<>(myList.size());
    for (int i = 0; i < myList.size() / 2; i++) {
      int element = myList.get(myList.size() - 1 - i);
      newList.add(element);
      element = myList.get(i);
      newList.add(element);
    }
    return newList;
  }

  public void djenga() {
    Random random = new Random();
    int index = random.nextInt(myList.size() - 2) + 1;
    int randomElement = myList.remove(index);
    myList.add(randomElement);
  }
}
