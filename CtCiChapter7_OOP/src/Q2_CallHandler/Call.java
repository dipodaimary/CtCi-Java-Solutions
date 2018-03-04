package Q2_CallHandler;

public class Call {
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller c) {
        rank = Rank.Responder;
        caller = c;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public Rank getRank() {
        return rank;
    }

    public void reply(String message) {
        System.out.println(message);
    }

    public Rank incrementRank() {
        if (rank == Rank.Responder) {
            rank = Rank.Manager;
        } else if (rank == Rank.Manager) {
            rank = Rank.Director;
        }
        return rank;
    }

    public void disconnect() {
        reply("Thank you for calling.");
    }
}
