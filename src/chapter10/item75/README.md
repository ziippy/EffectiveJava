## 10장 - 예외

### <아이템75 > 예외의 상세 메시지에 실패 관련 정보를 담으라

> **(요약)** 예외의 상세 메시지에 실패 관련 정보를 담으라

예외를 잡지 못해 프로그램이 실패하면 자바 시스템은 그 예외의 스택 추적(stack trace) 정보를 자동으로 출력한다.

스택 추적은 예외 객체의 toString 메시서드를 호출해 얻는 문자열로, 보통은 예외의 클래스 이름 뒤에 상세 메시지가 붙는 형태다.

**실패 순간을 포착하려면 발생한 예외에 관여된 모든 매개변수와 필드의 값을 실패 메시지에 담아야 한다.**

관련 데이터를 모두 담아야 하지만 장황할 필요는 없다.
