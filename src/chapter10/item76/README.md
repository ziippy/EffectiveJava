## 10장 - 예외

### <아이템76 > 가능한 한 실패 원자적으로 만들라

> **(요약)** 가능한 한 실패 원자적으로 만들라

작업 도중 예외가 발생해도 그 객체는 여전히 정상적으로 사용할 수 있는 상태라면 멋지지 않은가?

검사 예외를 던진 경우라면 호출자가 오류 상태를 복구할 수 있을 테니 특히 더 유용할 것이다.

일반화 해 이야기하면

**호출된 메서드가 실패하더라도 해당 객체는 메서드 호출 전 상태를 유지해야 한다.**

이러한 특성을 **실패 원자적(failure-atomic)** 이라고 한다.

메서드를 실패 원자적으로 만드는 방법은 다양하다.

- 불변 객체로 설계하는 것이다.
  - 가장 흔한 방법은 작업 수행에 앞서 매개변수의 유효성을 검사하는 것이다.
- 실패할 가능성이 있는 모든 코드를, 객체의 상태를 바꾸는 코드보다 앞에 배치하는 방법도 있다.
- 객체의 임시 복사본에서 작업을 수행한 다음, 작업이 성공적으로 완료되면 원래 객체와 교체하는 것이다.
- 작업 도중 발생하는 실패를 가로채는 복구 코드를 작성하여 작업 전 상태로 되돌리는 방법이다.

코드, [Item76.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter10/item76/Item76.java)