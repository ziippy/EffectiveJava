## 8장 - 메서드

### <아이템50 > 적시에 방어적 복사본을 만들라

> **(요약)** 클래스가 클라이언트로부터 받는 혹은 클라이언트로 반환하는 구성요소가 가변이라면 그 요소는 반드시 방어적으로 복사해야 한다. 단, 성능 저하가 큰 이슈거나 클라이언트가 수정할 리 없다고 신뢰한다면 문서에 명시하고 제외로 한다.

자바는 안전한 언어다. 이것이 자바를 쓰는 즐거움 중 하나다.

- 네이티브 메서드를 사용하지 않으니 C, C++ 같이 안전하기 않은 언어에서 흔히 보는 버퍼 오버런, 배열 오버런, 와일드 포인터 같은 메모리 충돌 오류에서 안전하다.
- 자바로 작성된 클래스는 시스템의 다른 부분에서 무슨 짓을 하든 그 불변식이 지켜진다.
- 메모리 전체를 하나의 거대한 배열로 다루는 언어에서는 누릴 수 없는 강점이다.

하지만, 아무리 자바라 해도 다른 클래스로부터의 침범을 아무런 노력 없이 다 막을 수 있는 건 아니다.

그러므로

<span style='color:skyblue'>클라이언트가 여러분의 불변식을 깨뜨리려 혈안이 되어 있다고 가정하고 방어적으로 프로그래밍해야 한다.</span>

어떤 객체든 그 객체의 허락 없이는 외부에서 내부를 수정하는 일은 불가능하다.  
하지만 주의를 기울이지 않으면 자기도 모르게 내부를 수정하도록 허락하는 경우가 생긴다.

코드, [Item50.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter8/item50/Item50.java)

에서 확인할 수 있는 Period 인스턴스의 내부를 보호하려면

**생성자에서 받은 가변 매개변수 각각을 방어적으로 복사(defensive copy) 해야 한다.

우리는 "되도록 불변 객체들을 조합해 객체를 구성해야 방어적 복사를 할 일이 줄어든다" 는 교훈을 얻을 수 있다.

- 하지만, 방어적 복사에는 성능 저하가 따르므로  
복사 비용이 너무 크면 방어적 복사를 수행하는 대신, 해당 구성요소를 수정 했을 때의 책임이 클라이언트에 있음을 문서에 명시하도록 하자.