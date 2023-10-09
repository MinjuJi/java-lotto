package lotto.exception;

import lotto.view.OutputView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException {
    private final OutputView outputView = new OutputView();
    private static final int VALID_LOTTO_LENGTH = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String ERROR = "[ERROR]";


    public void validateWinningNumbers(String input) {
        checkOverlapNumbers(input);
        checkValidSize(input);
        checkWinningNumber(input);
    }

    public void validateBonusNumber(String input, List<Integer> numbers) {
        checkContainedOnlyDigit(input);
        checkBonusNumberRange(input);
        checkOverlapInCorrectNumbers(input, numbers);
    }

    private void checkBonusNumberRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            exception("1~45 숫자로 이루어져야 합니다.");
        }

    }

    private void checkOverlapInCorrectNumbers(String input, List<Integer> numbers) {
        int bonusNumber = Integer.parseInt(input);
        if (numbers.contains(bonusNumber)) {
            exception("보너스 번호가 중복됩니다.");
        }
    }

    private void checkOverlapNumbers(String input) {
        String[] numbers = input.split(",");
        Set<String> overlap = new HashSet<>();
        overlap.addAll(Arrays.asList(numbers));
        if (overlap.size() != VALID_LOTTO_LENGTH) {
            exception("중복된 수가 있으면 안됩니다.");
        }
    }

    private void checkValidSize(String input) {
        if (input.split(",").length != VALID_LOTTO_LENGTH) {
            exception("로또의 번호는 6개만 입력해야 합니다.");
        }
    }

    private void checkWinningNumber(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            checkContainedOnlyDigit(number);
            checkNumberRange(number);
        }
    }

    private void checkContainedOnlyDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                exception("숫자로만 이루어져야 합니다.");
            }
        }
    }

    private void checkNumberRange(String number) {
        int num = Integer.parseInt(number);
        if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
            exception("1~45 숫자로 이루어져야 합니다.");
        }
    }

    private void exception(String message) {
        throw new IllegalArgumentException(message);
    }
}
