package chapter10.item76;


import java.util.EmptyStackException;

public class Item76 {

    private static int size = 0;

    public static void main(String[] args) {


    }

    private Object pop() {
        // 이런식으로 유효성을 검사하여 가변 객체의 메서드를 실패 원자적으로 만들 수 있다.
        if (size == 0)
            throw new EmptyStackException();
        // ...
        return null;
    }
}

