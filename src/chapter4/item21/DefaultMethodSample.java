package chapter4.item21;

interface Car {
    void setName(String name);
    String getName();
    default boolean hasName() {
        return !(getName() == null || getName().isEmpty());
    }
}

class HyundaiCar implements Car {
    private String name;

    public HyundaiCar() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class SamsungCar implements Car {
    private String name;

    public SamsungCar() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class RandomCar implements Car {
    private String name;

    public RandomCar() {
        this.name = "RandomCar";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // 필요 시 오버라이딩 해서 변경해서 쓸 수 도 있음.
    public boolean hasName() {
        return !name.equalsIgnoreCase("RandomCar");
    }
}

public class DefaultMethodSample {

    public static void main(String[] args) {
        HyundaiCar hCar = new HyundaiCar();
        hCar.setName("Sonata");
        System.out.println(hCar.hasName());
        /** 출력
         * true
         */

        SamsungCar sCar = new SamsungCar();
        System.out.println(sCar.hasName());
        /** 출력
         * false
         */

        RandomCar rCar = new RandomCar();
        System.out.println(rCar.getName());
        System.out.println(rCar.hasName());
        /** 출력
         * RandomCar
         * false
         */
    }
}
