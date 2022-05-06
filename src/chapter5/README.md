## 5장 - 제네릭

제네릭(generic)은 자바 5부터 사용할 수 있다.

제네릭을 지원하기 전에는 컬렉션에서 객체를 꺼낼 때마다 형변환을 해야 했다.

- 누군가가 실수로 엉뚱한 타입의 객체를 넣어두면 런타임에 형변환 오류가 나곤 했다.

제네릭을 사용하면 컬렉션이 담을 수 있는 타입을 컴파일러에 알려주게 된다.

- 컴파일러는 알아서 형변환 코드를 추가할 수 있게 되고
- 엉뚱한 타입의 객체를 넣으려는 시도를 컴파일 과정에서 차단할 수 있다.

코드가 복잡해진다는 단점은 있다.

**제네릭의 이점을 최대로 살리고 단점을 최소화하는 방법을 알아보자**

#### < [아이템26](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter5/item26) > 로 타입은 사용하지 말라

#### < [아이템27](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter5/item27) > 비검사 경고를 제거하라

#### < [아이템28](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter5/item28) > 배열보다는 리스트를 사용하라

#### < [아이템29](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter5/item29) > 이왕이면 제네릭 타입으로 만들어라

#### < [아이템30](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter5/item30) > 이왕이면 제네릭 메서드로 만들라 
