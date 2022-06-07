package chapter9.item59;

import java.util.List;
import java.util.Random;

public class Item59 {

    private static Random rnd = new Random();

    private static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {

        List<Integer> intList = List.of(1, 2, 3, 4, 5);

        // 선택한 범위에서 무작위 수를 백만개 생성한 다음, 그 중 중간 값보다 작은 게 몇 개 인지를 출력
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
        /** 출력
         * 666642
         *
         * 이상적으로 동작한다면 약 50만 개가 출력되어야 하지만, 실제로는 666.666 에 가까운 값을 얻는다.
         * 무작위로 생성된 수 중에서 2/3 가량이 중간값보다 낮은 쪽으로 쏠린 것이다.
         */
    }
}

