package chapter3.item12;

class BodyInfo {
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
}

class BodyInfoExtend extends BodyInfo {

    public BodyInfoExtend(int age, int weight, int tall) {
        super(age, weight, tall);
    }

    @Override
    public String toString() {
        return String.format("BodyInfoExtend: age(%d), weight(%d), tall(%d)", getAge(), getWeight(), getTall());
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(super.getAge());
        result = 31 * result + Integer.hashCode(super.getWeight());
        result = 31 * result + Integer.hashCode(super.getTall());
        return result;
    }
}

public class Item12 {

    public static void main(String[] args) {
        // 기본 toString
        BodyInfo bi = new BodyInfo(10, 100, 180);
        System.out.println(bi.toString());
        /** 출력
         * chapter3.item12.BodyInfo@41629346
         */

        // 재정의한 toString
        BodyInfoExtend bi2 = new BodyInfoExtend(10, 100, 180);
        System.out.println(bi2.toString());
        /** 출력
         * BodyInfoExtend: age(10), weight(100), tall(180)
         */
    }
}
