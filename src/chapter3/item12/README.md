## 3장 - 모든 객체의 공통 메서드

### <아이템12 > toString 을 항상 재정의하라

> **(요약)** 모든 구체 클래스에서 Object 의 toString 을 재정의하자.

Object 의 기본 toString 은 단순히 `클래스이름@16진수로_표시한_해시코드` 를 반환할 뿐이다.

toString 은 대단히 중요하진 않지만, 

toString 을 잘 구현한 클래스는 사용하기에 훨씬 즐겁고, 그 클래스를 사용한 시스템은 디버깅하기 쉽다.

실전에서 toString 은 그 객체가 가진 주요 정보 모두를 반환하는 게 좋다.

코드: [Item12.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter3/item12/Item12.java)




