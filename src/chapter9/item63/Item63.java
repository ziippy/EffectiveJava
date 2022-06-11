package chapter9.item63;



public class Item63 {

    public static void main(String[] args) {

        final long a = System.currentTimeMillis();
        System.out.println(a);
        System.out.println(statement());
        System.out.println(System.currentTimeMillis() - a);
        /** 출력
         * 62 ms
         */

        final long b = System.currentTimeMillis();
        System.out.println(b);
        System.out.println(statement2());
        System.out.println(System.currentTimeMillis() - b);
        /** 출력
         * 2 ms
         */
    }

    private static String statement() {
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += String.valueOf(i);
        }
        return result;
    }

    private static String statement2() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}

