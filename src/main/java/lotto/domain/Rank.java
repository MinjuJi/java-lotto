package lotto.domain;

public enum Rank {
    NO_RANK(0, false, 0, "0"), // 1, 2는??
    FIFTH(3, false, 5_000, "5_000"),
    FOURTH(4, false, 50_000, "50_000"),
    THIRD(5, false, 1_500_000, "1_500_000"),
    SECOND(5, true, 30_000_000, "30_000_000"),
    FIRST(6, false, 2_000_000_000, "2_000_000_000");

    final private int count;
    final private boolean isBonus;
    final private long prize;
    final private String convertPrize;

    Rank(int count, boolean isBonus, long prize, String convertPrize) {
        this.count = count;
        this.isBonus = isBonus;
        this.prize = prize;
        this.convertPrize = convertPrize;
    }

    public int getCount() {
        return count;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

    public long getPrize() {
        return prize;
    }

    public String getConvertPrize() {
        return convertPrize;
    }
}
