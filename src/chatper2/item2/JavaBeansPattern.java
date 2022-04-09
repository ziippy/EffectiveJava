package chatper2.item2;

class Food2 {
    // 필수정보 - 이름과 가격
    private String name = "";
    private int price = 0;
    // 부가정보 - 칼로리, 나르튬
    private int calories = 0;
    private int sodium = 0;

    public Food2() { }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public void setCalories(final int calories) {
        this.calories = calories;
    }

    public void setSodium(final int sodium) {
        this.sodium = sodium;
    }

    @Override
    public final String toString() {
        return "Food2: name - " + this.name + ", price - " + this.price + ", calories - " + this.calories + ", sodium - " + this.sodium;
    }
}

public class JavaBeansPattern {

    public static void main(String[] args) {
        // 아래처럼 기본 생성자 호출 후 세터 메서드를 호출해서 값을 설정한다.
        // 이게 자바빈즈 생성자 패턴
        Food2 food = new Food2();
        food.setName("noodle");
        food.setPrice(500);

        System.out.println(food);

        /** 출력
         * Food2: name - noodle, price - 500, calories - 0, sodium - 0
         */
    }
}
