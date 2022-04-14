package chapter2.item2;

import java.util.EnumSet;
import java.util.Set;

abstract class Pizza {
    public enum Topping { HAM, POTATO, ONION }
    final Set<Topping> toppings;

    // 재귀적 타입 한정(item30)을 이용하는 제너릭 타입
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding) 하여 "this" 를 반환하도록 해야 한다.
        // 이를 통하여 하위 클래스에서는 형변환하지 않고도 메서드 연쇄를 지원할 수 있다.
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

// Pizza 하위 클래스 2개
// ChicagoPizza - 크기가 필수 매개변수
// HawaiiPizza - 소스를 안에 넣을지 말지가 필수 매개변수
class ChicagoPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(final Size size) {
            this.size = size;
        }

        @Override
        public ChicagoPizza build() {
            return new ChicagoPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private ChicagoPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public final String toString() {
        return "ChicagoPizza: size - " + this.size + ", toppings - " + this.toppings;
    }
}

class HawaiiPizza extends Pizza {
    private final boolean sourceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sourceInside = false;   // 기본값

        public Builder sourceInside() {
            this.sourceInside = true;
            return this;
        }

        @Override
        public HawaiiPizza build() {
            return new HawaiiPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private HawaiiPizza(Builder builder) {
        super(builder);
        sourceInside = builder.sourceInside;
    }

    @Override
    public final String toString() {
        return "HawaiiPizza: sourceInside - " + this.sourceInside + ", toppings - " + this.toppings;
    }
}

public class BuilderPattern2 {

    public static void main(String[] args) {
        // Food3 클래스는 불변이며, 모든 매개변수의 기본값들을 한곳에 모아 뒀다.
        // 물 흐르듯이 연쇄적으로 호출하면 된다.
        // 이게 빌더 패턴
        ChicagoPizza chicagoPizza = new ChicagoPizza.Builder(ChicagoPizza.Size.LARGE)
                                                    .addTopping(Pizza.Topping.HAM)
                                                    .build();
        HawaiiPizza hawaiiPizza = new HawaiiPizza.Builder()
                .sourceInside()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.ONION)
                .build();

        System.out.println(chicagoPizza);
        System.out.println(hawaiiPizza);

        /** 출력
         * ChicagoPizza: size - LARGE, toppings - [HAM]
         * HawaiiPizza: sourceInside - true, toppings - [HAM, ONION]
         */
    }
}
