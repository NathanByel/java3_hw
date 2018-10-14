package com.java3.lesson_7.Testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestingClass {
    private static Class testClass;
    private static Method beforeSuitMethod;
    private static Method afterSuitMethod;
    private static List<TestEntry> testsForRun;

    public static void start(String testClassName) {
        try {
            TestingClass.start( Class.forName(testClassName) );
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found by name!");
        }
    }

    public static void start(Class testClass) {
        TestingClass.testClass = testClass;
        testsForRun = new ArrayList<>();
        beforeSuitMethod = null;
        afterSuitMethod = null;

        findMethods();
        runMethods();
        System.out.println("All tests done!\r\n");
    }

    private static void findMethods() {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                // @BeforeSuite
                if(beforeSuitMethod == null) {
                    beforeSuitMethod = method;
                } else {
                    throw new RuntimeException("@BeforeSuite can be only one!");
                }
            } else if (method.getAnnotation(Test.class) != null) {
                // @Test
                testsForRun.add(new TestEntry(method.getAnnotation(Test.class).priority(), method));
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                // @AfterSuite
                if(afterSuitMethod == null) {
                    afterSuitMethod = method;
                } else {
                    throw new RuntimeException("@AfterSuite can be only one!");
                }
            }
        }
    }

    private static void runMethods() {
        testsForRun.sort(Comparator.comparingInt(o -> o.priority));

        try {
            Object instance = testClass.newInstance();
            if(beforeSuitMethod != null) {
                System.out.println("Run \"@BeforeTest\" method \"" + beforeSuitMethod.getName() + "\"");
                beforeSuitMethod.invoke(instance);
                System.out.println();
            }

            if (testsForRun.size() > 0) {
                for (TestEntry testEntry : testsForRun) {
                    System.out.println("Run \"@Test\" method \"" + testEntry.method.getName() + "\", priority " + testEntry.priority);
                    testEntry.method.invoke(instance);
                    System.out.println();
                }
            }

            if(afterSuitMethod != null) {
                System.out.println("Run \"@AfterTest\" method \"" + afterSuitMethod.getName() + "\"");
                afterSuitMethod.invoke(instance);
                System.out.println();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
