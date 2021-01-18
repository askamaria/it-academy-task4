package com.itacademy.homework;

public class Caterpillar implements Movable {

    private String color;

    public Caterpillar(String color) {
        this.color = color;
    }

    public void eat() {
        System.out.println("The caterpillar is eating a leaf.");
    }

    public String getColor() {
        return color;
    }

    @Override
    public void toMove() {
        System.out.println("The caterpillar is moving");
    }
}
