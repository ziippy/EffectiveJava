package chapter8.item54;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Item54 {

    private static final List<Integer> numbers = new ArrayList<>();

    // 컬렉션이 비었으면 null 을 리턴한다. - 따라 하지 말 것!
    private static List<Integer> getNumbers() {
        return numbers.isEmpty() ? null
                : new ArrayList<>(numbers);
    }

    // 컬렉션이 비었으면 빈 컬렉션을 리턴한다.
    private static List<Integer> getNumbersUsingEmpty() {
        return numbers.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(numbers);
    }

    public static void main(String[] args) {



    }
}

