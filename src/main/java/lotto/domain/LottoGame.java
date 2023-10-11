package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

public class LottoGame {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) { // 생성자에 함께 작성하면 되지 않나? 그에 따라 Servic 클래스의 playLottoGame 메소드 수정 필요
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        Validation.validateLengthOfList(winningNumbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateListNumberInRange(winningNumbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
    }

    public void validateBonusNumber(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        Validation.validateDuplicatedNumberInList(winningNumbers, bonusNumber);
    }
}
