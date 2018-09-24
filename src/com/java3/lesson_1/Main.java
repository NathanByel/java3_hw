package com.java3.lesson_1;

/*
    1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    2. Написать метод, который преобразует массив в ArrayList;

    3. Большая задача:
    Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
    Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

    Для хранения фруктов внутри коробки можно использовать ArrayList;
    Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
    (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);

    Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
    которую подадут в compare в качестве параметра, true – если она равны по весу,
    false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);

    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
    (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    Не забываем про метод добавления фрукта в коробку.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        System.out.println("Task 1");

        String[] test = { "a", "b", "c", "d"};
        System.out.println(Arrays.toString(test));

        swapArrayItems(test, 0, 3);
        System.out.println(Arrays.toString(test));

        System.out.println();
    }

    private static void swapArrayItems(Object[] array, int idx1, int idx2) {
        if(    (array == null)
            || (idx1 < 0)
            || (idx2 < 0)
            || (idx1 >= array.length)
            || (idx2 >= array.length) ) {
            return;
        }

        Object tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    private static void task2() {
        System.out.println("Task 2");

        Integer[] arr = {1, 2, 3, 4, 5};

        ArrayList<Integer> v = toList(arr);
        System.out.println(v);

        System.out.println();
    }

    private static <T> ArrayList<T> toList(T[] array) {
        return (ArrayList<T>) Arrays.asList(array);
    }

    /* Вариант
    private static <T> List<T> toList(T[] array) {
        return Arrays.asList(array);
    }
    */

    private static void task3() {
        System.out.println("Task 3");

        Box<Apple> boxA1 = new Box<>( "Коробка с яблоками 1", new Apple[] {new Apple(), new Apple(), new Apple()} );
        Box<Apple> boxA2 = new Box<>( "Коробка с яблоками 2", new Apple[] {new Apple(), new Apple()} );

        Box<Orange> boxO1 = new Box<>( "Коробка с апельсинами 1", new Orange[] {new Orange(), new Orange()} );

        boxA1.moveTo(boxA2);

        System.out.printf("Коробки \"%s\" и \"%s\" %s равны\r\n",
                boxA2.getName(), boxO1.getName(), (boxA2.compare(boxO1) ? "" : "не"));
    }
}
