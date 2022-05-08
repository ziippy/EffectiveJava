package chapter5.item31;

import java.util.*;


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

    // 컴파일은 되나, 와일드카드 타입을 사용하지 않은 pushAll 메서드 - 결함이 있다.
    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // 컴파일은 되나, 와일드카드 타입을 사용하지 않은 popAll 메서드 - 결함이 있다.
    public void popAll(Collection<E> dst) {
        while(!isEmpty()) {
            dst.add(pop());
        }
    }

    // 한정적 와일드카드 타입을 이용한 pushAllWithWildcard
    public void pushAllWithWildcard(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // 한정적 와일드카드 타입을 이용한 popAllWithWildcard
    public void popAllWithWildcard(Collection<? super E> dst) {
        while(!isEmpty()) {
            dst.add(pop());
        }
    }
}

public class Item31 {

    public static void main(String[] args) {
        Number n[] = { 0, 1, 2, 3, 4 };
        Iterable<Number> in = Arrays.asList(n);

        Integer i[] = { 5, 6, 7, 8, 9 };
        Iterable<Integer> ii = Arrays.asList(i);

        GenericStack<Number> stack = new GenericStack<>();
        stack.pushAll(in);
        //stack.pushAll(ii);      // Integer 는 Number 의 하위 타입이므로 잘 동작해야 할 것 같지만, 컴파일 오류가 발생한다.
        /**
         * Required type:
         * Iterable
         * <Number>
         * Provided:
         * Iterable
         * <Integer>
         */

        List<Number> list = new ArrayList<>();
        stack.popAll(list);
        System.out.println(list);
        /** 출력
         * [4, 3, 2, 1, 0]
         */

        List<Object> list2 = new ArrayList<>();
        stack.pushAll(in);
        stack.pushAllWithWildcard(ii);  // 컴파일 된다.
        //stack.popAll(list2);      // 컴파일 오류가 발생한다.
        /**
         * Required type:
         * Collection
         * <Number>
         * Provided:
         * List
         * <Object>
         */
        stack.popAllWithWildcard(list2);  // 컴파일 된다.
        System.out.println(list2);
        /** 출력
         * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
         */
    }
}
