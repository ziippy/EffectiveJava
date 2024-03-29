## 2장 - 객체 생성과 파괴

### <아이템3 > private 생성자나 열거 타입으로 싱글턴임을 보증하라

> **(요약)** 대부분 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.

싱글턴의 전형적인 예로는 함수와 같은 무상태 객체나 설계상 유일해야 하는 시스템 컴포넌트를 들 수 있다.

<span style="color:skyblue">싱글턴을 만드는 방식은 셋 중 하나다.</span>

1. public static final 필드 방식의 싱글턴 <br>
-> 장점 <br>
해당 클래스가 싱글턴임이 API 에 명백히 들어난다. <br>
간결함


2. 팩터리 방식의 싱글턴 <br>
-> 장점 <br>
API 를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다는 점 <br>
원한다면 정적 팩터리를 제너릭 싱글턴 팩터리로 만들 수 있다는 점 <br>
정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다는 점 (ex: Supplier<Singleton> 이런 식) <br>
-> But, 이러한 장점들이 굳이 필요하지 않으면.. 1번 케이스 처럼 public 필드 방식이 좋다. 


3. 원소가 하나인 열거 타입을 선언 <br>
-> 장점 <br>
제 2의 인스턴스가 생기는 일을 완벽히 막아줌 

코드: [Item3.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item3/Item3.java)




