package lotto.domain;

public enum LottoInfo {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    FIFTH_WITH_BONUS(6, 30000000),
    SIX(7, 2000000000); // 왜 7이지?

    private final int score;
    private final int prize;

    LottoInfo(int score, int prize) {
        this.score = score;
        this.prize = prize;
    }

    public int getScore() {
        return score;
    }

    public int getPrize() {
        return prize;
    }
}
