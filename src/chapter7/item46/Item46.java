package chapter7.item46;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Item46 {

    public static void main(String[] args) throws IOException {

        String[] arr = new String[]{"a", "b", "c", "a", "A", "b", "B", "a", "d", "d", "e"};

        // 스트림 패러다임을 이해하지 못한 채 API만 사용한 코드
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = Arrays.stream(arr)) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);      // forEach 에서 외부 상태를 수정하는 올바르지 않는 코드다.
            });
        }
        System.out.println(freq);
        /** 출력
         * {a=4, b=3, c=1, d=2, e=1}
         */

        // 스트림을 제대로 활용해 빈도표를 초기화
        Map<String, Long> freq2 = new HashMap<>();
        try (Stream<String> words = Arrays.stream(arr)) {
            freq2 = words.collect(groupingBy(String::toLowerCase, counting()));     // 스트림 API를 제대로 사용
        }
        System.out.println(freq2);
        /** 출력
         * {a=4, b=3, c=1, d=2, e=1}
         */

        // 빈도표에서 가장 흔한 단어 3개를 뽑아내는 파이프라인
        List<String> topTwo = freq2.keySet().stream()
                                .sorted(comparing(freq::get).reversed())
                                .limit(3)
                                .collect(toList());
        System.out.println(topTwo);
        /** 출력
         * [a, b, d]
         */

    }
}

