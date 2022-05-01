## 4장 - 클래스와 인터페이스

### <아이템25 > 톱레벨 클래스는 한 파일에 하나만 담으라 

> **(요약)** 소스 파일 하나에는 반드시 톱레벨 클래스(혹은 톱레벨 인터페이스)를 하나만 담자.

소스 파일 하나에 톱레벨 클래스를 여러 개 선언하더라도 자바 컴파일러는 불평하지 않는다.

하지만, 아무런 득이 없고 오히려 심각한 위험을 감수해야 하는 행위다.

- 두 클래스가 하나의 .java 파일에 정의되었다.  
  코드: [Item25.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item25/Item25.java)
- 물론 pancake 라고 정상적으로 출력된 것 처럼 보이지만,
- 해당 클래스들을 다른 파일 (예를 들면 Dessert.java) 에 정의한다면
- 컴파일이 되지 않을 것이다.

<span style="color:skyblue">해결책은 명확하다. 톱 레벨 클래스는 서로 다른 파일로 분리하면 그만이다.</span>

굳이 여러 톱레벨 클래스를 한 파일에 담고 싶다면, 정적 멤버 클래스를 사용하는 방법을 고민해볼 수 있다.

- 코드: [Item25_with_static.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item25/Item25_with_static.java)
