package Q3_JukeBox;

public class SongSelector {
    private Song currentSong;

    public SongSelector(Song s) {
        currentSong = s;
    }

    public void setSong(Song s) {
        this.currentSong = s;
    }

    public Song getCurrentSong() {
        return this.currentSong;
    }
}
