package chapter3.item13;

class BodyInfo implements Cloneable {
    private final int age, weight, tall;

    public BodyInfo(int age, int weight, int tall) {
        this.age = age;
        this.weight = weight;
        this.tall = tall;
    }

    public int getAge() { return this.age; }
    public int getWeight() { return this.weight; }
    public int getTall() { return this.tall; }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BodyInfo)) {
            return false;
        }
        BodyInfo tmp = (BodyInfo) o;
        return this.age == tmp.age && this.weight == tmp.weight && this.tall == tmp.tall;
    }

    @Override
    public BodyInfo clone() {
        try {
            return (BodyInfo) super.clone();
        } catch(CloneNotSupportedException e) {
            throw new AssertionError(); // 일어날 수 없는 일이다.
        }
    }
}

public class Item13 {

    public static void main(String[] args) {
        // clone 테스트
        BodyInfo bi = new BodyInfo(10, 100, 180);
        BodyInfo bi2 = bi.clone();
        System.out.println(bi != bi2);
        System.out.println(bi.equals(bi2));
        System.out.println(bi.getClass() == bi2.getClass());
        /** 출력
         * true
         * true
         * true
         */
    }
}
