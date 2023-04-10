public class Turn {
    private String turn;
    private int turnsPlayed;

    public Turn(String turn, int turnsPlayed) {
        this.turn = turn;
        this.turnsPlayed = turnsPlayed;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public int getTurnsPlayed() {
        return turnsPlayed;
    }

    public void setTurnsPlayed(int turnsPlayed) {
        this.turnsPlayed = turnsPlayed;
    }
}