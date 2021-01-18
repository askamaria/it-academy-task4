package com.itacademy.homework;

public class HomoSapiens implements Movable {

    private String name;

    public HomoSapiens(String name) {
        this.name = name;
    }

    public void toEvolves() {
        System.out.println("Homo sapiens is evolves.");
    }

    public String getName() {
        return name;
    }

    @Override
    public void toMove() {
        System.out.println("Human steps feet");
    }
}
