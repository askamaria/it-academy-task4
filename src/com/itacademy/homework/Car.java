package com.itacademy.homework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class Car implements Movable {

    private String name;
    private int carNumber;
    private Calendar releaseDate;
    private CarModel carModel;
    private boolean isMoving;

    protected Car() {
    }

    protected Car(String name, int carNumber, Calendar releaseDate, CarModel carModel, boolean isMoving) {
        this.name = name;
        this.carNumber = carNumber;
        this.releaseDate = releaseDate;
        this.carModel = carModel;
        this.isMoving = isMoving;
    }

    protected void toStop() {
        isMoving = false;
    }

    public String getReleaseDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMMM-dd");
        String result = simpleDateFormat.format(releaseDate.getTime());
        return result;
    }

    public String getName() {
        return name;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carNumber == car.carNumber && isMoving == car.isMoving
                && name.equals(car.name) && releaseDate.equals(car.releaseDate) && carModel == car.carModel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carNumber, releaseDate, carModel, isMoving);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Car{")
                .append("name='")
                .append(name)
                .append('\'')
                .append(", carNumber=")
                .append(carNumber)
                .append(", releaseDate=")
                .append(releaseDate)
                .append(", carModel=")
                .append(carNumber)
                .append(", isMovable=")
                .append(isMoving)
                .append('}');
        return stringBuilder.toString();

    }
}
