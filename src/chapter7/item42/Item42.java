package chapter7.item42;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Item42 {

    public static void main(String[] args) {

        // 익명클래스의 인스턴스를 함수 객체로 사용 --> 낡은 기법이다!
        List<String> words = Arrays.asList("They", "see", "a", "movie");
        System.out.println(words);
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        /** 출력
         * [They, see, a, movie]
         * [a, see, They, movie]
         */

        // 람다식을 함수 객체로 사용 --> 익명 클래스를 대체할 수 있다!
        List<String> words2 = Arrays.asList("They", "see", "a", "movie");
        Collections.sort(words2, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words2);
        /** 출력
         * [a, see, They, movie]
         */

        // 람다식 대신 비교자 생성 메서드를 사용해서도 가능함
        List<String> words3 = Arrays.asList("They", "see", "a", "movie");
        Collections.sort(words3, comparingInt(String::length));
        System.out.println(words3);
        /** 출력
         * [a, see, They, movie]
         */

        // 자바8 에서는 List 인터페이스에 추가된 sort 메서드를 이용하면 더욱 짧아진다.
        List<String> words4 = Arrays.asList("They", "see", "a", "movie");
        words4.sort(comparingInt(String::length));
        System.out.println(words4);
        /** 출력
         * [a, see, They, movie]
         */
    }
}
