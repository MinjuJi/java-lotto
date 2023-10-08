package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<UserLotto> generatorUserLotto(int quantity) {
        List<UserLotto> userLotto = new ArrayList<>();
        for(int i=0; i<quantity; i++){
            userLotto.add(new UserLotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return userLotto;
    }
}
