package chapter8.item50;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

// 기간을 표현하는 클래스 - 불변식을 지키지 못했다.
class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}

class Period2 {
    private final Date start;
    private final Date end;

    // 수정한 생성자 - 매개변수의 방어적 복사본을 만든다.
    public Period2(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
        }
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}

class Period3 {
    private final Date start;
    private final Date end;

    // 수정한 생성자 - 매개변수의 방어적 복사본을 만든다.
    public Period3(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
        }
    }

    // 수정한 접근자 - 필드의 방어적 복사본을 반환한다.
    public Date start() {
        return new Date(start.getTime());
    }

    // 수정한 접근자 - 필드의 방어적 복사본을 반환한다.
    public Date end() {
        return new Date(end.getTime());
    }
}

public class Item50 {

    public static void main(String[] args) throws IOException {

        // Period 클래스는 얼핏 보기엔 불변 같지만.. Date 가 가변이라는 사실을 이용하면 어렵지 않게 그 불변식을 깨뜨릴 수 있다.
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        System.out.println(p.start() + " " + p.end());
        start.setYear(78);  // p의 내부를 수정했다.!!
        System.out.println(p.start() + " " + p.end());
        /** 출력
         * Sat May 28 12:32:54 KST 2022 Sat May 28 12:32:54 KST 2022
         * Sun May 28 12:32:54 KST 1978 Sat May 28 12:32:54 KST 2022
         */

        Date start2 = new Date();
        Date end2 = new Date();
        Period2 p2 = new Period2(start2, end2);
        System.out.println(p2.start() + " " + p2.end());
        start2.setYear(78);  // p2의 내부가 수정되지 않는다.!!
        System.out.println(p2.start() + " " + p2.end());
        /** 출력
         * Sat May 28 12:40:05 KST 2022 Sat May 28 12:40:05 KST 2022
         * Sat May 28 12:40:05 KST 2022 Sat May 28 12:40:05 KST 2022
         */

        p2.start().setYear(78);  // p2의 내부가 수정된다.!!
        System.out.println(p2.start() + " " + p2.end());
        /** 출력
         * Sun May 28 12:40:05 KST 1978 Sat May 28 12:40:05 KST 2022
         */

        Date start3 = new Date();
        Date end3 = new Date();
        Period3 p3 = new Period3(start3, end3);
        System.out.println(p3.start() + " " + p3.end());
        start3.setYear(78);  // p3의 내부가 수정되지 않는다.!!
        System.out.println(p3.start() + " " + p3.end());
        /** 출력
         * Sat May 28 12:43:14 KST 2022 Sat May 28 12:43:14 KST 2022
         * Sat May 28 12:43:14 KST 2022 Sat May 28 12:43:14 KST 2022
         */

        p3.start().setYear(78);  // p3의 내부가 수정되지 않는다.!!
        System.out.println(p3.start() + " " + p3.end());
        /** 출력
         * Sat May 28 12:43:14 KST 2022 Sat May 28 12:43:14 KST 2022
         */
    }
}

