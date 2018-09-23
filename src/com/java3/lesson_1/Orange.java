package com.java3.lesson_1;

public class Orange extends Fruit {
    public static final float AVG_WEIGHT = 1.5f;

    public Orange(float weight) {
        super("Апельсин", weight);
    }

    public Orange() {
        this(AVG_WEIGHT);
        randomizeWeight();
    }
}
