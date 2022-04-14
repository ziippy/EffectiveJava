package chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

// 스택 클래스
class Stack {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];        // 여기서 잠재적인 메모리 누수가 있다.
    }

    public Object popWithoutMemoryLeak() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;          // 다 쓴 참조 해제
        return result;
    }
}

public class Item7 {

    public static void main(String[] args) {
        Stack s = new Stack();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(s.pop());
        }
        System.out.println("\n");

        // 메모리 누수 해결 버전
        Stack s2 = new Stack();
        for (int i = 0; i < 10; i++) {
            s2.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(s2.popWithoutMemoryLeak());
        }
    }
}
