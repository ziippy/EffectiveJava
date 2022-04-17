## 2장 - 객체 생성과 파괴

### <아이템9 > try-finally 보다는 try-with-resources 를 사용하라

> **(요약)** 꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고, try-with-resources 를 사용하자.

자바 라이브러리에는 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많다.

- InputStream
- OutputStream
- java.sql.Connection 등...

전통적으로 자원이 제대로 닫힘을 보장하는 수단으로 <span style="color:skyblue">try-finally</span> 가 쓰였다.

But, 2개 이상의 자원을 사용하는 경우에는 try-finally 방식은 코드가 지저분하다.

<span style="color:skyblue">try-with-resources</span> 방식이 짧고 읽기 수월할 뿐 아니라 문제를 진단하기도 훨씬 좋다.

코드: [Item9.java](https://github.com/ziippy/EffectiveJava/blob/master/src/chapter2/item9/Item9.java)




