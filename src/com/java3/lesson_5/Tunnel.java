package com.java3.lesson_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore tunnelPlace;

    public Tunnel(int maxCars) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        tunnelPlace = new Semaphore(maxCars);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tunnelPlace.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tunnelPlace.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}