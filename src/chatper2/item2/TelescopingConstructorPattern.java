package chatper2.item2;

class Food {
    // 필수정보 - 이름과 가격
    private final String name;
    private final int price;
    // 부가정보 - 칼로리, 나르튬
    private final int calories;
    private final int sodium;

    public Food(final String name, final int price) {
        this(name, price, 0, 0);
    }

    public Food(final String name, final int price, final int calories) {
        this(name, price, calories, 0);
    }

    public Food(final String name, final int price, final int calories, final int sodium) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.sodium = sodium;
    }

    @Override
    public final String toString() {
        return "Food: name - " + this.name + ", price - " + this.price + ", calories - " + this.calories + ", sodium - " + this.sodium;
    }
}

public class TelescopingConstructorPattern {

    public static void main(String[] args) {
        // 아래처럼 원하는 매개변수 개수에 해당하는 생성자를 골라서 쓰면 된다.
        // 이게 점층적 생성자 패턴
        Food food1 = new Food("kimchi", 100);
        Food food2 = new Food("noodle", 500, 100);

        System.out.println(food1);
        System.out.println(food2);

        /** 출력
         * Food: name - kimchi, price - 100, calories - 0, sodium - 0
         * Food: name - noodle, price - 500, calories - 100, sodium - 0
         */
    }
}
