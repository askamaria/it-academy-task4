package com.itacademy.homework.comparator;

import com.itacademy.homework.Pupil;
import java.util.Comparator;

public class AgeComparator implements Comparator<Pupil> {

  @Override
  public int compare(Pupil o1, Pupil o2) {
    return o2.getAge() - o1.getAge();
  }
}
