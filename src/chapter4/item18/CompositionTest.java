package chapter4.item18;

import java.util.*;

// 재사용할 수 있는 전달 클래스
class ForwardingSet<T> implements Set<T> {
    private final Set<T> s;
    public ForwardingSet(Set<T> s) {
        this.s = s;
    }

    @Override
    public int size() {
        return s.size();
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return s.iterator();
    }

    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return s.toArray(a);
    }

    public boolean add(T t) {
        return s.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return s.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    @Override
    public void clear() {
        s.clear();
    }
}

// 레퍼 클래스 - 상속 대신 컴포지션을 사용했다!
class InstrumentedHashSet2<T> extends ForwardingSet<T> {
    private int addCount;

    public InstrumentedHashSet2(Set<T> s) {
        super(s);
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

public class CompositionTest {

    public static void main(String[] args) {
        Set<String> ss = new HashSet<>();
        InstrumentedHashSet2<String> s = new InstrumentedHashSet2<>(ss);
        System.out.println(s.getAddCount());

        s.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(s.getAddCount());
        /** 출력
         * 0
         * addAll called
         * 3
         * -> 3 을 기대했고 3 이 나왔다.
         */
    }
}
