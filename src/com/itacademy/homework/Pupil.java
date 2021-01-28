package com.itacademy.homework;

public class Pupil implements Comparable<Pupil> {

  private final String name;
  private final int mark;
  private final int age;

  public Pupil(String name, int mark, int age) {
    this.name = name;
    this.mark = mark;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getMark() {
    return mark;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int compareTo(Pupil o) {
    return this.name.compareTo(o.name);
  }

  @Override
  public String toString() {
    return "Pupil{" +
        "name='" + name + '\'' +
        ", mark=" + mark +
        ", age=" + age +
        '}';
  }
}
