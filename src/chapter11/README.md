## 11장 - 동시성

스레드는 여러 활동을 동시에 수행할 수 있게 해준다.

하지만 동시성 프로그래밍은 단일 스레드 프로그래밍보다 어렵다.

- 잘못될 수 있는 일이 늘어나고 문제를 재현하기도 어려워지기 때문이다.

동시성 프로그램을 명확하고 정확하게 만들고 잘 문서화하는 데 도움이 되는 조언들을 담았다.

#### < [아이템78](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item78) > 공유 중인 가변 데이터는 동기화해 사용하라

#### < [아이템79](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item79) > 과도한 동기화는 피하라

#### < [아이템80](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item80) > 스레드보다는 실행자, 태스크, 스트림을 애용하라

#### < [아이템81](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item81) > wait 와 notify 보다는 동시성 유틸리티를 애용하라

#### < [아이템82](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item82) > 스레드 안정성 수준을 문서화하라

#### < [아이템83](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item83) > 지연 초기화는 신중히 사용하라

#### < [아이템84](https://github.com/ziippy/EffectiveJava/tree/master/src/chapter11/item84) > 프로그램의 동작을 스레드 스케줄러에 기대지 말라
