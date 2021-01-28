package com.itacademy.homework.comparator;

import com.itacademy.homework.Pupil;
import java.util.Comparator;

public class MarkComparator implements Comparator<Pupil> {

  @Override
  public int compare(Pupil o1, Pupil o2) {
    return o1.getMark() - o2.getMark();
  }
}
