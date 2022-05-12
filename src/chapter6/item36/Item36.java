package chapter6.item36;


import java.util.EnumSet;
import java.util.Set;

// 비트 필드를 대체하는 EnumSet 을 활용하는 현대적 기법
class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKE }

    public void applyStyles(Set<Style> styles) {
        // 작업업
        System.out.println(styles);
    }
}

public class Item36 {



    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.UNDERLINE));
        /** 출력
         * [BOLD, UNDERLINE]
         */
    }
}
