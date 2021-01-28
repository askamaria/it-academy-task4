package com.itacademy.homework.task;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MyQueueClass {

  private final int count;
  private final Deque<String> people;
  private Deque<String> peopleRace;

  public MyQueueClass(int count) {
    this.people = new ArrayDeque<>(count);
    this.peopleRace = new ArrayDeque<>(count);
    this.count = count;
  }

  public void createQueue() {
    for (int i = 1; i <= count; i++) {
      people.offer("Man-" + i);
    }
    System.out.println(people);
  }

  public void enterCabinet() {
    for (int i = 1; i <= count; i++) {
      String man;
      if (i % 3 == 0) {
        man = people.pollLast();
      } else {
        man = people.pollFirst();
      }
      System.out.println(man);
    }
  }

  public void createRaceQueue() {
    for (int i = 1; i <= count; i++) {
      peopleRace.offer("Guy-" + i);
    }
    System.out.println("Created queue: " + peopleRace);
  }

  private void sortRaceQueue() {
    List<String> sortRaceList = new ArrayList<>(peopleRace);
    Collections.shuffle(sortRaceList);
    peopleRace = new ArrayDeque<>(sortRaceList);
    System.out.println("Sorted queue: " + peopleRace);
  }

  public void removeElement() {
    while (peopleRace.peek() != null) {
      sortRaceQueue();
      String guy = peopleRace.pollLast();
      System.out.println(guy);
    }
    System.out.println("All elements were deleted " + peopleRace);
  }

}
