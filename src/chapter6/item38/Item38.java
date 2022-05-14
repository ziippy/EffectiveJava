package chapter6.item38;


import java.util.*;

interface Operation {
    double apply(double x, double y);
}

enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override public String toString() {
        return symbol;
    }
}

enum ExtendedOperation implements Operation {
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override public String toString() {
        return symbol;
    }
}

public class Item38 {

    public static void main(String[] args) {
        double x = 10.0;
        double y = 2.5;

        test(BasicOperation.class, x, y);
        /** 출력
         * 10.000000 + 2.500000 = 12.500000
         * 10.000000 - 2.500000 = 7.500000
         */
        test(ExtendedOperation.class, x, y);
        /** 출력
         * 10.000000 * 2.500000 = 25.000000
         * 10.000000 / 2.500000 = 4.000000
         */
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f\n", x, op, y, op.apply(x, y));
        }
    }
}
