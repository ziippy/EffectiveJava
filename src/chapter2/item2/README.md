## 2장 - 객체 생성과 파괴

### <아이템2 > 생성자에 매개변수가 많다면 빌더를 고려하라

**(요약)** 생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 게 더 낫다.

클래스용 생성자 혹은 정적 팩터리는 어떤 모습일까?

1. 점층적 생성자 패턴 (telescoping constructor pattern)
매개변수 1개부터 n개까지 해당하는 생성자를 늘려나가는 방식<br>
코드: [TelescopingConstructorPattern.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item2/TelescopingConstructorPattern.java) <br>
-> 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기가 어렵다. 몇 번째가 뭔 변수인지...


2. 자바빈즈 패턴 (JavaBeans pattern)
매개변수가 없는 생성자로 객체를 만든 후, 세터 메서드들을 이용해서 값을 설정하는 방식<br>
코드: [JavaBeansPattern.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item2/JavaBeansPattern.java) <br>
-> 메서드를 여러 개 호출해야 하고, 객체가 완전히 생성되기 전까진 일관성(consistency)이 무너진 상태에 놓이게 된다.<br>
-> 클래스를 불변으로 만들 수 없다.


3. 빌더 패턴 (Builder pattern)
필수 매개변수만으로 생성자를 호출해 빌더 객체를 얻은 후 세터 메서드들을 호출해 설정하는 방식<br>
코드: [BuilderPattern.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item2/BuilderPattern.java) <br>
-> 쓰기 쉽고 읽기 쉽다. <br>
-> 계층적으로 설계된 클래스와 함께 쓰기에 좋다.<br>
코드: [BuilderPattern2.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item2/BuilderPattern2.java)

<strong>빌더 패턴은 상당히 유연하다.</strong>

빌더 하나로 여러 객체를 순회하면서 만들 수 있고, 빌더에 넘기는 매개변수에 따라 다른 객체를 만들 수도 있다.

하지만, 빌더 패턴을 사용하려면 빌더 부터 만들어야 한다는 단점은 있다.

그러므로..
매개변수가 4개 이상은 되어야 값어치를 한다.


