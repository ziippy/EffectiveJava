## 5장 - 제네릭

### <아이템31 > 한정적 와일드카드를 사용해 API 유연성을 높여라 

> **(요약)** 조금 복잡하더라도 와일드카드 타입을 적용하면 API가 훨씬 유연해진다.

아이템28 에서도 말했듯이, 매개변수화 타입은 불공변(invariant)이다.

- 서로 다른 타입 Type1 과 Typ2 가 있을 때, List<Type1> 과 List<Type2>의 하위 타입도 상위 타입도 아니라는 것이다.
- List<String> 과 List<Object> 는?
  - String 이 Object 보다 작은 클래스이므로..List<String>은 List<Object> 의 하위 타입일 것 같지만
  - List<String> 문자열에 대해서만 할 수 있다.
  - 즉, List<String>은 List<Object> 가 하는 일을 제대로 수행하지 못하니 하위 타입이 될 수 없다. (리스코프 치환 원칙에 어긋남)

예를 들어, [Item31.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter5/item31/Item31.java) 기준으로 설명하면

```java
pushAll(Iterable<E> src)
이 있을 때

GenericStack<Number> stack = new GenericStack<>();
stack.pushAll(Iterable<Number> 변수); // 컴파일이 되나
stack.pushAll(Iterable<Integer> 변수); // 컴파일이 되지 않는다. 

Integer 가 Number 의 하위 타입임에도 불구하고 말이다.

pushAllWithWildcard(Iterable<? extends E> src)

이렇게 한정적 와일드카드 타입 을 이용해서 선언해야 된다.
```

Iterable<? extends E> 는
- E 의 하위 타입의 Iterable 을 받겠다는 뜻이다.

유연성을 극대화하려면 원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용하라.

<span style="color:skyblue">매개변수화 타입 T가 생산자라면 <? extends T>를 사용하고, 소비자라면 <? super T>를 사용하라.</span>
