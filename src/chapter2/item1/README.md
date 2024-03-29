## 2장 - 객체 생성과 파괴

### <아이템1 > 생성자 대신 정적 팩터리 메서드를 고려하라

> **(요약)** 정적 팩터리를 사용하는 게 율한 경우가 더 많으므로, 무작정 public 생성자를 제공하던 습관이 있다면 고치자. !!

클라이언트가 클래스의 인스턴스를 얻는 전통적인 수단은 public 생성자이다.<br>
하지만, 클래스는 생성자와 별도로 정적 팩터리 메서드(static factory method)를 제공할 수 있다.

코드: [Item1.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item1/Item1.java)

<br/>  
<span style="color:skyblue">정적 팩터리 메서드가 생성자보다 좋은 장점 5가지</span>

1. 이름을 가질 수 있다.<br>
  -> Integer.valueOf 에서 valueOf 처럼 의미가 유추 가능한 이름을 지을 수 있다.
2. 호출할 때마다 새로운 인스턴스를 생성하지 않아도 된다. (Flyweight 패턴도 이와 비슷한 기법)<br>
  -> 굳이 매번 new 를 안해도 되니, 생성 비용이 큰 객체가 자주 요청되는 상황이라면 성능 업에 도움이 된다.
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.<br>
   -> 호출하는 클래스를 상속 받은 하위 클래스의 객체로 반환받을 수 있다.
5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

<br/>
<span style="color:skyblue">단점 2가지</span>

1. 상속을 하려면 public 이나 protected 생성자가 필요하니, 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
2. 프로그래머가 찾기 힘들다.

<br/>
<span style="color:skyblue">네이밍 컨벤션</span>

- `from`: 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
- `of`: 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
- `valueOf`: from 과 of 의 더 자세한 버전
- `instance` | getInstance: 인스턴스 생성. 늘 새로운 것이거나, 같은 것임을 보장하진 않음
- `create` | newInstance: 매번 새로운 인스턴스 생성
- `getType`: 다른 클래스에 팩터리 메서드를 정의할 때 쓴다
- `newType`: 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. 매번 새로운 인스턴스
- `type`: getType 과 newType 의 간결한 버전


