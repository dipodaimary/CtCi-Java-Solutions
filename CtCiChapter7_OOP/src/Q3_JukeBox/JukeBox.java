package Q3_JukeBox;

import java.util.Set;

public class JukeBox {
    private CDPlayer cdPlayer;
    private User user;
    Set<CD> cdCollection;
    SongSelector ts;

    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
        super();
        this.cdCollection = cdCollection;
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.ts = ts;
    }

    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }

    public void setUser(User u) {
        this.user = u;
    }
}
