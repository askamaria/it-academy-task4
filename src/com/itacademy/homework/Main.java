package com.itacademy.homework;

import com.itacademy.homework.task.MyListClass;
import com.itacademy.homework.task.MyMapClass;
import com.itacademy.homework.task.MyQueueClass;
import com.itacademy.homework.task.MySetClass;
import com.itacademy.homework.task.MySetClass.Cargo;
import com.itacademy.homework.task.MySortingClass;

public class Main {

  public static void main(String[] args) {
    MyQueueClass myQueueClass = new MyQueueClass(10);
    myQueueClass.createQueue();
    myQueueClass.enterCabinet();
    myQueueClass.createRaceQueue();
    myQueueClass.removeElement();
    System.out.println("---------------------");

    MyListClass myListClass = new MyListClass();
    myListClass.addElementToList(2, 5);
    myListClass.addElementToList(7, 15);
    myListClass.addElementToList(12, 54);
    myListClass.addElementToList(20, 3);
    myListClass.printList();
    System.out.println(myListClass.readList());
    System.out.println("---------------------");

    myListClass.printList();
    myListClass.djenga();
    myListClass.printList();
    myListClass.djenga();
    myListClass.printList();
    myListClass.djenga();
    myListClass.printList();
    System.out.println("---------------------");

    MySetClass mySetClass = new MySetClass();
    mySetClass.addCard();
    mySetClass.addCargo();
    Cargo maxWeightCargo = mySetClass.ceiling();
    mySetClass.removeElement(maxWeightCargo);
    mySetClass.unloadCargo();
    System.out.println("---------------------");

    MyMapClass myMapClass = new MyMapClass();
    myMapClass.addUsers();
    myMapClass.removeUser("Cat.");
    myMapClass.removeUser("Cat");
    myMapClass.printCollection();
    myMapClass.addNewUser("Lion", "65_User");
    myMapClass.addNewUser("Lion%2", "65_Use");
    myMapClass.addNewUser("Lion2", "65_Use&");
    myMapClass.printCollection();
    System.out.println("---------------------");

    MySortingClass mySortingClass = new MySortingClass();
    mySortingClass.addPupil();
    mySortingClass.markSorted();
    mySortingClass.ageSorted();
  }
}
