## 11장 - 동시성

### <아이템78 > 공유 중인 가변 데이터는 동기화해 사용하라

> **(요약)** 여러 스레드가 가변 데이터를 공유한다면 그 데이터를 읽고 쓰는 동작은 반드시 동기화해야 한다.

synchronized 키워드는 해당 메서드나 블록을 한번에 한 쓰레드씩 수행하도록 보장한다.

동기화는 배타적 실행뿐 아니라 스레드 사이의 안정적인 통신에 꼭 필요하다.

쓰기와 읽기 모두가 동기화되지 않으면 동작을 보장하지 않는다.

더 빠른 대안도 있다.

volatile 로 선언하면 동기화는 생략해도 된다.

- volatile 한정자는 배타적 수행과는 상관없지만 항상 가장 최근에 기록된 값을 읽게 됨을 보장한다.
- 단, 이것도 주의해야 할 때가 있다.
- ```java
  private static volatile int nextSerialNumber = 0;
  
  private static int generateNextSerialNumber() {
    return nextSerialNumber++;
  }
  ```
- 위 코드 블록에서 ++ 연산자는 nextSerialNumber 를 2번 접근하는 것이므로, 그 2번 접근 사이를 비집고 들어오면 잘 못 동작할 수 있는 것이다.
- 그러므로, synchronized 한정자를 붙이면 이 문제는 해결된다.
- ```java
  private static volatile int nextSerialNumber = 0;
  
  private static synchronized int generateNextSerialNumber() {
    return nextSerialNumber++;
  }
  ```

java.util.concurrent.atomic 에 있는 AtomicLong 이나 AtomicInteger 와 같은 Atomic 클래스를 사용해도 된다.

이번 아이템에서 언급한 문제들을 피하는 가장 좋은 방법은 

- 애초에 가변 데이터를 공유하지 않는 것이다.
- 가변 데이터는 단일 스레드에서만 쓰도록 하고
- 만약 공유해야 한다면, 해당 객체에서 공유하는 부분만 동기화해도 된다.

코드, [Item78.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter11/item78/Item78.java)