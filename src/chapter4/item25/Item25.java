package chapter4.item25;

class Utensil {
    static final String NAME = "pan";
}

class Dessert {
    static final String NAME = "cake";
}

public class Item25 {

    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
        /** 출력
         * pancake
         */

        // pancake 가 출력되었지만, 만약 Utensil 이나 Dessert 와 동일한 클래스명으로 다른 .java 파일에 정의된다면
        // 컴파일이 되지 않을 것이다.
    }
}
