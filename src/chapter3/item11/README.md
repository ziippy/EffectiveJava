## 3장 - 모든 객체의 공통 메서드

### <아이템11 > equals 를 재정의하려거든 hashCode 도 재정의하라

> **(요약)** equals 를 재정의할 때는 hashCode 도 반드시 재정의해야 한다!!

<span style="color:skyblue">equals 를 재정의한 클래스 모두에서 hashCode 도 재정의해야 한다.</span>  

그렇지 않으면 hashCode 일반 규약을 어기게 되어 해당 클래스의 인스턴스를 HashMap 이나 HashSet 같은 컬렉션의 원소로 사용할 때 문제를 일으킬 것이다.

<span style="color:skyblue">**Object 명세에서 발췌한 규약**</span>

1. hashCode 를 몇 번 호출해도 일관되게 항상 같은 값을 반환해야 한다. (단, 어플리케이션을 다시 실행한다면 이 값이 달라져도 상관없다.)
2. equals 가 true 인 두 객체에 대한 hashCode 는 똑같은 값을 반환해야 한다.
3. equals 가 false 인 두 객체의 hashCode 값이 서로 다를 필요까지는 없다. (단, 다른 값을 반환해야 해시테이블의 성능이 좋아진다.)

hashCode 재정의를 잘못했을 때 크게 문제가 되는 조항은 위에서 2번 항목이다.

<span style="color:skyblue">**좋은 hashCode 를 작성하는 간단한 요령**</span>

1. int 변수 result 를 선언한 후 값 c 로 초기화한다.<br>
  이 때 c 는 해당 객체의 핵심 필드(equals 비교에 사용되는 필드)를 2.i 방식으로 계산한 해시코드
2. 해당 객체의 나머지 핵심 필드 f 각각에 대해 다음 작업을 수행한다.
   1. 해당 필드의 해시코드 c 를 계산한다.
      1. 기본 타입 필드라면, Type.hashCode(f) 를 수행
      2. 참조 타입 필드면서 이 클래스의 equals 메서드가 이 클래스의 equals 를 재귀적으로 호출해 비교한다면, hashCode 를 재귀적으로 호출한다.
      3. 필드가 배열이라면, 핵심 원소 각각을 별도 필드처럼 다룬다.
   2. 단계 2.i 에서 계산한 해시코드 c로 result 를 갱신한다.<br>
     코드로는 result = 31 * result + c;
3. result 를 반환한다.

<span style="color:skyblue">**주의사항**</span>
- 파생 필드는 해시코드 계산해서 제외해도 된다. (파생 필드: 다른 필드들로부터 계산해 낼 수 있는 필드)
- equals 비교에 사용되지 않은 필드는 '반드시' 제외해야 한다.
- 단계 2.ii 에서 31 을 곱하는 이유는 필드를 곱하는 순서에 따라 result 값이 달라지게 하기 위함이다.<br>
  곱할 숫자를 31로 정한 이유는, 31이 홀수이면서 소수이기 때문이다.

<br>

<span style="color:skyblue">전형적인 hashCode 메서드</span>

```java
class Sample {
    private short aaa;
    private short bbb;
    private short ccc;

    @Override
    public int hashCode() {
        int result = Short.hashCode(aaa);
        result = 31 * result + Short.hashCode(bbb);
        result = 31 * result + Short.hashCode(ccc);
        return result;
    }
}
```

코드: [Item11.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter3/item11/Item11.java)




