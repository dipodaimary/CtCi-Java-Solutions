package Q3_JukeBox;

public class CDPlayer {
    private Playlist p;
    private CD c;

    public Playlist getPlayList() {
        return p;
    }

    public void setPlayList(Playlist p) {
        this.p = p;
    }

    public CD getCD() {
        return c;
    }

    public void setCD(CD c) {
        this.c = c;
    }

    public CDPlayer(CD c, Playlist p) {
        this.c = c;
        this.p = p;
    }

    public CDPlayer(Playlist p) {
        this.p = p;
    }

    public CDPlayer(CD c) {
        this.c = c;
    }

    public void playSong(Song s) {

    }
}
