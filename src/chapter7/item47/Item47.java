package chapter7.item47;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Item47 {

    public static void main(String[] args) throws IOException {
        // 자바 타입 추론의 한계로 아래 코드는 컴파일 되지 않는다.
        /*
        for (ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
            ;
        }
         */

        // 몰론 형변환하면 되나, 끔찍한 우회 방법이다.
        for (ProcessHandle ph : (Iterable<? extends ProcessHandle>) ProcessHandle.allProcesses()::iterator) {
            ;
        }

        // 어댑터를 사용하면 상황이 나아진다.
        for (ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())) {

        }
    }

    private static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }
}

