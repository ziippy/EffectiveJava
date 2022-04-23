## 4장 - 클래스와 인터페이스

### <아이템16 > public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라

> **(요약)** public 클래스는 절대 가변 필드를 직접 노출해서는 안 된다.

이따금 인스턴스 필드들을 모아놓은 일 외에는 아무 목적도 없는 퇴보한 클래스가 있다.

```java
class Point {
    public double x;
    public double y;
}
```

이렇게는 작성하지 말자.

최소한 필드들은 private 로 바꾸고 public 접근자(getter)를 이용하는 방식으로 작성하자. (객체 지향 프로그래머라면..)

하지만,  
package-private 클래스 혹은 private 중첩 클래스라면 데이터 필드를 노출한다고 해도 하등의 문제가 없다.

코드: [Item16.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter4/item16/Item16.java)




