package chatper2.item4;

class PrivateConstructor {
    private PrivateConstructor() { }

    public static int add(final int a, final int b) {
        return a + b;
    }
}

public class Item4 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //PrivateConstructor privateConstructor = new PrivateConstructor();   // 안된다.

        System.out.println(PrivateConstructor.add(a, b));
        /** 출력
         * 30
         */
    }
}
