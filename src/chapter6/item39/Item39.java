package chapter6.item39;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//@Retention(RetentionPolicy.RUNTIME)     // @Test 가 RUNTIME 시에도 유지되어야 한다.
//@Target(ElementType.METHOD)             // @Test 가 반드시 메서드 선언에서만 사용되어야 한다.

class Sample {
    @Test
    public static void m1() { }

    public static void m2() { }

    @Test
    public static void m3() {
        throw new RuntimeException("실패");
    }

    @Test
    public void m4() { }
}


public class Item39 {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Sample.class; // Class.forName("Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                    System.out.println(m + " 성공");
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " 실패: " + exc);
                } catch (Exception exc) {
                    System.out.println("잘못 사용한 @Test: " + m);
                }
            }
        }

        System.out.printf("성공: %d, 실패: %d\n", passed, tests - passed);
        /** 출력
         * public static void chapter6.item39.Sample.m1() 성공
         * public static void chapter6.item39.Sample.m3() 실패: java.lang.RuntimeException: 실패
         * 잘못 사용한 @Test: public void chapter6.item39.Sample.m4()
         * 성공: 1, 실패: 2
         */
    }
}
