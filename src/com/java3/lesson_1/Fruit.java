package com.java3.lesson_1;

import java.util.Random;

public abstract class Fruit {
    private String name;
    private float weight;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    protected void randomizeWeight() {
        weight += (new Random().nextInt(10) - 5) / 10f;
    }
}
