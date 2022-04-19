package chapter3.item11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
class BodyInfo {
    private final int age, weight, tall;

    public BodyInfo(int age, int weight, int tall) {
        this.age = age;
        this.weight = weight;
        this.tall = tall;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BodyInfo)) {
            return false;
        }
        BodyInfo tmp = (BodyInfo) o;
        return this.age == tmp.age && this.weight == tmp.weight && this.tall == tmp.tall;
    }
}

class BodyInfoExtend extends BodyInfo {

    public BodyInfoExtend(int age, int weight, int tall) {
        super(age, weight, tall);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(super.getAge());
        result = 31 * result + Integer.hashCode(super.getWeight());
        result = 31 * result + Integer.hashCode(super.getTall());
        return result;
    }
}

public class Item11 {

    public static void main(String[] args) {
        // 값이 같아서 equals 는 true 지만, 객체 주소는 다르므로 == 는 false 를 리턴하는 경우
        BodyInfo bi1 = new BodyInfo(10, 100, 180);
        BodyInfo bi2 = new BodyInfo(10, 100, 180);
        System.out.println(bi1.equals(bi2));
        System.out.println(bi1.hashCode());
        System.out.println(bi2.hashCode());     // bi1 의 hashCode 와 bi2 의 hashCode 값이 다르다.
        System.out.println(bi1 == bi2);
        /** 출력
         * true
         * 1096979270
         * 1078694789
         * false
         */

        // 이를 map 에 담아보자.
        Map<BodyInfo, String> map = new HashMap<>();
        map.put(new BodyInfo(10, 100, 180), "james");

        String s = map.get(new BodyInfo(10, 100, 180));
        System.out.println(s);  // "james" 를 리턴할 것으로 기대했지만, null 을 리턴한다.
        /** 출력
         * null
         */

        // 값이 같아서 equals 는 true 지만, 객체 주소는 다르므로 == 는 false 를 리턴하는 경우
        BodyInfoExtend bi3 = new BodyInfoExtend(10, 100, 180);
        BodyInfoExtend bi4 = new BodyInfoExtend(10, 100, 180);
        System.out.println(bi3.equals(bi4));
        System.out.println(bi3.hashCode());
        System.out.println(bi4.hashCode());     // bi3 과 bi4 의 hashCode 값이 같다.
        System.out.println(bi3 == bi4);         // 하지만 다른 객체이므로 identity 는 만족하지 않는다.
        /** 출력
         * true
         * 12890
         * 12890
         * false
         */

        // 이를 map 에 담아보자.
        Map<BodyInfoExtend, String> map2 = new HashMap<>();
        map2.put(new BodyInfoExtend(10, 100, 180), "james");

        String s2 = map2.get(new BodyInfoExtend(10, 100, 180));
        System.out.println(s2);  // hashCode 가 동일한 "james" 를 리턴한다
        /** 출력
         * james
         */
    }
}
