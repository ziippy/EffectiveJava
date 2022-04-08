package chatper2;

import java.util.ArrayList;
import java.util.List;

// 전통적인 방식으로 클래스를 선언 후 API 를 정의한 Validator
class Validator {
    public boolean isPositive(final int number) {
        return number > 0 ? true : false;
    }
}

// 정적 팩터리 메서드가 있는 ValidatorWithStatic
class ValidatorWithStatic {
    public static boolean isPositive(final int number) {
        return number > 0 ? true : false;
    }
}

//////////////////////////////////////////////// 하위 타입 객체 반환 테스트를 위한 클래스들
class Medal {
    public static Medal of(final int position) {
        switch (position) {
            case 1: return new GoldMedal();
            case 2: return new SilverMedal();
            case 3: return new BronzeMedal();
            default: return new NoMedal();
        }
    }
}

class GoldMedal extends Medal {
    @Override public String toString() { return "GoldMedal"; }
}

class SilverMedal extends Medal {
    @Override public String toString() { return "SilverMedal"; }
}

class BronzeMedal extends Medal {
    @Override public String toString() { return "BronzeMedal"; }
}

class NoMedal extends Medal {
    @Override public String toString() { return "NoMedal"; }
}

//////////////////////////////////////////////// 정적 팩터리 메서드만 제공하는 Base 클래스를 상속받으려는 클래스
class Base {
    private Base() {}
    public static int valueOf(final int value) {
        return value;
    }
}

// 아래 줄 처럼 정의하려고 하면, 오류가 발생한다. -> There is no default constructor available in 'chatper2.Base'
// class MyBase extends Base {}

public class Item1 {

    public static void main(String[] args) {
        final int number = 99;

        // Validator 클래스 이용 시
        Validator validator = new Validator();
        System.out.println("The number is positive (with Validator) : " + validator.isPositive(number));

        // ValidatorWithStatic 클래스 이용 시
        System.out.println("The number is positive (with ValidatorWithStatic) : " + ValidatorWithStatic.isPositive(number));

        /**
         * 출력
         * The number is positive (with Validator) : true
         * The number is positive (with ValidatorWithStatic) : true
         */

        // 하위 자료형 객체 반환 하는 지 테스트
        final int position1 = 1;
        System.out.println(Medal.of(position1).toString());
        final int position2 = 2;
        System.out.println(Medal.of(position2).toString());
        final int position3 = 3;
        System.out.println(Medal.of(position3).toString());
        final int position99 = 99;
        System.out.println(Medal.of(position99).toString());

        /** 출력
         * GoldMedal
         * SilverMedal
         * BronzeMedal
         * NoMedal
         */
    }
}
