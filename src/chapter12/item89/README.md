## 12장 - 직렬화

### <아이템89 > 인스턴스 수를 통제해야 한다면 readResolve 보다는 열거 타입을 사용하라

> **(요약)** 불변식을 지키기 위해 인스턴스를 통제해야 한다면 가능한 한 열거 타입을 사용하자. 여의치 않은 상황에서 직렬화와 인스턴스 통제가 모두 필요하다면 readResolve 메서드를 작성해 넣어야 하고, 그 클래스에서 모든 참조 타입 인스턴스 필드를 transient 로 선언해야 한다.

#### < [아이템3](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter2/item3) > 에서 보여준 예제 코드인 싱글턴 클래스도
```java
class Single {
    public static final Single INSTANCE = new Single();
    private Single() { }

    public void print() {
        System.out.println("singleton");
    }
}
```

선언에 implements Serializable 을 추가하는 순간 더 이상 싱글턴이 아니게 된다.

- 기본 직렬화를 쓰지 않더라도
- 명시적인 readObject 를 제공하더라도
- 어떤 readObject 를 사용하든 이 클래스가 초기화될 때 만들어진 인스턴스와 별개인 인스턴스를 반환하게 된다.

**readResolve 기능을 이용하면 readObject 가 만들어낸 인스턴스를 다른 것으로 대체할 수 있다.**

다음의 readResolve 메서드를 추가해 싱글턴이라는 속성을 유지할 수 있다.

```java
private Object readResolve() {
    return INSTANCE;
}
```
