package com.java3.lesson_7;

import com.java3.lesson_7.Testing.AfterSuite;
import com.java3.lesson_7.Testing.BeforeSuite;
import com.java3.lesson_7.Testing.Test;
import com.java3.lesson_7.Testing.TestingClass;

/*
    Создать класс, который может выполнять «тесты». В качестве тестов выступают классы с наборами методов с
    аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
    передается или объект типа Class, или имя класса.
    Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется.
    Далее запущены методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.
    К каждому тесту необходимо добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет
    выбираться порядок их выполнения. Если приоритет одинаковый, то порядок не имеет значения.
    Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
    иначе необходимо бросить RuntimeException при запуске «тестирования».
*/
public class MainTest {

    public static void main(String[] args) {
        //TestingClass.start("com.java3.lesson_7.MainTest");
        TestingClass.start(MainTest.class);
    }

    @BeforeSuite
    public void before() {
        System.out.println("BeforeTest");
    }

    @AfterSuite
    public void after() {
        System.out.println("AfterTest");
    }

//    @AfterSuite
//    public void after1() {
//        System.out.println("AfterTest1");
//    }

//    @BeforeSuite
//    public void before1() {
//        System.out.println("BeforeTest1");
//    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 10)
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void test3() {
        System.out.println("test3");
    }

    @Test
    public void test4() {
        System.out.println("test4");
    }

    public void someMethod() {
        System.out.println("Some method was started!!!!!!!!!");
    }
}
