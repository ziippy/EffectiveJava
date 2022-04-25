package chapter4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// 잘못된 예 - 상속을 잘 못 사용했다!
class InstrumentedHashSet<T> extends HashSet<T> {
    private int addCount; // 추가된 원소의 수

    public InstrumentedHashSet() {

    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(T t) {
        System.out.println("add called");
        addCount++;
        return super.add(t);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        System.out.println("addAll called");
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

public class Item18 {

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(s.getAddCount());
        /** 출력
         * addAll called
         * add called
         * add called
         * add called
         * 6
         * -> 3 을 기대했는데 6 이 나왔다! 왜?? --> 이는 HashSet 의 addAll 메서드가 내부적으로는 add 를 사용하기 때문에 발생하는 것이다.
         */
    }
}
