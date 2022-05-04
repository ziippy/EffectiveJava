package chapter5.item28;

import java.util.*;

public class Item28 {

    public static void main(String[] args) {
        // 배열은 공변(covariant), 리스트는 불공변(invariant)

        // 배열은 런타임에 실패
        Object[] objectArray = new Long[1];
        objectArray[0] = "타입이 달라 넣을 수 없다.";     // 컴파일은 성공하나, 런타임 시 ArrayStoreException

        // 리스트는 컴파일부터 되지 않는다.
        //List<Object> ol = new ArrayList<Long>();    // 호환되지 않는다고 컴파일부터 안된다.
    }
}
