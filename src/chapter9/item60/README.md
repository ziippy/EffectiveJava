## 9장 - 일반적인 프로그래밍 원칙

### <아이템60 > 정확한 답이 필요하다면 float 와 double 은 피하라

> **(요약)** 정확한 답이 필요하다면 float 와 double 은 피하라.

float 와 double 타입은 공학 계산용으로 설계되었다.

- 이진 부동소수점 연산에 쓰이며, 넓은 범위의 수를 빠르게 정밀한 '근사치'로 계산하도록 세심하게 설계되었다.
- **따라서 정확한 결과가 필요할 때는 사용하면 안 된다.**
- float 와 double 타입은 특히 금융 관련 계산과는 맞지 않는다.
  - 0.1 혹은 10의 음의 거듭 제곱 수를 표현할 수 없기 때문이다.

<span style='color:skyblue'>금융 계산에는 BigDecimal, int 혹은 long 을 사용해야 한다.</span>

- 그러나, BigDecimal 은 쓰게 불편하고, 훨씬 느리다.
- int 나 long 타입을 쓸 수 있지만, 이 경우 소수점을 직접 관리해야 한다.

코드, [Item60.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter9/item60/Item60.java)
