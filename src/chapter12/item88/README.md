## 12장 - 직렬화

### <아이템88 > readObject 메서드는 방어적으로 작성하라

> **(요약)** readObject 메서드를 작성할 때는 언제나 public 생성자를 작성하는 자세로 임해야 한다.

코드, [Item50.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter8/item50/Item50.java) 에서 불변인 날짜 범위 클래스를 지키기 만드는 데 가변인 Date 필드를 이용했다.

그래서 불변식을 지키고 불변을 유지하기 위해 생성자와 접근자에서 Date 객체를 방어적으로 복사했다.  
그래서 코드가 상당히 길어졌다.

이 클래스를 직렬화하기로 결정했다면? 

그냥 implements Serializable 을 추가하면 되지 않나?

- 그렇게 하면 이 클래스의 주요한 불변식을 더는 보장하지 못하게 된다.

왜?

- readObject 메서드가 실질적으로 또 다른 public 생성자이기 때문이다.

따라서 readObject 메서드도 다른 생성자와 똑같은 수준으로 주의를 기울여야 한다.

**객체를 역직렬화할 때는 클라이언트가 소유해서는 안되는 참조 객체를 갖는 필드를 모두 반드시 방어적으로 복사해야 한다.**
