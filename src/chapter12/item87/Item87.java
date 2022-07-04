package chapter12.item87;

import chapter6.item35.Item35;

import java.io.*;

// 기본 직렬화 형태에 적합한 후보
// 성명은 논리적으로 이름, 성, 중간이름이라는 3개의 문자열로 구성되며, 앞 코드의 인스턴스 필드들은 이 논리적 구성요소를 정확히 반영했기 때문이다.
class Name implements Serializable {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}

// 기본 직렬화 형태에 적합하지 않은 클래스
// 이 클래스에 기본 직렬화 형태를 사용하면 각 노드의 양방향 연결 정보를 포함해 모든 엔트리(Entry)를 철두철미하게 기록한다.
class StringList implements Serializable {
    private int Size = 0;
    private Entry head = null;

    private static class Entry implements Serializable {
        String data;
        Entry next;
        Entry previous;
    }
}

// 합리적인 커스텀 직렬화 형태를 갖춘 StringListCustom
class StringListCustom implements Serializable {
    private transient int size = 0;         // transient 키워드를 통해 Serialize 하는 과정에서 제외
    private transient Entry head = null;    // transient 키워드를 통해 Serialize 하는 과정에서 제외

    private static class Entry {    // 이제는 직렬화되지 않는다.
        String data;
        Entry next;
        Entry previous;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();     // 이 작업은 무조건 하라고 직렬화 명세에 있다.
        s.writeInt(size);
        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }
}

public class Item87 {

    public static void main(String[] args) throws InterruptedException {

        Name name = new Name("Jongsung", "Kim", null);
        // Serializable 테스트
        try
        {
            FileOutputStream fos = new FileOutputStream("test.txt");
            ObjectOutput oo = new ObjectOutputStream(fos);
            oo.writeObject(name);
            oo.flush();
            oo.close();
            fos.close();
        }
        catch(Exception e) { }
        /** Serializable 테스트를 하고 test.txt 파일 내용을 보면 다음과 같다.
         * ы sr chapter12.item87.Name왚??7C L 	firstNamet Ljava/lang/String;L lastNameq ~ L
         * middleNameq ~ xpt Kimt Jongsungp
         */

        StringList sList = new StringList();
        // Serializable 테스트
        try
        {
            FileOutputStream fos = new FileOutputStream("test2.txt");
            ObjectOutput oo = new ObjectOutputStream(fos);
            oo.writeObject(sList);
            oo.flush();
            oo.close();
            fos.close();
        }
        catch(Exception e) { }
        /** Serializable 테스트를 하고 test2.txt 파일 내용을 보면 다음과 같다.
         * ы sr chapter12.item87.StringList\cy??? I SizeL headt #Lchapter12/item87/StringList$Entry;xp    p
         */

        StringListCustom sListCustom = new StringListCustom();
        // Serializable 테스트
        try
        {
            FileOutputStream fos = new FileOutputStream("test3.txt");
            ObjectOutput oo = new ObjectOutputStream(fos);
            oo.writeObject(sListCustom);
            oo.flush();
            oo.close();
            fos.close();
        }
        catch(Exception e) { }
        /** Serializable 테스트를 하고 test3.txt 파일 내용을 보면 다음과 같다.
         * ы sr !chapter12.item87.StringListCustom`?M??  xpw    x
         */
    }

}

