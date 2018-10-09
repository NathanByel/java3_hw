package com.java3.lesson_6;

import java.util.Arrays;

/*
    2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
       Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
       идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
       иначе в методе необходимо выбросить RuntimeException.
       Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

    3. Написать метод, который проверяет состав массива из чисел 1 и 4.
       Если в нем нет хоть одной четверки или единицы, то метод вернет false;
       Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Task 2");
        System.out.println(Arrays.toString( task2(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}) ));
        System.out.println(Arrays.toString( task2(new int[]{1, 2, 4, 4, 2, 3, 0, 1, 4}) ));
        System.out.println(Arrays.toString( task2(new int[]{4, 2, 1, 2, 2, 3, 0, 1, 7}) ));
        try {
            System.out.println(Arrays.toString(task2(new int[]{1, 2, 1, 2, 2, 3, 0, 1, 7})));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\r\nTask 3");
        System.out.println( task3(new int[]{0, 1, 2, 3}) );
        System.out.println( task3(new int[]{0, 0, 2, 3}) );
        System.out.println( task3(new int[]{4, 1, 2, 3}) );
        System.out.println( task3(new int[]{1, 2, 3, 4}) );
    }

    public static int[] task2(int[] array) {
        for (int i = array.length-1; i >= 0; --i) {
            if(array[i] == 4) {
                i++;
                int len = array.length - i;
                int[] result = new int[len];
                System.arraycopy(array, i, result, 0, len);
                return result;
            }
        }

        throw new RuntimeException("4 not found");
    }

    public static boolean task3(int[] array) {
        for (int i : array) {
            if(i == 1 || i == 4) {
                return true;
            }
        }
        return false;
    }
}
