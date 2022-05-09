## 5장 - 제네릭

### <아이템32 > 제네릭과 가변인수를 함께 쓸 때는 신중하라 

> **(요약)** 가변인수와 제네릭은 궁합이 좋지 않다. 메서드에 제네릭 varargs 매개변수를 사용하고자 한다면, 먼저 그 메서드가 타입 안전한지 확인한 다음 @SafeVarargs 어노테이션을 달아 사용하는 데 불편함이 없게끔 하자.

가변인수(varargs) 메서드와 제네릭은 자바 5 때 함께 추가되었으니 서로 잘 어우러지리라 기대하겠지만, 슬프게도 그렇지 않다.

가변인수 메서드를 호출하면

- 가변인수를 담기 위한 배열이 자동으로 하나 만들어진다.
- 그런데, 내부로 감춰야 했을 이 배열을 그만 클라이언트에 노출하는 문제가 생겼다.
- 그 결과 varargs 매개변수에 제네릭이나 매개변수화 타입이 포함되면 알기 어려운 컴파일 경고가 발생한다.

```java
public static void dangerous(List<String>... stringLists) {
    List<Integer> intList = List.of(42);
    Object[] objects = stringLists;
    objects[0] = intList;                   // 힙 오염 발생
    String s = stringLists[0].get(0);       // ClassCastException 발생
}

List<String> stringList1 = List.of("Hello");
List<String> stringList2 = List.of("World");

dangerous(stringList1, stringList2);
```

이처럼 타입 안정성이 깨지니, **제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다.**

코드, [Item32.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter5/item32/Item32.java)