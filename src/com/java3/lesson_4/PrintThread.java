package com.java3.lesson_4;

/*
    Синхронизация идет том же порядке, в котором создавались объекты.
*/
public class PrintThread extends Thread {
    private static final Object monitor = new Object();
    private static int maxSteps = 0;        // Общее количество потоков
    private static int currentStep = 0;     // Текуший поток для печати

    private Character charToPrint;          // Символ который будет печатать поток
    private int stepInSequence;             // Место в очереди среди других потоков

    public PrintThread(Character charToPrint) {
        this.charToPrint = charToPrint;
        this.stepInSequence = maxSteps;
        maxSteps++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                // Спим пока очередь не дошла до нас...
                while (currentStep != stepInSequence) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(charToPrint);
                currentStep++;
                if(currentStep >= maxSteps) {
                    currentStep = 0;
                }
                monitor.notifyAll();
            }
        }
    }
}
