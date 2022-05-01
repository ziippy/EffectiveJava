package chapter4.item25;

public class Item25_with_static {

    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
        /** 출력
         * pancake
         */
    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}
