## 2장 - 객체 생성과 파괴

### <아이템4 > 인스턴스화를 막으려거든 private 생성자를 사용하라

**(요약)** private 생성자를 추가하면 클래스의 인스턴스화를 막을 수 있다.

java.lang.Math 와 java.util.Arrays 처럼 기본 타입 값이나 배열 관련 메서드들을 모아놓은 객체들은 인스턴스로 만들어 쓰려고 설계한 것이 아니다.

그러므로, 이러한 클래스들은 인스턴스화를 할 수 없도록 해야 한다.

그런데 생성자를 명시하지 않으면, 컴파일러가 자동으로 기본 생성자를 만들어준다.

따라서 private 생성자를 추가하면 클래스의 인스턴스화를 막을 수 있다.<br>
이 방식은 상속을 불가능하게 하는 효과도 있다.

코드: [Item4.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item4/Item4.java)




