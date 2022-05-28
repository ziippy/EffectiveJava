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

public class Item50 {

    public static void main(String[] args) throws IOException {

        // Period 클래스는 얼핏 보기엔 불변 같지만.. Date 가 가변이라는 사실을 이용하면 어렵지 않게 그 불변식을 깨뜨릴 수 있다.
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        start.setYear(78);  // p의 내부를 수정했다.!!
    }
}

