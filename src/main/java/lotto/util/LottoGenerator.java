package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    public static List<Integer> generatorLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
