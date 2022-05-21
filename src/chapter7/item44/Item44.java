package chapter7.item44;

import java.util.HashMap;
import java.util.Map;

public class Item44 {

    public static void main(String[] args) {

        String s = "AbCdEf";
        String s2 = s.transform(String::toLowerCase);
        System.out.println(s);
        System.out.println(s2);
        /** 출력
         * AbCdEf
         * abcdef
         */
    }
}

