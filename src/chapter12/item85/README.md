## 12장 - 직렬화

### <아이템85 > 자바 직렬화의 대안을 찾으라

> **(요약)** 직렬화는 위험하니 피해야 한다.

1997년, 자바에 처음으로 직렬화가 도입되었다.

직렬화의 근본적인 문제점은 공격 범위가 너무 넓고 지속적으로 더 넓어져 방어하기 어렵다는 것이다.

ObjectInputStream 의 readObject 메서드를 호출하면서 객체 그래프가 역직렬화되기 때문이다.

readObject 메서드는 (Serializable 인터페이스를 구현했다면) 클래스패스 안의 거의 모든 타입의 객체를 만들어 낼 수 있는, 사실상 마법 같은 생성자다.

바이트 스트림을 역직렬화하는 과정에서 이 메서드는 그 타입들 안의 모든 코드를 수행할 수 있다.

이 말인 즉슨, 그 타입들의 코드 전체가 공격 범위에 들어간다는 뜻이다.

직렬화 위험을 회피하는 가장 좋은 방법은 아무것도 역직렬화하지 않는 것이다.

차선책으로는, 신뢰할 수 없는 데이터는 절대 역직렬화하지 않는 것이다.

블랙리스트 보다는 화이트리스트 방식을 추천한다.