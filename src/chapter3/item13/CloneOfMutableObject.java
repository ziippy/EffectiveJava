package chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "";
        this.age = 0;
    }

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person: %s(%d)", this.name, this.age);
    }
}

class Members extends Person implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private int DEFAULT_SIZE = 16;

    public Members() {
        this.elements = new Person[DEFAULT_SIZE];
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
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    @Override
    public Members clone() {
        try {
            return (Members) super.clone();
        } catch(CloneNotSupportedException e) {
            throw new AssertionError(); // 일어날 수 없는 일이다.
        }
    }
}

class MembersUsingGoodClone extends Person implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private int DEFAULT_SIZE = 16;

    public MembersUsingGoodClone() {
        this.elements = new Person[DEFAULT_SIZE];
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
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
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    @Override
    public MembersUsingGoodClone clone() {
        try {
            //return (Members) super.clone();   // 가변 객체에 대해서는 참조만 복사하므로 bad
            MembersUsingGoodClone m = (MembersUsingGoodClone) super.clone();
            m.elements = elements.clone();
            return m;
        } catch(CloneNotSupportedException e) {
            throw new AssertionError(); // 일어날 수 없는 일이다.
        }
    }
}

public class CloneOfMutableObject {

    public static void main(String[] args) {
        // 가변 객체를 가진 클래스의 clone 테스트 (bad case)
        Members m1 = new Members();
        m1.push(new Person("james", 20));
        m1.push(new Person("david", 21));

        Members m2 = m1.clone();

        System.out.println(m1.pop());
        System.out.println(m2.pop());       // m1.pop() 의 영향으로 여기서는 null 이 리턴된다.
        /** 출력
         * Person: david(21)
         * null
         */

        // 가변 객체를 가진 클래스의 clone 테스트 (good case)
        MembersUsingGoodClone m3 = new MembersUsingGoodClone();
        m3.push(new Person("james", 20));
        m3.push(new Person("david", 21));

        MembersUsingGoodClone m4 = m3.clone();

        System.out.println(m3.pop());
        System.out.println(m4.pop());       // m3.pop() 의 영향을 받지 않으므로, david(21) 이 출력된다.
        /** 출력
         * Person: david(21)
         * Person: david(21)
         */
    }
}
