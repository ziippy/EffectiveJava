## 12장 - 직렬화

### <아이템90 > 직렬화된 인스턴스 대신 직렬화 프록시 사용을 검토하라

> **(요약)** 제 3자가 확장할 수 없는 클래스라면 가능한 한 직렬화 프록시 패턴을 사용하자. 이 패턴이 아마도 중요한 불변식을 안정적으로 직렬화해주는 가장 쉬운 방법일 것이다.

Serializable 을 구현하기로 결정한 순간 버그와 보안 문제가 일어날 가능성이 커진다는 뜻이다.

하지만 이 위험을 크게 줄여줄 기법이 하나 있다.

바로 **직렬화 프록시 패턴(serialization proxy pattern)** 이다.

```java
import java.io.Serializable;
import java.time.Period;

private static class SerializationProxy implements Serializable {
    private final Date start;
    private final Date end;

    SerializationProxy(Period p) {
        this.start = p.start;
        this.end = p.end;
    }
    
    private static final long serialVersionUID = 234434313243432;   // 아무값이나 상관 없다.
}
```

이렇게 만들어 놓고, 바깥 클래스에 다음의 writeReplace 메서드를 추가한다.

이 메서드는 범용적이니 직렬화 프록시를 사용하는 모든 클래스에 그대로 복사해 쓰면 된다.

```java
// 직렬화 프록시 패턴용 writeReplace 메서드
private Object writePlace() {
    return new SerializationProxy(this);
}
```
