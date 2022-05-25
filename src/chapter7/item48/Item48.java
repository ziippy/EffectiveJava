package chapter7.item48;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Item48 {

    public static void main(String[] args) throws IOException {

        final Long start = System.currentTimeMillis();

        // 스트림을 사용해 처음 20개의 메르센 소수를 생성하는 프로그램
        // 메르센 소수란 소수 가운데 '2의 n승 빼기 1'로 표현되는 소수를 말한다.
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);

        final Long end = System.currentTimeMillis();
        System.out.println("Time Elapsed : " + (end - start) + " ms");
        /** 출력
         * Time Elapsed : 7268 ms
         */

        // 그냥 아무 생각없이 .parallel() 을 추가하면?
        /*
        final Long start2 = System.currentTimeMillis();
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
        final Long end2 = System.currentTimeMillis();
        System.out.println("Time Elapsed : " + (end2 - start2) + " ms");
         */
        /** 출력
         * 아무것도 출력하지 못하면서 CPU는 90% 나 잡아먹는 상태가 무한히 계속된다.
         */

        // 이유는?
        // 스트림 라이브러리가 이 파이프라인을 병렬화하는 방법을 찾아내지 못했기 때문이다.


        ////////////// 스트림 파이프라인 병렬화가 효과를 제대로 발휘하는 간단한 예를 보자.
        // n 보다 작거나 같은 소수의 개수를 계산해보자

        double n = Math.pow(10, 8);

        // 그냥 하면
        final Long start3 = System.currentTimeMillis();
        long count = LongStream.rangeClosed(2, (long)n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
        final Long end3 = System.currentTimeMillis();
        System.out.printf("Prime Count: %d, Time Elapsed : %d ms\n", count, (end3 - start3));
        /** 출력
         * Prime Count: 5761455, Time Elapsed : 254824 ms
         * 6분 이상 걸렸다.
         */

        // 위 코드를 병렬화하면
        final Long start4 = System.currentTimeMillis();
        long count2 = LongStream.rangeClosed(2, (long)n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
        final Long end4 = System.currentTimeMillis();
        System.out.printf("Prime Count: %d, Time Elapsed using parallel : %d ms\n", count2, (end4 - start4));
        /** 출력
         * Prime Count: 5761455, Time Elapsed using parallel : 52551 ms
         * 대박~ 52초만에 끝났다!!
         */
    }

    private static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}

