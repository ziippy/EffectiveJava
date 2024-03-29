## 10장 - 예외

### <아이템70 > 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라

> **(요약)** 복구할 수 있는 상황이라면 검사 예외를, 프로그래밍 오류라면 비검사 예외를 던지자. 확실하지 않다면 비검사 예외를 던지자.

자바는 문제 상황을 알리는 타입(throwable)으로 

- 검사 예외
- 런타임 예외
- 에러

이렇게 세 가지를 제공한다.

언제나 100% 명확한 건 아니지만 이럴 때 참고하면 좋은 멋진 지침들이 있으니 함께 살펴보자.

**검사 예외** 는

- 호출하는 쪽에서 복구하리라 여겨지는 상황이라면 검사 예외를 사용하라.
  - API 설계자가 API 사용자에게 검사 예외를 던져주어 그 상황에서 회복해내라고 요구하는 식
- 이런 throwable 을 잡지 않은 스레드는 적절한 오류 메시지를 내뱉으며 중단된다.

**런타임 예외** 는

- 프로그래밍 오류를 나타낼 때 사용하자.
- 대부분은 전제조건을 만족하지 못했을 때 발생한다.
  - API 명세에서 값은 0 보다 커야 한다고 했는데, 음수 값이 들어왔을 때와 같은 상황이다.

복구 가능하다고 믿는다면 검사 예외를, 그렇지 않다면 런타임 예외를 사용하자.
