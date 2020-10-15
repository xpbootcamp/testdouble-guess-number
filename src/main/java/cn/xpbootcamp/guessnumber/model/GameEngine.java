package cn.xpbootcamp.guessnumber.model;

public class GameEngine {
    private static final String RESULT_FORMATTER = "%dB%dX";
    private static final int DEFAULT_ROUNDS = 6;
    private final Answer answer;
    private boolean isWon = false;
    private int availableRounds;

    public GameEngine(Answer answer) {
        this.availableRounds = DEFAULT_ROUNDS;
        this.answer = answer;
    }

    /*待实现部分*/
    public String guess(Answer inputAnswer) {
        throw new RuntimeException();
    }

    /*待实现部分*/
    public boolean hasNextRound() {
        throw new RuntimeException();
    }

    /*待实现部分*/
    public boolean isWon() {
        throw new RuntimeException();
    }

    /*待实现部分*/
    public boolean canCompareTo(Answer inputAnswer) {
        throw new RuntimeException();
    }
}
