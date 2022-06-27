## 11장 - 동시성

### <아이템80 > 스레드보다는 실행자, 태스크, 스트림을 애용하라

> **(요약)** 스레드보다는 실행자, 태스크, 스트림을 애용하라

java.util.concurrent 패키지가 등장했다.

이 패키지는 실행자 프레임워크(Executor Framework)라고 하는 인터페이스 기반의 유연한 태스크 실행 기능을 담고 있다.

```java
ExecutorService exec = Executors.newSingleThreadExecutor();
exec.execute(runnable);
exec.shutdown();
```

이렇게 짧은 몇 줄로 뛰어난 작업 큐를 생성할 수 있게 되었다.

큐를 둘 이상의 스레드가 처리하게 하고 싶다면 간단히 다른 정적 팩터리를 이용하여 다른 종류의 실행자 서비스(스레드 풀)를 생성하면 된다.

자바 7이 되면서 실행자 프레임워크는 포크-조인(fork-join) 태스크를 지원하도록 확장되었다.
