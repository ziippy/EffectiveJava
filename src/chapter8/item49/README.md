## 8장 - 메서드

### <아이템49 > 매개변수가 유효한지 검사하라

> **(요약)** 메서드나 생성자를 작성할 때면 그 매개변수들에 어떤 제약이 있을지 생각해야 한다. 그 제약들을 문서화하고 메서드 코드 시작 부분에서 명시적으로 검사해야 한다.

메서드와 생성자 대부분은 입력 매개변수의 값이 특정 조건을 만족하기를 바란다.

public 과 protected 메서드는 매개변수 값이 잘못됐을 때 던지는 예외를 문서화해야 한다.

- 보통은 IllegalArgumentException, IndexOufOfBoundsException, NullPointerException 중 하나가 될 것이다.

이런 간단한 방법으로 API 사용자가 제약을 지킬 가능성을 크게 높일 수 있다.

코드, [Item49.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter8/item49/Item49.java)
