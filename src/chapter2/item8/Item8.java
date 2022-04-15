package chapter2.item8;

import java.lang.ref.Cleaner;

// cleaner 를 안전망으로 활용하는 AutoCloseable 클래스
class Room implements AutoCloseable {

    private static class State implements Runnable {    // 청소가 필요한 자원. 절대 Room 을 참조해서는 안된다.
        int dummies;

        State(int dummies) {
            this.dummies = dummies;
        }

        // close 메서드나 cleaner 호출한다.
        @Override
        public void run() {
            System.out.println("청소 시작");
            this.dummies = 0;
        }
    }

    private static final Cleaner cleaner = Cleaner.create();

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int n) {
        state = new State(n);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}

public class Item8 {

    public static void main(String[] args) {

        // try-with-resource 블록으로 감싸서 잘 짜인 클라이언트 코드
        try (Room room = new Room(10)) {
            System.out.println("Room #1");
        };
        /** 출력
         * Room #1
         * 청소 시작
         */

        // 결코 방 청소를 하지 않는 다음 코드
        new Room(99);
        System.out.println("Room #2");
        /** 출력
         * Room #2
         */
    }
}
