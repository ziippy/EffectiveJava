## 4장 - 클래스와 인터페이스

### <아이템23 > 태그 달린 클래스보다는 클래스 계층구조를 활용하라 

> **(요약)** 태그 달린 클래스를 써야 하는 상황은 거의 없다. 새로운 클래스를 작성하는 데 태그 필드가 등장한다면, 태그를 없애고 계층구조로 대체하는 방법을 생각해보자.

두 가지 이상의 의미를 표현할 수 있으며, 그중 현재 표현하는 의미를 태그 값으로 알려주는 클래스가 있다.

예를 들면,

원과 사각형을 함께 표현하는 Figure 클래스 

코드: [FigureTest.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item23/FigureTest.java)

여기서 확인해보기 바란다.

태그 달린 클래스에는 단점이 한가득이다. 장황하고 오류를 내기 쉽고 비효율적이다.

이를 계층 구조로 바꿔보자.

코드: [FigureTest2.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item23/FigureTest2.java)

여기서 확인해보기 바란다.


<span style="color:skyblue">핵심 정리</span>
- 태그 달린 클래스를 써야 하는 상황은 거의 없다.
- 새로운 클래스를 작성하는 데 태그 필드가 등장한다면, 태그를 없애고 계층구조로 대체하는 방법을 생각해보자.
