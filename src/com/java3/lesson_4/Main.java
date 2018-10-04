package com.java3.lesson_4;

/*
    1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
       Используйте wait/notify/notifyAll.
    2. На серверной стороне сетевого чата реализовать управление потоками через ExecutorService.
*/
public class Main {
    public static void main(String[] args) {
        new PrintThread('A').start();
        new PrintThread('B').start();
        new PrintThread('C').start();
    }
}
