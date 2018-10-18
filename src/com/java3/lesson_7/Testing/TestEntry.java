package com.java3.lesson_7.Testing;

import java.lang.reflect.Method;

public class TestEntry {
    public int priority;
    public Method method;

    public TestEntry(int priority, Method method) {
        this.priority = priority;
        this.method = method;
    }
}
