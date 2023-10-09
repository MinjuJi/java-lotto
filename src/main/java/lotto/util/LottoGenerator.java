package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<UserLotto> generatorUserLotto(int quantity) {
        List<UserLotto> userLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            userLotto.add(new UserLotto(createLotto()));
        }
        return userLotto;
    }

    private static List<Integer> createLotto() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
