package com.java3.lesson_1;

public class Apple extends Fruit {
    public static final float AVG_WEIGHT = 1.0f;

    public Apple(float weight) {
        super("Яблоко", weight);
    }

    public Apple() {
        this(AVG_WEIGHT);
        randomizeWeight();
    }
}
