package chapter2.item6;

import java.util.regex.Pattern;

public class Item6 {

    public static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?c{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?c{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    public static boolean isRomanNumeralForPerformance(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        String s = new String("bikini"); // 절대 따라 하지 말 것!
        String s2 = "bikini"; // 이렇게 하나의 String 인스턴스를 사용해라.

        // 생성 비용이 비싼 객체를 반복해서 필요하다면 캐싱하여 재사용하길 권한다.
        // 예를 들어, isRomanNumeral 메서드는 로마 숫자인지를 확인하는 메서드이지만
        // String 의 matches 메서드는, 내부적으로 패턴을 만들어서 쓰고 버리므로.. 인스턴스 생성 비용이 높다.
        // 대신 패턴을 한번 만들어서 재사용하면 -> 성능을 개선할 수 있다. (isRomanNumeralForPerformance 메서드 참고)
        System.out.println(isRomanNumeral("IV"));
        System.out.println(isRomanNumeralForPerformance("IV"));

        //박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은 오토박싱이 숨어들지 않도록 주의하자.
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;   // 여기서 long 에서 Long 으로 auto-boxing 발생
        }
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed with auto-boxing : " + (end - start) + ", ===> " + sum);

        long start2 = System.currentTimeMillis();
        long sum2 = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum2 += i;   // 여기서 long 에서 Long 으로 auto-boxing 발생
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Time elapsed without auto-boxing : " + (end2 - start2) + ", ===> " + sum2);

        /** 출력
         * Time elapsed with auto-boxing : 5856, ===> 2305843008139952128
         * Time elapsed without auto-boxing : 714, ===> 2305843008139952128
         */
    }
}
