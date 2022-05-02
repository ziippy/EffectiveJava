## 5장 - 제네릭

### <아이템26 > 로 타입은 사용하지 말라 

> **(요약)** 로(raw) 타입을 사용하면 런타임에 예외가 일어날 수 있으니 사용하면 안 된다.

<span style="color:skyblue">용어 정리</span>

- 클래스와 인터페이스 선언에 타입 매개변수(type parameter)가 쓰이면 -> **제네릭 클래스** 혹은 **제네릭 인터페이스**
- 제네릭 클래스와 제네릭 인터페이스를 통틀어 -> **제네릭 타입**

제네릭을 지원하기 전에는 컬렉션을 다음과 같이 선언했다. 하지만 여전히 좋은 예는 아니다.

```java
private final Collection stamps = ...;

stamps.add(new Coin(...));  // "unchecked call" 경고만 뱉을 뿐 오류가 발생하지 않는다.

이후

for (Interator i = stamps.iterator(); i.hasNext();) {
    Stamp stamp = (Stamp) i.next();     // runtime 때 ClassCastException 을 던진다.
    stamp.cancel();    
}
```
<span style="color:skyblue">오류는 가능한 한 발생 즉시, 이상적으로는 컴파일할 때 발견하는 것이 좋다.</span>

제네릭을 활용하면, 매개변수화된 컬렉션 타입을 지정할 수 있어 타입 안정성이 확보된다.

```java
private final Collection<Stamp> stamps = ...;
```

<span style="color:skyblue">로 타입(타입 매개변수가 없는 제네릭 타입)을 쓰는 걸 언어 차원에서 막아 놓지는 않았지만, 절대로 써서는 안 된다.</span>

- 로 타입을 쓰면 제네릭이 안겨주는 안정성과 표현력을 모두 잃게 된다.

코드: [Item26.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter5/item26/Item26.java)
