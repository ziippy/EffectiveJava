## 3장 - 모든 객체의 공통 메서드

### <아이템10 > equals 는 일반 규약을 지켜 재정의하라

> **(요약)** 꼭 필요한 경우가 아니면 equals 를 재정의하지 말자.

equals 메서드는 재정의하기 쉬워 보이지만 곳곳에 함정이 도사리고 있어서 자칫하면 끔찍한 결과를 초래한다.

<span style="color:skyblue">다음에 열겨한 상황 중 하나에 해당한다면 재정의하지 않는 것이 최선이다.</span>

- 각 인스턴스가 본질적으로 고유하다. (값이 아니라 동작을 표현하는 클래스)<br>
  (값 클래스란 Integer, String 처럼 값을 표현하는 클래스를 말함)
- 인스턴스의 '논리적 동치성(logical equality)'을 검사할 일이 없다.
- 상위 클래스에서 재정의한 equals 가 하위 클래스에도 딱 들어맞는다.
- 클래스가 private 이거나 package-private 이고 equals 메서드를 호출할 일이 없다.

<span style="color:skyblue">equals 가 실수로 호출되는 것을 막고 싶으면 아래와 같이 구현해두면 된다.</span>

```java
@Override
public boolean equals(Object o) {
  throw new AssertionError();
}
```

<span style="color:skyblue">equals 메서드를 재정의할 때 따라야 하는 일반 규약</span>

- 반사성(reflexivity): null 이 아닌 모든 참조 값 x에 대해, x.equals(x) 는 true
- 대칭성(symmetry): null 이 아닌 모든 참조 값 x, y에 대해, x.equals(y) 가 true 면 그 반대도 true
- 추이성(transitivity): null 이 아닌 모든 참조 값 x, y, z 에 대해, x.equals(y) 가 true 이고 y.equals(z) 가 true 이면 x.equals(z) 도 true
- 일관성(consistency): null 이 아닌 모든 참조 값 x, y 에 대해, x.equals(y) 를 반복해서 호출해도 늘 같은 값을 반환
- null-아님: null 이 아닌 모든 참조 값 x 에 대해, x.equals(null) 은 false

equals 규약을 어기면 그 객체를 사용하는 다른 객체들이 어떻게 반응할 지 알 수 없다.

<br>

<span style="color:skyblue">**양질의 equals 메서드 구현 방법을 단계별로 정리**</span>

1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다. <br>
  자기 자신이면 true 를 반환
2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
3. 입력을 올바른 타입으로 형변환한다.
4. 입력 객체와 자기 자신의 대응되는 '핵심'필드들이 모두 일치하는지 하나씩 검사한다.

<span style="color:skyblue">equals 를 다 구현했다면, 세 가지만 자문해보자.</span>

대칭적인가?<br>
추이성이 있는가?<br>
일관적인가?

<span style="color:skyblue">**마지막 주의사항**</span>

- equals 를 재정의할 땐 hashCode 도 반드시 재정의하자.
- 너무 복잡하게 해결하려 들 지 말자.
- Object 외의 타입을 매개변수로 받는 equals 메서드는 선언하지 말자.<br>
  Object 타입이 아니면 오버라이딩이 아니라 오버로딩이다.

코드: [Item10.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter3/item10/Item10.java)




