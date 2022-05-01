## 4장 - 클래스와 인터페이스

### <아이템24 > 멤버 클래스는 되도록 static 으로 만들라 

> **(요약)** 멤버 클래스의 인스턴스 각각이 바깥 인스턴스를 참조한다면 비정적으로, 그렇지 않다면 정적으로 만들자.

<span style="color:skyblue">중첩 클래스란?</span>

- 다른 클래스 안에 정의된 클래스
- 자신을 감싼 바깥 클래스에서만 쓰여야 함
- 그 외의 쓰임새가 있다면 톱 레벨 클래스로 만들어야 한다.
- 종류
  - 정적 멤버 클래스
  - (비정적) 멤버 클래스
  - 익명 클래스
  - 지역 클래스

각 종류 별 언제 그리고 왜 사용해야 하는지 정리

**정적 멤버 클래스**

- 다른 클래스 안에서 선언되고
- 바깥 클래스의 private 멤버에도 접근할 수 있다
- 다른 정적 멤버와 똑같은 접근 규칙을 적용받는다.  
  코드: [StaticMemberClassTest.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item24/StaticMemberClassTest.java)

**(비정적) 멤버 클래스**

- static 이 안 붙은 클래스
- 비정적 멤버 클래스의 인스턴스는 바깥 클래스의 인스턴스와 암묵적으로 연결된다.
- 그래서 클래스명.this를 사용해 바깥 인스턴스의 메서드를 호출하거나, 바깥 인스턴스의 참조를 가져올 수 있다.
- 어댑터를 정의할 때 자주 쓰인다.
  코드: [NonStaticMemberClassTest.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item24/NonStaticMemberClassTest.java)

<span style="color:skyblue">멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static 을 붙여서 정적 멤버 클래스로 만들자</span>
