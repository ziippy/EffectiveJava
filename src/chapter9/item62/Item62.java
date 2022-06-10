package chapter9.item62;

// 문자열을 키로 사용하는 클래스
class ThreadLocal {
    private ThreadLocal() {}    // 객체 생성 불가

    public static void set(String key, Object value) {

    }

    public static Object get(String key) {
        return null;
    }
}

public class Item62 {

    public static void main(String[] args) {

        // ThreadLocal 클래스는 스레드 구분용 문자열 키가 전역 이름공간에서 공유된다는 점이다.

        // 이 방식이 의도대로 동작하려면 각 클라이언트가 고유한 키를 제공해야 한다.
        // 만약 누군가 같은 키를 쓰면 의도치 않게 같은 변수를 공유하게 된다.

    }
}

