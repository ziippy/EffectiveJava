## 9장 - 일반적인 프로그래밍 원칙

### <아이템62 > 다른 타입이 적절하다면 문자열 사용을 피하라

> **(요약)** 더 적합한 데이터 타입이 있거나 새로 작성할 수 있다면, 문자열을 쓰고 싶은 유혹을 뿌리쳐라.

문자열(String)은 텍스트를 표현하도록 설계되었고, 그 일을 아주 멋지게 해낸다.

그런데, 문자열은 워낙 흔하고 자바가 또 잘 지원해줘서 원래 의도하지 않는 용도로도 쓰이는 경향이 있다.

문자열을 쓰지 말아야 하는 사례

- 문자열은 다른 값 타입을 대신하기에 적절하지 않다.
- 문자열은 열거 타입을 대신하기에 적절하지 않다.
- 문자열은 혼합 타입을 대신하기에 적절하지 않다.
  - 차라리 전용 클래스를 새로 만드는 편이 낫다.
- 문자열은 권한을 표현하기에 적합하지 않다.

```java
// 혼합 타입을 문자열로 처리한 부적절한 예
String compoundKey = className + "#" + i.next();
```

각 요소를 개별로 접근하려면 문자열을 파싱해야 해서 느리고, 귀찮고, 오류 가능성도 커진다.

코드, [Item62.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter9/item62/Item62.java)
