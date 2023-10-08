package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;

public class User {
    private final int buyingPrice;
    private final List<UserLotto> lottos;

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;
        this.lottos = createLottos();
    }

    private List<UserLotto> createLottos() {
        return LottoGenerator.generatorUserLotto(getLottoQuantity());
    }

    private int getLottoQuantity() {
        return this.buyingPrice / 1000;
    }
}
