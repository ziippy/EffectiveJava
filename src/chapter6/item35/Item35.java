package chapter6.item35;


public class Item35 {

    // ordinal 을 잘못 사용한 예 - 따라 하지 말 것!
    public enum Ensemble {
        SOLO, DUET, TRIO, QUARTET;

        public int numberOfMusicians() {
            return ordinal() + 1;
        }
    }

    // 만약에 Ensemble2 처럼 중간에 TRIPPLE_QUARTET 를 넣으면 값이 바껴버린다.
    public enum Ensemble2 {
        SOLO, DUET, TRIO, TRIPPLE_QUARTET, QUARTET;

        public int numberOfMusicians() {
            return ordinal() + 1;
        }
    }

    // 인스턴스 필드에 저장하는 방식 - 굿~
    public enum EnsembleGood {
        SOLO(1), DUET(2), TRIO(3), TRIPPLE_QUARTET(5), QUARTET(4);

        private final int numberOfMusicians;
        EnsembleGood(final int size) {
            this.numberOfMusicians = size;
        }
        public int numberOfMusicians() {
            return numberOfMusicians;
        }
    }

    public static void main(String[] args) {
        System.out.println(Ensemble.SOLO.numberOfMusicians());
        System.out.println(Ensemble.QUARTET.numberOfMusicians());
        /** 출력
         * 1
         * 4
         */

        System.out.println(Ensemble2.SOLO.numberOfMusicians());
        System.out.println(Ensemble2.QUARTET.numberOfMusicians());
        /** 출력
         * 1
         * 5
         */

        System.out.println(EnsembleGood.SOLO.ordinal());
        System.out.println(EnsembleGood.QUARTET.ordinal());
        /** 출력
         * 0
         * 4
         */

        // Good 코드
        System.out.println(EnsembleGood.SOLO.numberOfMusicians());
        System.out.println(EnsembleGood.QUARTET.numberOfMusicians());
        /** 출력
         * 1
         * 4
         */
    }
}
