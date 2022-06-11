## 9장 - 일반적인 프로그래밍 원칙

### <아이템63 > 문자열 연결은 느리니 주의하라

> **(요약)** 원칙은 간단하다. 성능에 신경 써야 한다면 많은 문자열을 연결할 때는 문자열 연결 연산자(+)를 피하자. 대신 StringBuilder 의 append 메서드를 사용하라.

문자열 연결 연산자(+)는 여러 문자열을 하나로 합쳐주는 편리한 수단이다.

**문자열 연결 연산자로 문자열 n 개를 잇는 시간은 n^2 에 비례한다.**

성능을 포기하고 싶지 않다면 String 대신 **StringBuilder** 를 사용하자.

코드, [Item63.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter9/item63/Item63.java)
