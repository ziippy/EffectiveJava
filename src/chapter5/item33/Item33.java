package chapter5.item33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}


public class Item33 {

    public static void main(String[] args) {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 8);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);

        System.out.println(favoriteString + " " + favoriteInteger);
        /** 출력
         * Java 8
         */
    }
}
