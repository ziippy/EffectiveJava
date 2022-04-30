package chapter4.item22;

// 상수 인터페이스만 가지고 있는 안티패턴 ---- 사용 금지!!
interface PriceLevel {
    static final double HIGH = 555.555;
    static final double MEDIUM = 333.333;
    static final double LOW = 111.111;
}

class PriceLevelWrap implements PriceLevel {
    public void call() {
        System.out.println(HIGH);
    }
}

// 대신, 상수 유틸리티 클래스를 이용해라.
class PriceLevel2 {
    private PriceLevel2() {} // 인스턴스화 방지
    static final double HIGH = 666.111;
    static final double MEDIUM = 444.111;
    static final double LOW = 222.111;
}

public class Item22 {

    public static void main(String[] args) {
        System.out.println(PriceLevel.HIGH);
        /** 출력
         * 555.555
         */

        System.out.println(PriceLevel2.HIGH);
        /** 출력
         * 666.111
         */
    }
}
