## 6장 - 열거 타입과 어노테이션

### <아이템40 > @Override 어노테이션을 일관되게 사용하라 

> **(요약)** 재정의한 모든 메서드에 @Override 어노테이션을 의식적으로 달면, 실수했을 때 컴파일러가 바로 알려줄 것이다.

자바가 기본적으로 제공하는 어노테이션 중 보통의 프로그래머에게 가장 중요한 것은 @Override 일 것이다.

- 이는 메서드 선언에만 달 수 있으며,
- 이게 달렸다는 것은 상위 타입의 메서드를 재정의했음을 뜻한다.
- 이걸 일관되게 사용하면 여러 가지 악명 높은 버그들을 예방해준다.

<span style='color:skyblue'>상위 클래스의 메서드를 재정의하려는 모든 메서드에 @Override 어노테이션을 달자.</span>

코드, [Item40.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter6/item40/Item40.java)
