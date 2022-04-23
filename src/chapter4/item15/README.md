## 4장 - 클래스와 인터페이스

### <아이템15 > 클래스와 멤버의 접근 권한을 최소화하라

> **(요약)** 프로그램 요소의 접근성은 가능한 한 최소한으로 하라. 꼭 필요한 것만 골라 최소한의 public API 를 설계하자.

어설프게 설계된 컴포넌트와 잘 설계된 컴포넌트의 가장 큰 차이는?

- 클래스 내부 데이터와 내부 구현 정보를 외부 컴포넌트로부터 얼마나 잘 숨겼느냐!

<span style="color:skyblue">정보 은닉, 혹은 캡슐화라고 하는 이 개념은 소프트웨어 설계의 근간이 되는 원리다.</span>

자바는 정보 은닉을 위한 다양한 장치를 제공한다.

<br>

<span style="color:skyblue">접근 제어 메커니즘</span>

각 요소의 접근성은 접근 제한자(private, protected, public)로 정해진다.

※ 멤버에 부여할 수 있는 접근 수준은 4가지다.  
- private
  - 멤버를 선언한 톱 레벨 클래스에서만 접근할 수 있다.
- package-private
  - 멤버가 소속된 패키지안의 모든 클래스에서 접근할 수 있다.
  - 아무런 접근 제어자를 붙이지 않으면 기본적으로 이 타입이다.
- protected
  - package-private 의 접근 범위를 포함하며, 하위 클래스에서도 접근할 수 있다.
- public
  - 모든 곳에서 접근할 수 있다.

원칙
- 모든 클래스와 멤버의 접근성을 가능한 한 좁혀야 한다.
- public 클래스의 인스턴스 필드는 되도록 public 이 아니어야 한다.(아이템16)
- 추상 개념을 완성하는 데 꼭 필요한 구성요소로써의 상수라면 public static final 필드로 공개해도 좋다.

코드: [Item15.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item15/Item15.java)
