package chapter10.item69;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;


public class Item69 {

    public static void main(String[] args) {

        int range[] = new int[10];

        // 예외를 완전히 잘못 사용한 예 - 따라 하지 말 것!
        try {
            int i = 0;
            while (true)
                range[i++] = i;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.toString());
        }
    }
}

