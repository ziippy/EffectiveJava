package chapter4.item19;

import java.time.Instant;

class Super {

    // 잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Super - overrideMe");
    }
}

class Sub extends Super {
    private final Instant instant;

    Sub() {
        this.instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }
}

public class Item19 {

    public static void main(String[] args) {
        Sub s = new Sub();
        s.overrideMe();
        /** 출력
         * null
         * 2022-04-20T15:06:31.614122Z
         * -> 첫 번째 출력은 null 을 출력한다. 이는 상위 클래스의 생성자는 하위 클래스의 생성자가 인스턴스 필드를 초기화하기도 전에 overrideMe 를 호출하기 때문이다.
         */
    }
}
