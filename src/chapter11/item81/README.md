## 11장 - 동시성

### <아이템81 > wait 와 notify 보다는 동시성 유틸리티를 애용하라

> **(요약)** 코드를 새로 작성한다면 wait 와 notify 를 쓸 이유가 거의(어쩌면 전혀) 없다. 

**wait와 notify는 올바르게 사용하기가 아주 까다로우니 고수준 동시성 유틸리티를 사용하자.**

java.util.concurrent 의 고수준 유틸리티는 세 범주로 나눌 수 있다.

- 실행자 프레임워크(executor framework)
- 동시성 컬렉션(concurrent collection)
  - List, Queue, Map 과 같은 표준 컬렉션 인터페이스에 동시성을 가미해 구현한 고성능 컬렉션
  - **따라서 동시성 컬렉션에서 동시성을 무력화하는 건 불가능하며, 외부에서 락을 추가로 사용하면 오히려 속도가 느려진다.**
  - ConcurrentHashMap 은 동시성이 뛰어나며 속도도 무척 빠르다.
- 동기화 장치(synchronized)
  - 동기화 장치는 스레드가 다른 스레드를 기다릴 수 있게 하여, 서로 작업을 조율할 수 있게 해준다.
  - 가장 자주 쓰이는 동기화 장치는 CountDownLatch 와 Semaphore 다.
  - CyclicBarrier 와 Exchanger 는 그보다 덜 쓰인다.
  - 그리고 가장 강력한 동기화 장치는 바로 Phaser 다.

CountDownLatch 는 일회성 장벽으로, 하나 이상의 쓰레드가 또 다른 하나 이상의 쓰레드 작업이 끝날 때까지 기다리게 한다.

**시간 간격을 잴 때는 항상 System.currentTimeMillis 가 아닌 System.nanoTime 을 사용하자**

- System.nanoTime 은 더 정확하고 정밀하며 시스템의 실시간 시계의 시간 보정에 영향받지 않는다.

코드, [Item81.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter11/item81/Item81.java)
