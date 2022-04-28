## 4장 - 클래스와 인터페이스

### <아이템20 > 추상 클래스보다는 인터페이스를 우선하라 

> **(요약)** 일반적으로 다중 구현용 타입으로는 인터페이스가 가장 적합하다.

자바가 제공하는 다중 구현 메커니즘은 인터페이스와 추상 클래스, 이렇게 두 가지가 있다.

자바8부터 인터페이스에도 디폴트 메서드(default method)를 제공할 수 있게 되어, 이렇게 두 가지 인 것이다.

그러나, 추상 클래스가 정의한 타입을 구현한 클래스는 반드시 추상 클래스의 하위 클래스이어야 한다는 점이 큰 차이다.

**몇 가지 정의**

- 기존 클래스에도 손쉽게 새로운 인터페이스를 구현해 넣을 수 있다.  
  인터페이스가 요구하는 메서드를 추가하고, 클래스 선언에 implements 구문만 추가하면 끝이다.
- 인터페이스는 믹스인(mixin) 정의에 안성맞춤이다.  
  믹스인이란 클래스가 구현할 수 있는 타입으로, '주된 타입' 외에 특정한 선택적 행위를 제공한다고 선언하는 효과를 준다.
- 인터페이스로는 계층구조가 없는 타입 프레임워크를 만들 수 있다.  
  ```java
  public interface Singer {
  }
  public interface SongWriter {
  }
  public interface SingerSongWriter extends Singer, SongWriter {
  }
  ```
- 인터페이스는 기능을 향상시키는 안전하고 강력한 수단이 된다.

코드: [Item20.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item20/Item20.java)




