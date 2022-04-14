package chapter2.item5;

abstract class Dictionary {
    abstract public String getCode();
}
class EnglishDictionary extends Dictionary {
    public String getCode() { return "ENG"; }
}
class KoreanDictionary extends Dictionary {
    public String getCode() { return "KOR"; }
}

class SpellChecker {
    private static final Dictionary dictionary = new KoreanDictionary();
    private SpellChecker() {} // 객체 생성 방지

    public static String getLanguageCode() { return dictionary.getCode(); }
}

class SpellCheckerMultiNotGood {
    private static Dictionary dictionary = null;
    private SpellCheckerMultiNotGood() {} // 객체 생성 방지

    public static String getLanguageCode() { return dictionary.getCode(); }

    public static void setDictionary(Dictionary dict) { dictionary = dict; }
}

class SpellCheckerMultiGood {
    private final Dictionary dictionary;

    public SpellCheckerMultiGood(Dictionary dict) {
        this.dictionary = dict;
    }

    public String getLanguageCode() { return dictionary.getCode(); }
}

public class Item5 {

    public static void main(String[] args) {
        // SpellChecker 클래스는 오직 Korean 에 대해서만 있다.
        System.out.println(SpellChecker.getLanguageCode());
        /** 출력
         * KOR
         */

        // 이를 언어별로 할 수 있는 SpellChecker 를 만들고자 하면?
        // 단순히 final 한정자를 제거하고 사전을 설정할 수 있는 메서드를 추가 한 SpellCheckerMultiNotGood
        // 이는 오류를 내기 쉬우며, 멀티스레드 환경에서는 쓸 수 없음
        EnglishDictionary englishDictionary = new EnglishDictionary();
        KoreanDictionary koreanDictionary = new KoreanDictionary();
        SpellCheckerMultiNotGood.setDictionary(englishDictionary);
        System.out.println(SpellCheckerMultiNotGood.getLanguageCode());
        // ...
        SpellCheckerMultiNotGood.setDictionary(koreanDictionary);
        System.out.println(SpellCheckerMultiNotGood.getLanguageCode());
        /** 출력
         * ENG
         * KOR
         */

        // 의존 객체 주입 패턴을 사용한 SpellCheckerMultiGood
        //SpellCheckerMultiGood spellCheckerMultiGood = new SpellCheckerMultiGood();  // 이렇게는 안된다.

        SpellCheckerMultiGood spellCheckerMultiGood1 = new SpellCheckerMultiGood(new EnglishDictionary());
        System.out.println(spellCheckerMultiGood1.getLanguageCode());

        SpellCheckerMultiGood spellCheckerMultiGood2 = new SpellCheckerMultiGood(new KoreanDictionary());
        System.out.println(spellCheckerMultiGood2.getLanguageCode());
        /** 출력
         * ENG
         * KOR
         */
    }
}
