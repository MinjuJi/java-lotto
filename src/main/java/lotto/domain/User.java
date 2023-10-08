package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;

public class User {
    private final int buyingPrice;
    private final List<UserLotto> lotto;

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;
        this.lotto = LottoGenerator.generatorUserLotto(getLottoQuantity());
    }

    private int getLottoQuantity() {
        return this.buyingPrice / 1000;
    }
}
