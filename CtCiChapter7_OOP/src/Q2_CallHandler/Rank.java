package Q2_CallHandler;

public enum Rank {
    Responder(0), Manager(1), Director(2);
    private int rank;

    private Rank(int r) {
        rank = r;
    }

    public int getRank() {
        return rank;
    }
}
