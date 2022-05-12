## 6장 - 열거 타입과 어노테이션

### <아이템36 > 비트 필드 대신 EnumSet을 사용하라 

> **(요약)** 열거할 수 있는 타입을 한데 모아 집합 형태로 사용한다고 해도 비트 필드를 사용할 이유는 없다.

열거한 값들이 주로 (단독이 아닌) 집합으로 사용될 경우,  
예전에는 각 상수에 서로 다른 2의 거듭제곱을 할당한 정수 열거 패턴(아이템 34)을 사용해 왔다.

```java
public enum Text {
    public static final int STYLE_BOLD = 1 << 0;        // 1
    public static final int STYLE_ITALIC = 1 << 1;      // 2
    public static final int STYLE_UNDERLINE = 1 << 2;   // 4
    public static final int STYLE_STRIKE = 1 << 3;      // 8
}

text.applyStyle(STYLE_BOLD | STYLE_ITALIC); // 이렇게 사용하곤 했다.
```

하지만, 비트 필드는 정수 열거 상수의 단점을 그대로 지니며, 추가로 다음과 같은 문제를 가지고 있다.

- 해석하기 훨씬 어렵다.
- 비트 필드 하나에 녹아있는 모든 원소를 순회하기도 힘들다.
- 최대 몇 비트가 필요한지 API 작성 시 미리 예측하여 적절한 타입을 선택해야 한다.

코드, [Item36.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter6/item36/Item36.java)
