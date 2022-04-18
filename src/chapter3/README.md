## 3장 - 모든 객체의 공통 메서드

Object는 객체를 만들 수 있는 구체 클래스지만, 기본적으로는 상속해서 사용하도록 설계되었다.

Object 에서 final 이 아닌 메서드는 모두 재정의(overriding)를 염두에 두고 설계된 것이다.

- equals
- hashCode
- toString
- clone
- finalize

이런 메서드들을 일반 규약에 맞게 재정의해야 한다.

만약 그렇지 않으면, 대상 클래스가 이 규약을 준수한다고 가정하는 클래스(HashMap 과 HashSet 등)를 오동작하게 만들 수 있다.

#### < [아이템10](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter3/item10) > equals 는 일반 규약을 지켜 재정의하라