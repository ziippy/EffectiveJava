package chapter8.item51;

import java.io.IOException;
import java.util.Date;

class Thermometer {
    boolean isFahrenheit;   // true 이면 화씨온도(Fahrenheit), false 이면 섭씨온도(Celsius)

    public Thermometer(boolean isFahrenheit) {
        this.isFahrenheit = isFahrenheit;
    }
}


enum TemperatureScale {
    FAHRENHEIT,
    CELSIUS
}
class Thermometer2 {
    TemperatureScale scale;

    public Thermometer2(TemperatureScale scale) {
        this.scale = scale;
    }
}

public class Item51 {

    public static void main(String[] args) {

        // 섭씨온도계를 만들 때
        Thermometer t = new Thermometer(false);       // 이렇게 false 로 하면 섭시온도계

        // 이렇게 boolean 으로 하는 것보단, 원소 2개짜리 열거 타입이 낫다.

        Thermometer2 t2 = new Thermometer2(TemperatureScale.CELSIUS);     // 이렇게 하면 코드를 읽고 쓰기도 훨씬 더 쉬어진다.
    }
}

