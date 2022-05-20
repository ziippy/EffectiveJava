## 7장 - 람다와 스트림

### <아이템43 > 람다보다는 메서드 참조를 사용하라 

> **(요약)** 메서드 참조 쪽이 짧고 명확하다면 메서드 참조를 쓰고, 그렇지 않을 때만 람다를 사용하라.

람다가 익명 클래스보다 나은 점 중에서 가장 큰 특징은 **간결함**이다.

그런데 자바에는 함수 객체를 더 간결하게 만드는 방법이 있으니 -> **메서드 참조(method reference)** 다.

예를 들면

```java
map.merge(key, 1, (count, incr) -> count + incr);

이건

map.merge(key, 1, Integer::sum);

이렇게 메서드 참조를 이용해서도 가능하다.
```

람다가 할 수 없는 일이라면 메서드 참조로도 할 수 없다.

코드, [Item43.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter7/item43/Item43.java)
