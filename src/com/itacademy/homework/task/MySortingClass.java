package com.itacademy.homework.task;

import com.itacademy.homework.Pupil;
import com.itacademy.homework.comparator.AgeComparator;
import com.itacademy.homework.comparator.MarkComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySortingClass {

  private final List<Pupil> pupils = new ArrayList<>();

  public void addPupil() {
    addAndSort("Olga", 5, 15);
    addAndSort("Kirill", 10, 13);
    addAndSort("Nik", 6, 14);
    addAndSort("Alla", 7, 13);
    printPupils();
  }

  public void printPupils() {
    System.out.println(pupils);
  }

  private void addAndSort(String name, int mark, int age) {
    pupils.add(new Pupil(name, mark, age));
    Collections.sort(pupils);
  }

  public void markSorted() {
    pupils.sort(new MarkComparator());
    printPupils();
  }

  public void ageSorted() {
    pupils.sort(new AgeComparator());
    printPupils();
  }
}
