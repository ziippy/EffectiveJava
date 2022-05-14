## 6장 - 열거 타입과 어노테이션

### <아이템37 > ordinal 인덱싱 대신 EnumMap을 사용하라 

> **(요약)** 배열의 인덱스를 얻기 위해 ordinal을 쓰는 것은 일반적으로 좋지 않으니, 대신 EnumMap을 사용하라.

이따금 배열이나 리스트에서 원소를 꺼낼 때 ordinal 메서드(아이템35)로 인덱스를 얻는 코드가 있다.

하지만, 배열은 각 인덱스의 의미를 모르니 출력 결과에 직접 레이블을 달아야 한다.

정확한 정수값을 알고 써야 한다. 자칫 잘못하면 ArrayIndexOutOfBoundsException 을 던질 것이다.

그럼 해결책은?

- 여기서 배열은 실질적으로 열거 타입 상수를 값으로 매핑하는 일을 한다.
- 이는 Map을 사용해서도 할 수 있을 것이다.

열거 타입을 키로 사용하도록 설계된 아주 빠른 Map 구현체가 존재하는데, 바로 **EnumMap** 이다.

코드, [Item37.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter6/item37/Item37.java)
