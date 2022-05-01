package chapter4.item24;

class Food2 {
    private int count = 0;
    private int weight = 0;

    class Banana {
        int count = 0;
        int weight = 0;
        Banana(int count, int weight) {
            this.count = count;
            this.weight = weight;
            //
            Food2.this.count += count;       // 가능
            Food2.this.weight += weight;     // 가능
        }
    }

    public Food2() {
        count = 1;
        weight = 7;
    }

    public void addBanana(Banana banana) {
        count += banana.count;
        weight += banana.weight;
    }

    public void addBanana(int count, int weight) {
        Banana banana = new Banana(count, weight);
    }

    @Override
    public String toString() {
        return String.format("Food2 - count(%d), weight(%d)", count, weight);
    }
}

public class NonStaticMemberClassTest {

    public static void main(String[] args) {
        Food2 f = new Food2();
        System.out.println(f);

        //Food2.Banana banana = new Food2.Banana(1, 10);      // 불가능
        //f.addBanana(banana);
        f.addBanana(1, 10);
        System.out.println(f);

        /** 출력
         * Food - count(1), weight(7)
         * Food - count(2), weight(17)
         */
    }
}
