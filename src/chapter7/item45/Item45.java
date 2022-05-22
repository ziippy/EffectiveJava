package chapter7.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Item45 {

    public static void main(String[] args) throws IOException {

        Path directory = Paths.get(".");
        int minGroupSize = 10;

        // 스트림을 과하게 사용했다. - 따라하지 말자
        try (Stream<String> words = Files.lines(directory)) {
            words.collect(
                    groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new, (sb, c) -> sb.append((char) c),
                                    StringBuilder::append).toString())
            ).values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }

        // 스트림을 적절히 활용하면 깔끔하고 명료해진다.
        try (Stream<String> words = Files.lines(directory)) {
            words.collect(groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}

