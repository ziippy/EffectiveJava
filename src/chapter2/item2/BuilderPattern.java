package chapter2.item2;

class Food3 {
    // 필수정보 - 이름과 가격
    private final String name;
    private final int price;
    // 부가정보 - 칼로리, 나르튬
    private final int calories;
    private final int sodium;

    public static class Builder {
        private final String name;
        private final int price;
        // 부가정보 - 칼로리, 나르튬 -> 0 으로 초기화
        private int calories = 0;
        private int sodium = 0;

        public Builder(final String name, final int price) {
            this.name = name;
            this.price = price;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Food3 build() {
            return new Food3(this);
        }
    }

    private Food3(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.calories = builder.calories;
        this.sodium = builder.sodium;
    }

    @Override
    public final String toString() {
        return "Food3: name - " + this.name + ", price - " + this.price + ", calories - " + this.calories + ", sodium - " + this.sodium;
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
        // Food3 클래스는 불변이며, 모든 매개변수의 기본값들을 한곳에 모아 뒀다.
        // 물 흐르듯이 연쇄적으로 호출하면 된다.
        // 이게 빌더 패턴
        Food3 food = new Food3.Builder("noodle", 500)
                            .calories(100)
                            .sodium(20)
                            .build();
        System.out.println(food);

        /** 출력
         * Food3: name - noodle, price - 500, calories - 100, sodium - 20
         */
    }
}
