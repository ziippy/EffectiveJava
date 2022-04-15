## 2장 - 객체 생성과 파괴

### <아이템8 > finalizer 와 cleaner 사용을 피하라

> **(요약)** cleaner(자바8 까지는 finalizer)는 안전망 역할이나, 중요하지 않은 네이티브 자원 회수용으로만 사용하자. 물론 이런 경우라도 불확실성과 성능 저하에 주의해야 한다.

<span style="color:skyblue">자바는 두 가지 객체 소멸자를 제공</span>

- finalizer <br>
  예측할 수 없고, 상황에 따라 위험할 수 있어 일반적으로 불필요하다.
- cleaner <br>
  자바9에서 나온 것이다. finalizer 보다는 덜 위험하지만, 여전히 예측할 수 없고, 느리고, 일반적으로 불필요하다.

이유?

<span style="color:skyblue">**finalizer 와 cleaner 는**</span>
- 즉시 수행된다는 보장이 없다!
- 수행 여부조차 보장하지 않는다!
- finalizer 동작 중 발생한 예외는 무시된다.
- 심각한 성능 문제도 동반한다! (어떨 땐 5배 이상 느리다)
- finalizer 를 사용한 클래스는 finalizer 공격에 노출되어 심각한 보안 문제를 일으킬 수 있다.<br>
  이를 방어하려면 아무 일도 하지 않는 finalize 메서드를 만들고 final 로 선언하자.

finalizer 나 cleaner 를 얼마나 신속히 수행할지는 전적으로 가비지 컬렉터 알고리즘에 달렸으며, 이는 가비지 컬렉터 구현마다 천차만별이다.

**그렇다면 종료해야 할 자원을 담고 있는 객체의 클래스에서 finalizer 나 cleaner 를 대신해 줄 묘안은??**

- AutoClosable 을 구현해주고, 인스턴스를 다 쓰고 나면 close 메서드를 호출하도록 하면 된다.

<span style="color:skyblue">finalizer 나 cleaner 는 대체 어디에 쓰이는가?</span>
1. close 메서드를 호출하지 않는 것에 대한 안정망 역할
2. 네이티브피어(native peer) 객체를 회수할 때 (예를 들면 c++) 

코드: [Item8.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item8/Item8.java)




