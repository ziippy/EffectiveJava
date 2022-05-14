package chapter6.item37;


import java.util.*;

class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    Plant(final String name, final LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override public String toString() {
        return name;
    }
}

public class Item37 {

    public static void main(String[] args) {
        // ordinal() 을 배열 인덱스로 사용 - 절대 따라 하지 말 것!
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        List<Plant> garden = new ArrayList<>();
        garden.add(new Plant("rose", Plant.LifeCycle.ANNUAL));
        garden.add(new Plant("tulip", Plant.LifeCycle.ANNUAL));
        garden.add(new Plant("sunflower", Plant.LifeCycle.PERENNIAL));

        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // 결과 출력
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s\n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
        /** 출력
         * ANNUAL: [tulip, rose]
         * PERENNIAL: [sunflower]
         * BIENNIAL: []
         */

        // EnumMap 을 사용한 코드
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle2 = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle2.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle2.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle2);
        /** 출력
         * {ANNUAL=[tulip, rose], PERENNIAL=[sunflower], BIENNIAL=[]}
         */
    }
}
