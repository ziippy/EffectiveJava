## 2장 - 객체 생성과 파괴

### <아이템7 > 다 쓴 객체 참조를 해제하라

> **(요약)** 참조를 다 썼을 때 null 처리(참조 해제) 해주면 된다.

- 자기 메모리를 직접 관리하는 클래스라면 프로그래머는 항시 메모리 누수에 주의해야 한다.
- 캐시 역시 메모리 누수를 일으키는 주범이다.
- 리스너 또는 콜백도 클라이언트가 등록만 하고 명확히 해지하지 않는다면 계속해서 쌓여갈 것이다.<br>
  이럴 때 ,콜백을 약한 참조(weak reference)로 저장하면 가비지 컬렉터가 즉시 수거해간다.

코드: [Item7.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item7/Item7.java)




