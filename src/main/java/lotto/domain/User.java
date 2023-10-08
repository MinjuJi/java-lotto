package lotto.domain;

import java.util.List;

public class User {
    private int buyingPrice;
    private List<UserLotto> lottos;

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
}
