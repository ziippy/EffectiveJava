package chapter4.item24;

class Food {
    private int count = 0;
    private int weight = 0;

    static class Banana {
        private int count = 0;
        static int weight = 0;

        Banana(int count, int weight) {
            //Food.this.count += count;       // 불가능
            //Food.this.weight += weight;     // 불가능
            this.count = count;
            this.weight = weight;
        }
    }

    public Food() {
        count = 1;
        weight = 7;
    }

    public void addBanana(Banana banana) {
        count += banana.count;
        weight += Banana.weight;
    }

    public void addBanana(int count, int weight) {
        Banana banana = new Banana(count, weight);
        addBanana(banana);
    }

    @Override
    public String toString() {
        return String.format("Food - count(%d), weight(%d)", count, weight);
    }
}

public class StaticMemberClassTest {

    public static void main(String[] args) {
        Food f = new Food();
        System.out.println(f);

        Food.Banana banana = new Food.Banana(1, 10);
        f.addBanana(banana);
        System.out.println(f);

        /** 출력
         * Food - count(1), weight(7)
         * Food - count(2), weight(17)
         */
    }
}
