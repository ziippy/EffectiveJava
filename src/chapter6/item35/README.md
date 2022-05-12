## 6장 - 열거 타입과 어노테이션

### <아이템35 > ordinal 메서드 대신 인스턴스 필드를 사용하라 

> **(요약)** ordinal 메서드는 가급적이면 절대 사용하지 말자.

대부분의 열거 타입 상수는 자연스럽게 하나의 정수값에 대응된다.

그리고 모든 열거 타입은 해당 상수가 그 열거 타입에서 몇 번째 위치인지를 반환하는 **ordinal** 이라는 메서드를 제공한다.

- 하지만, 이 위치 값을 이용해서 하는 경우 끔직한 코드가 될 수 있다.
- 중간에 다른 변수를 삽입(선언)하면 그 값이 바껴버리기 때문이다.

따라서, <span style="color:skyblue">열거 타입 상수에 연결된 값은 ordinal 메서드로 얻지 말고, 인스턴스 필드에 저장하자.</span>

```java
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), TRIPPLE_QUARTET(12), QUARTET(4);
    
    private final int numberOfMusicians;
    EnsembleGood(final int size) {
        this.numberOfMusicians = size;
    }
    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
```

코드, [Item35.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter6/item35/Item35.java)
