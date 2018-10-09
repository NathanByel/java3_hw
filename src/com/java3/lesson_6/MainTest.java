package com.java3.lesson_6;

import static com.java3.lesson_6.Main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void task2Test() {
        int[] result;
        result = task2(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        assertArrayEquals(new int[]{1, 7}, result);

        result = task2(new int[]{1, 2, 4, 4, 2, 3, 0, 1, 4});
        assertArrayEquals(new int[]{}, result);

        result = task2(new int[]{4, 2, 1, 2, 2, 3, 0, 1, 7});
        assertArrayEquals(new int[]{2, 1, 2, 2, 3, 0, 1, 7}, result);

        assertThrows(RuntimeException.class, ()->{
            task2(new int[]{1, 2, 1, 2, 2, 3, 0, 1, 7});
        });
    }

    @Test
    public void task3Test() {
        assertTrue( task3(new int[]{0, 1, 2, 3}) );
        assertFalse( task3(new int[]{0, 0, 2, 3}) );
        assertTrue( task3(new int[]{4, 1, 2, 3}) );
        assertTrue( task3(new int[]{1, 2, 3, 4}) );
    }
}