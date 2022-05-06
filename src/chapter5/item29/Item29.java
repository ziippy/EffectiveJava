package chapter5.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

// Object 기반 스택 - 제네릭이 절실한 강력 후보!
class Stack {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;  // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

// 제네릭 기반의 스택
class GenericStack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public GenericStack() {
        //elements = new E[DEFAULT_INITIAL_CAPACITY]; // 컴파일이 안된다.
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];  // 컴파일은 되나, (일반적으로) 타입 안전하지 않다.
    }

    public void push(E o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;  // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}


public class Item29 {

    public static void main(String[] args) {
        String s = "sample";

        Stack stack = new Stack();
        stack.push((Object)s);
        System.out.println(stack.pop());
        /** 출력
         * sample
         */

        GenericStack<String> stack2 = new GenericStack<>();
        stack2.push(s);
        System.out.println(stack2.pop());
        /** 출력
         * sample
         */
    }
}
