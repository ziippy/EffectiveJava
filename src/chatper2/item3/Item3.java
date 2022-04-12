package chatper2.item3;

// public static final 필드 방식의 싱글턴
// 장점: 해당 클래스가 싱글턴임이 API 에 명백히 들어난다.
//       간결함
class Single {
    public static final Single INSTANCE = new Single();
    private Single() { }

    public void print() {
        System.out.println("singleton");
    }
}

// 정적 팩터리 방식의 싱글턴
// 장점: API 를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다는 점
//      원한다면 정적 팩터리를 제너릭 싱글턴 팩터리로 만들 수 있다는 점
//      정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다는 점
class SingleByGetInstance {
    private static final SingleByGetInstance INSTANCE = new SingleByGetInstance();
    private SingleByGetInstance() { }

    public static SingleByGetInstance getInstance() { return INSTANCE; }

    public void print() {
        System.out.println("singleton");
    }
}

// 원소가 하나인 열거 타입을 선언
enum SingleByEnum {
    INSTANCE;

    public void print() {
        System.out.println("singleton");
    }
}

public class Item3 {

    public static void main(String[] args) {
        Single single = Single.INSTANCE;
        Single single2 = Single.INSTANCE;
        System.out.println(single.equals(single2));
        single.print();
        /** 출력
         * true
         * singleton
         */

        SingleByGetInstance single3 = SingleByGetInstance.getInstance();
        SingleByGetInstance single4 = SingleByGetInstance.getInstance();
        System.out.println(single3.equals(single4));
        single3.print();
        /** 출력
         * true
         * singleton
         */

        SingleByEnum single5 = SingleByEnum.INSTANCE;
        SingleByEnum single6 = SingleByEnum.INSTANCE;
        System.out.println(single5.equals(single6));
        single5.print();
        /** 출력
         * true
         * singleton
         */
    }
}
