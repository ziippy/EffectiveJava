## 9장 - 일반적인 프로그래밍 원칙

### <아이템58 > 전통적인 for 문보다는 for-each 문을 사용하라

> **(요약)** 전통적인 for 문과 비교했을 때 for-each 문은 명료하고, 유연하고, 버그를 예방해준다. 성능 저하도 없다. 가능한 모든 곳에서 for 문이 아닌 for-each 문을 사용하자.

스트림이 제격인 작업이 있고, 반복이 제격인 작업이 있다.

전통적인 for 문은 오류가 생길 가능성이 높아진다.

이는 for-each 문을 사용하면 모두 해결된다.

하지만, for-each 문을 사용할 수 없는 상황이 세 가지 존재한다.

- 파괴적인 필터링 (destructive filtering)
  - 컬렉션을 순회하면서 선택된 원소를 제거해야 한다면 반복자의 remove 메서드를 호출해야 한다.
- 변형 (transforming)
  - 리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야 하는 경우
- 병렬 반복 (parallel iteration)
  - 여러 컬렉션을 병렬로 순회해야 하는 경우

코드, [Item58.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter9/item58/Item58.java)

