## 7장 - 람다와 스트림

### <아이템44 > 표준 함수형 인터페이스를 사용하라 

> **(요약)** 이제 자바도 람다를 지원한다. 여러분도 지금부터는 API를 설계할 때 람다도 염두에 둬야 한다는 뜻이다. 입력값과 반환값에 함수형 인터페이스 타입을 활용하라.

자바가 람다를 지원하면서 API를 작성하는 모범 사례도 크게 바뀌었다.

예를 들어,

- 상위 클래스의 기본 메서드를 재정의해서 원하는 동작을 구현하던, 템플릿 메서드 패턴의 매력이 크게 줄었다.
- 이를 대체하는 현대적인 해법은
  - 같은 효과의 함수 객체를 받는 정적 팩터리나 생성자를 제공하는 것이다.

필요한 용도에 맞는 게 있다면, 직접 구현하지 말고 표준 함수형 인터페이스를 활용하라.

java.util.function 에는 총 43개의 인터페이스가 있다.

그 중에서 대표적인 6가지는 다음과 같다.

- UnaryOperator<T>
  - 함수 시그니처: T apply(T t)
  - 예: String::toLowerCase
- BinaryOperator<T>
  - 함수 시그니처: T apply(T t1, T t2)
  - 예: BigInteger::add
- Predicate<T>
  - 함수 시그니처: boolean test(T t)
  - 예: Collection::isEmpty
- Function<T,R>
  - 함수 시그니처: R apply(T t)
  - 예: Arrays.asList
- Supplier<T>
  - 함수 시그니처: T get()
  - 예: Instant::now
- Consumer<T>
  - 함수 시그니처: void accept(T t)
  - 예: System.out::println

기본 인터페이스는 기본 타입인 int, long, double 용으로 각 3개씩 변형이 생겨난다.

- ex: IntPredicate, LongPredicate, ...

표준 함수형 인터페이스를 사용할 수 없고, 직접 만드는 함수형 인터페이스를 사용해야 한다면  
반드시 @FunctionalInterface 어노테이션을 명시해줘라.

코드, [Item44.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter7/item44/Item44.java)
