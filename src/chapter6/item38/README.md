## 6장 - 열거 타입과 어노테이션

### <아이템38 > 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라 

> **(요약)** 열거 타입 자체는 확장할 수 없지만, 인터페이스와 그 인터페이스를 구현하는 기본 열거 타입을 함께 사용해 같은 효과를 낼 수 있다.

열거 타입은 거의 모든 상황에서 이 책 초판에서 소개한 타입 안전 열거 패턴(typesafe enum pattern)보다 우수하다.

단, 예외가 하나 있으니

- 타입 안전 패턴은 확장할 수 있으나
- 열거 타입은 확장할 수 없다.

사실 대부분 상황에서 열거 타입을 확장하는 건 좋지 않은 생각이다.

<span style='color:skyblue'>그런데 확장할 수 있는 열거 타입이 어울리는 쓰임이 최소한 하나는 있다.</span>

바로 **연산 코드(operation code 또는 opcode)** 다.

이따금 API 제공하는 기본 연산 외에 사용자가 확장 연산을 추가할 수 있도록 열어줘야 할 때가 있다.

```java
interface Operation {
    double apply(double x, double y);
}

enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
}

enum ExtendedOperation implements Operation {
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };
    
    ... 생략 ...
}
```

인터페이스를 이용해 확장 가능한 열거 타입을 흉내 내는 방식에도 한 가지 사소한 문제가 있다.

- 열거 타입끼리 구현을 상속할 수 없다는 점

위 코드에서 BasicOperation 과 ExtendedOperation 간의 중복 코드가 많지 않아서 다행이지만,  
공유하는 기능이 많다면 그 부분을 별도의 도우미 클래스나 정적 도우미 메서드로 분리하는 방식을  
추가로 고려해야 한다.

하지만, 이렇게 할 수 있다는 것만 참고하라.  
가장 좋은 건, 이렇게 확장하지 않고 사용하도록 설계를 잘 해야 하는 것이다. (이건 내 의견~)

코드, [Item38.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter6/item38/Item38.java)
