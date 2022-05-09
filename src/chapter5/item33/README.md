## 5장 - 제네릭

### <아이템33 > 타입 안전 이종 컨네이터를 고려하라 

> **(요약)** 타입 안전 이종 컨네이터를 고려하면 한 컨테이너가 다룰 수 있는 타입 매개변수의 수를 여러 개 할 수 있다.

제네릭은 매개변수화되는 대상은 (원소가 아닌) 컨테이터 자신이다.

- 따라서, 하나의 컨테이너에서 매개변수화할 수 있는 타입의 수가 제한된다.
- 예를 들면 Set 에는 1개, Map 에는 2개만 필요한 식이다.

하지만 더 유연하게 가능할까?

- 다행히 쉬운 해법이 있다.
- 컨테이너 대신 키를 매개변수화 한 다음
- 컨테이너에 값을 넣거나 뺄 때 매개변수화 한 키를 함께 제공하면 된다.

<span style="color:skyblue">이러한 설계 방식을 **타입 안전 이종 컨네이너 패턴**(type safe heterogeneous container pattern) 이라 한다.</span>

코드, [Item33.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter5/item33/Item33.java)