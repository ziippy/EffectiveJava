## 3장 - 모든 객체의 공통 메서드

### <아이템14 > Comparable 을 구현할지 고려하라

> **(요약)** 순서를 고려해야 하는 값 클래스를 작성한다면 꼭 Comparable 인터페이스를 구현해야 한다.

Comparable 인터페이스의 유일무이한 메서드인 compareTo

compareTo 는 단순 동치성 비교에 더해 순서까지 비교할 수 있으며, 제네릭하다.

Comparable 을 구현했다는 것은 그 클래스의 인스턴스들에는 자연적인 순서(natural order)가 있음을 뜻한다.

사실상 자바 플랫폼 라이브러리의 모든 값 클래스와 열거타입(아이템34)이 Comparable 을 구현했다.

<span style="color:skyblue">순서가 명확한 값 클래스를 작성한다면 반드시 Comparable 인터페이스를 구현하자</span>

```java
public interface Comparable<T> {
    int compareTo(T t);
}
```

compareTo 메서드의 일반 규약은 equals 의 규약과 비슷하다.

- 이 객체와 주어진 객체의 순서를 비교한다.
- 이 객체가 주어진 객체보다 작으면 음의 정수를, 같으면 0을, 크면 양의 정수를 반환한다.
- 비교할 수 없는 객체 타입이면 ClassCastException 을 던진다.
- x.compareTo(y) == -(y.compareTo(x)) 여야 한다.
- x.compareTo(y) > 0 && y.compareTo(z) > 0 이면 x.compareTo(z) > 0 여야 한다. (추이성)
- x.compareTo(y) == 0 이면 x.compareTo(z) == y.compareTo(z) 여야 한다.
- x.compareTo(y) == 0 이면 x.equals(y) 도 true 여야 한다. (권장)

<span style="color:skyblue">비교를 활용하는 클래스의 예</span>

- 정렬된 컬렉션인 TreeSet, TreeMap
- 검색과 정렬 알고리즘을 활용한 유틸리티 클래스인 Collections, Arrays

코드: [Item14.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter3/item14/Item14.java)




