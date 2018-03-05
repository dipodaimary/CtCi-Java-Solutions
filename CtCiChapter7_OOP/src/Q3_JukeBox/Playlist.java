package Q3_JukeBox;

import java.util.Queue;

public class Playlist {
    private Song song;
    private Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        super();
        this.song = song;
        this.queue = queue;
    }

    public Song getSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song song) {
        queue.add(song);
    }
}
