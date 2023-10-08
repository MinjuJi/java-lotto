package lotto.exception;

public class UserInputLottoNumbersException {
    private final static int VALID_LOTTO_LENGTH = 6;
    private final static int VALID_BONUS_LENGTH = 1;

    public void validateLotto(String numbers, String bonusNumber) {
        validateLottoNumbersLength(numbers);
    }

    public void validateLottoNumbersLength(String inputNumbers) {
        if (inputNumbers.replace(",", "").length() != VALID_LOTTO_LENGTH)
            throw new IllegalArgumentException();
    }
}
