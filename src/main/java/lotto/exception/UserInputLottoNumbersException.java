package lotto.exception;

import java.util.List;

public class UserInputLottoNumbersException {
    private final static int VALID_LOTTO_LENGTH = 6;
    private final static int VALID_BONUS_LENGTH = 1;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public void validateLotto(String numbers, String bonusNumber) {
        validateLottoNumbersLength(numbers);
    }

    public void validateLottoNumbersLength(String inputNumbers) {
        if (inputNumbers.replace(",", "").length() != VALID_LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumbersRange(List<Integer> inputNumbers) {
        for (int input : inputNumbers) {
            if (input < MIN_LOTTO_NUMBER || input > MAX_LOTTO_NUMBER)
                throw new IllegalArgumentException();
        }
    }
}
