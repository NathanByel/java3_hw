package com.java3.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private String name;
    private List<T> fruits;
    private float weight = 0;

    private void weightRound() {
        weight = Math.round(weight * 10) / 10f;
    }

    private void calcBoxWeight() {
        weight = 0;
        for(Fruit fruit : fruits) {
            weight += fruit.getWeight();
        }

        weightRound();
    }

    public Box(String name) {
        this.name = name;
        fruits = new ArrayList<>();
        System.out.println(name + ": создана");
    }

    public Box(String name, T[] fruits) {
        this(name);
        this.fruits.addAll(Arrays.asList(fruits));
        calcBoxWeight();
        printInfo();
    }

    public void add(T fruit) {
        fruits.add(fruit);
        weight += fruit.getWeight();
        weightRound();
        System.out.println(name + ": добавлен фрукт");
        printInfo();
    }

    public void addAll(List<T> fruits) {
        this.fruits.addAll(fruits);
        calcBoxWeight();
        System.out.println(name + ": добавлены фрукты - " + fruits.size());
        printInfo();
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
        weight -= fruit.getWeight();
        weightRound();
        if(weight < 0.0001) {
            weight = 0;
        }
        System.out.println(name + ": удален фрукт");
        printInfo();
    }

    public boolean remove() {
        T fruit = fruits.get(0);
        if(fruit != null) {
            remove(fruit);
            return true;
        }
        return false;
    }

    public void removeAll() {
        fruits.clear();
        weight = 0;
    }

    public void moveTo(Box<T> toBox) {
        toBox.addAll(fruits);
        removeAll();
        System.out.println(name + ": перемещены фрукты в \"" + toBox.getName() + "\"");
        printInfo();
    }

    public boolean compare(Box<?> anotherBox) {
        return weight == anotherBox.getWeight();
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public void printInfo() {
        System.out.println(name + ": фруктов-" + fruits.size() + ", вес-" + weight);
    }
}
