package com.java3.lesson_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race {
    private int totalCars;
    private CountDownLatch startLine;
    private CountDownLatch finishLine;
    private CountDownLatch startLights;
    private ArrayList<Stage> stages;

    public Race(int totalCars, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.totalCars = totalCars;
        startLine = new CountDownLatch(totalCars);
        finishLine = new CountDownLatch(totalCars);
        startLights = new CountDownLatch(1);
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void carReadyToGo() {
        startLine.countDown();
    }

    public void awaitToStart() {
        try {
            startLights.await();
        } catch (InterruptedException e) {
        }
    }

    public void start() {
        startLights.countDown();
    }

    public void carFinishTheRace() {
        finishLine.countDown();
    }

    public boolean carIsWinner() {
        return finishLine.getCount() == totalCars - 1;
    }

    public void awaitAllCars() {
        try {
            startLine.await();
        } catch (InterruptedException e) {
        }
    }

    public void awaitAllFinish() {
        try {
            finishLine.await();
        } catch (InterruptedException e) {
        }
    }
}