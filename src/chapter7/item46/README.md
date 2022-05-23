## 7장 - 람다와 스트림

### <아이템46 > 스트림에서는 부작용 없는 함수를 사용하라 

> **(요약)** 스트림 파이프라인 프로그래밍의 핵심은 부작용 없는 함수 객체에 있다. 스트림뿐 아니라 스트림 관련 객체에 건네지는 모든 함수 객체가 부작용이 없어야 한다.

스트림은 그저 또 하나의 API가 아닌, 함수형 프로그래밍에 기초한 패러다임이다.

- 스트림이 제공하는 표현력, 속도, (상황에 따라서는) 병렬성을 얻으려면 API는 말할 것도 없고 이 패러다임까지 받아들여야 한다.

스트림 패러다임의 핵심

- 계산을 일련의 변환(transformation)으로 재구성하는 부분
- 이 때 각 변환 단계는 가능한 한 이전 단계의 결과를 받아 처리하는 순수 함수여야 한다.
- 즉, 스트림 연산에 건네는 함수 객체는 모두 부작용(side effect)이 없어야 한다.

```java
Map<String, Long> freq = new HashMap<>();
try (Stream<String> words = Arrays.stream(arr)) {
    words.forEach(word -> {
        freq.merge(word.toLowerCase(), 1L, Long::sum);      // forEach 에서 외부 상태를 수정하는 올바르지 않는 코드다.
    });
}

이건

Map<String, Long> freq = new HashMap<>();
try (Stream<String> words = Arrays.stream(arr)) {
    freq = words.collect(groupingBy(String::toLowerCase, counting()));     // 스트림 API를 제대로 사용
}

이렇게 짜야 스트림 API를 제대로 사용한 것이다.
```

- forEach 연산은 스트림 계산 결과를 보고할 때만 사용하고, 계산하는 데는 쓰지 말자.

위 코드는 수집기(collector)를 사용하는데, 스트림을 사용하려면 꼭 배워야 하는 개념이다.

- java.util.stream.Collectors 클래스는 메서드를 39개나 가지고 있다.
- 자세한 건 stream.Collectors 의 API 문서를 참고하기 바란다.

코드, [Item46.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter7/item46/Item46.java)
