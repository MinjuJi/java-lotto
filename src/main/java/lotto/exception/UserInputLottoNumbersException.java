package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputLottoNumbersException {
    private final static int VALID_LOTTO_LENGTH = 6;
    private final static int VALID_BONUS_LENGTH = 1;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public void validateLotto(String inputNumbers, String inputBonusNumber) {
        validateLottoNumbersLength(inputNumbers);
        validateBonusNumberLength(inputBonusNumber);
        validateNumbersRange();
        validateOverlapNumbers();
    }

    public void validateLottoNumbersLength(String inputNumbers) {
        if (inputNumbers.replace(",", "").length() != VALID_LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력 가능합니다.");
        }
    }

    public void validateBonusNumberLength(String inputBonusNumber) {
        if (inputBonusNumber.length() != VALID_BONUS_LENGTH) {
            throw new IllegalArgumentException("보너스 번호는 1개만 입력 가능합니다.");
        }
    }

    public void validateNumbersRange(List<Integer> inputNumbers) {
        for (int input : inputNumbers) {
            if (input < MIN_LOTTO_NUMBER || input > MAX_LOTTO_NUMBER)
                throw new IllegalArgumentException("로또 숫자의 범위는 1~45입니다.");
        }
    }

    public void validateOverlapNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (Integer inputNumber : inputNumbers) {
            numbers.add(inputNumber);
        }
        if (numbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안 됩니다.");
        }
    }
}
