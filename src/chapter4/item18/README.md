## 4장 - 클래스와 인터페이스

### <아이템18 > 상속보다는 컴포지션을 사용하라

> **(요약)** 상속은 강력하지만 캡슐화를 해친다는 문제가 있다. 상속은 상위 클래스와 하위 클래스가 순수한 is-a 관계일 때만 써야 한다.

상속은 코드를 재사용하는 강력한 수단이지만, 항상 최선은 아니다.

메서드 호출과 달리 상속은 캡슐화를 깨뜨린다.

- 상위 클래스가 어떻게 구현되느냐에 따라, 하위 클래스의 동작에 이상이 생길 수 있다.

(예를 들어)

코드: [Item18.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item18/Item18.java)

여기서 InstrumentedHashSet 클래스는 HashSet 클래스를 상속 받고,  
add 와 addAll 메서드를 오버라이드 했다.

그래서 add 에서도 내부 size 를 +1 하는 코드, addAll 은 +n 하는 코드를 구현했는데  
알고보니 부모 클래스인 HashSet 의 addAll 메서드가 내부적으로 add 를 호출하기 때문에  
addAll(10개) 를 호출하면 내부 size 가 20개가 되버리는 것이다.

<span style="color:skyblue">이처럼 메서드 재정의가 원인이되어 의도하지 않게 동작할 수 있다.</span>

클래스를 확장하더라도 메서드를 재정의하지 말고, 새로운 메서드를 추가하면 괜찮지 않을까?

- 물론 이 방식이 훨씬 안전한 것은 맞다.
- 하지만, 새로 추가한 메서드가 상위 클래스의 시그니처와 같고, 반환 타입은 다르다면 컴파일조차 되지 않을 것이다.
- 새로 만든 메서드가 상위 클래스가 요구하는 규약을 만족하는지도 확인해야 한다.

<span style="color:skyblue">다행히 이상의 문제를 모두 피해 가는 묘안이 있다.</span>

- 기존 클래스를 확장하는 대신, 새로운 클래스를 만들고 private 필드로 기존 클래스의 인스턴스를 참조하게 하자.
- 기존 클래스가 새로운 클래스의 구성요소로 쓰인다는 뜻에서 이러한 설계를 **컴포지션(composition, 구성)** 이라고 한다.

코드: [CompositionTest.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item18/CompositionTest.java)

에서 이렇게 구현된 코드를 확인할 수 있다.

<span style="color:skyblue">상속은 반드시 하위 클래스가 상위 클래스의 '진짜' 하위 타입인 상황에서만 쓰여야 한다.</span>

- 클래스 B 가 클래스 A 와 is-a 관계일 때만 클래스 A를 상속해야 한다.
- 즉, 클래스 A 를 상속받아서 클래스 B 를 작성하려고 할 때, B 가 A 인가? 를 자문해보자.
- '그렇다' 고 확신할 수 없다면 클래스 B 는 클래스 A 를 상속해서는 안된다.
