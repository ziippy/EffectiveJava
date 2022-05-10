package chapter6.item34;

enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6);

    private final double mass;              // 질량 (단위, 킬로그램)
    private final double radius;            // 반지름 (단위, 미터)
    private final double surfaceGravity;    // 표면중력 (단위, m / s^2)

    // 중력상수 (단위, m^3 / kg s^2)
    private static final double G = 6.67300E-11;

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() { return mass; }
    public double radius() { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;   // F = ma
    }
}


public class EnumTest {

    public static void main(String[] args) {
        System.out.println("Mercury: " + Planet.MERCURY.mass() + " " + Planet.MERCURY.radius());
        System.out.println("Venus: " + Planet.VENUS.mass() + " " + Planet.VENUS.radius());
        /** 출력
         * Mercury: 3.302E23 2439000.0
         * Venus: 4.869E24 6052000.0
         */

        for (Planet p : Planet.values()) {
            System.out.println(p);
        }
        /** 출력
         * MERCURY
         * VENUS
         */
    }
}