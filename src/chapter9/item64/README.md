## 9장 - 일반적인 프로그래밍 원칙

### <아이템64 > 객체는 인터페이스를 사용해 참조하라

> **(요약)** 객체는 인터페이스를 사용해 참조하라. 없다면 가장 덜 구체적인(상위의) 클래스를 사용해라. 그것도 없으면 클래스를 참조해야 한다.

**적절한 인터페이스만 있다면 매개변수뿐 아니라 반환값, 변수, 필드를 전부 인터페이스 타입으로 선언하라.**

```java
// 좋은 예
Set<Son> sonSet = new LinkedHashSet<>();

// 나쁜 예
LinkedHashSet<Son> sonSet = new LinkedHashSet<>();
```

**인터페이스를 타입으로 사용하는 습관을 길러두면 프로그램이 훨씬 유연해질 것이다.**

적절한 인터페이스가 없다면 당연히 클래스로 참조해야 한다.

적절한 인터페이스가 없다면 계층구조 중 필요한 기능을 만족하는 가장 덜 구체적인(상위의) 클래스를 타입으로 사용하자.

코드, [Item64.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter9/item64/Item64.java)