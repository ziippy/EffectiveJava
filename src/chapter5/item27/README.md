## 5장 - 제네릭

### <아이템27 > 비검사 경고를 제거하라 

> **(요약)** 비검사 경고는 중요하니 무시하지 말자. 모든 비검사 경고는 런타임에 ClassCastException을 일으킬 수 있는 잠재적 가능성을 뜻하니, 최선을 다해 제거하라.

- 할 수 있는 한 모든 비검사 경고를 제거하라.  
  모두 제거된다면, 그 코드는 타입 안정성이 보장된다.
- 경고를 제거할 수 없지만 타입 안전하다고 확신할 수 있다면 @SuppresWarning("unchecked") 어노테이션을 달아 경고를 숨기자.
- @SuppresWarning("unchecked") 어노테이션은 항상 가능한 한 좁은 범위에 적용하자.
- @SuppresWarning("unchecked") 어노테이션을 사용할 때면 그 경고를 무시해도 안전한 이유를 항상 주석으로 남겨야 한다.

코드: [Item27.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter5/item27/Item27.java)
