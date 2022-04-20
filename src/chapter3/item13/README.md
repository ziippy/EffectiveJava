## 3장 - 모든 객체의 공통 메서드

### <아이템13 > clone 재정의는 주의해서 진행하라

> **(요약)** Cloneable 을 구현하는 모든 클래스는 clone 을 재정의해야 한다.

Cloneable 은 복제해도 되는 클래스임을 명시하는 용도의 믹스인 인터페이스 (mixin interface, 아이템20) 이다.

하지만, 아쉽게도 의도한 목적을 제대로 이루지 못했다.

- clone 메서드가 선언된 곳이 Cloneable 이 아닌 Object 이고
- 그마저도 protected 로 선언되어 있다.
- 그래서 Cloneable 을 구현하는 것만으로는 외부 객체에서 clone 메서드를 호출할 수 없다.
- 리플렉션(아이템65)을 사용하면 가능하지만, 이것도 100% 성공 보장하진 않는다.

이러한 여러 문제점들에도 불구하고, Cloneable 방식은 널리 쓰이고 있으므로 잘 알아두자.

```
public interface Cloneable {
}
```

이렇게 메서드 하나 없는 Cloneable 인터페이스는 대체 무슨 일을 할까?

- Object 의 protected 인 clone 의 동작 방식을 결정한다.
- 보통 인터페이스를 구현한다는 것은, 일반적으로 해당 클래스가 그 인터페이스에서 정의한 기능을 제공한다는 것인데
- Cloneable 의 경우에는 상위 클래스에 정의된 protected 메서드의 동작 방식을 변경한 것이다.

<span style="color:skyblue">**실무에서 Cloneable 을 구현한 클래스는 clone 메서드를 public 으로 제공하며, 사용자는 당연히 복제가 제대로 이뤄지리라 기대한다.**</span>

- clone 메서드는 사실상 생성자와 같은 효과를 낸다.
- 즉, clone 은 원본 객체에 아무런 해를 끼치지 않는 동시에 복제된 객체의 불변식을 보장해야 한다.

<br>

간단한 클래스의 경우에는 clone() 메서드에서 super.clone() 을 호출하면 된다.  
코드: [Item13.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter3/item13/Item13.java)

그런데!!

클래스가 가변 객체를 참조하는 순간! 재앙(?)으로 돌변한다.
- 원본이나 복제본 중 하나를 수정하면 다른 하나도 수정되어 버리는 것이다.
- 이를 방지하려면, clone() 메서드에서 내부 가변 객체도 복사해줘야 한다. (재귀적으로 호출)
- 배열을 복제할 때는 배열의 clone 메서드를 사용하라고 권장한다.  
코드: [CloneOfMutableObject.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter3/item13/CloneOfMutableObject.java)

clone 을 재귀적으로 호출하는 것만으로는 충분하지 않을 때도 있다.

- 연결 리스트 같은걸 내부 객체로 사용하고 있을 때가 해당된다.
- 이 땐, deepCopy 같은 걸 해야 한다.
- 연결 리스트 전체를 복사하는 게 deepCopy 다. (저수준)
- 또는, 고수준 메서드들을 호출해도 된다. (대신 느리다)

꼭 필요한 작업일까?

- Cloneable 을 이미 구현한 클래스를 확장한다면 어쩔 수 없이 clone 을 잘 작동하도록 구현해야 한다.
- 그렇지 않은 상황에서는 **복사 생성자**와 **복사 팩터리**라는 더 나은 객체 복사 방식을 제공할 수 있다.












