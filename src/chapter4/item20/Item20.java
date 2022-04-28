package chapter4.item20;

import java.time.Instant;

class Song {
    private final String title;

    public Song(String title) {
        this.title = title;
    }
}

class AudioClip extends  Song {
    public AudioClip(String title) {
        super(title);
    }
}
interface Singer {
    AudioClip sing(Song s);
}

interface SongWriter {
    Song compose(int chartPosition);
}

interface SingerSongWriter extends Singer, SongWriter {
    AudioClip strum();
    void actSensitive();
}

public class Item20 {

    public static void main(String[] args) {
        SingerSongWriter ssw = new SingerSongWriter() {
            @Override
            public AudioClip strum() {
                return null;
            }

            @Override
            public void actSensitive() {

            }

            @Override
            public AudioClip sing(Song s) {
                return null;
            }

            @Override
            public Song compose(int chartPosition) {
                return null;
            }
        };
    }
}
