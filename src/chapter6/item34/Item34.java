package chapter6.item34;

import java.util.HashMap;
import java.util.Map;


public class Item34 {

    // 정수 열거 패턴 - 상당히 취약하다!
    public static int APPLE_FUJI = 0;
    public static int APPLE_PIPPIN = 1;
    public static int ORANGE_NAVEL = 0;
    public static int ORANGE_TEMPLE = 1;

    // 가장 단순한 열거 타입
    public enum Apple { FUJI, PIPPIN }
    public enum Orange { NAVEL, TEMPLE }

    public static void main(String[] args) {
        int i = APPLE_FUJI - ORANGE_NAVEL;      // 이게 되버린다.
        System.out.println(i);
        /** 출력
         * 0
         */

        //int j = Apple.FUJI - Orange.NAVEL;      // 컴파일 오류가 발생한다.
        /**
         * Operator '-' cannot be applied to 'chapter6.item34.Item34.Apple', 'chapter6.item34.Item34.Orange'
         */
    }
}
