package lotto.domain;

import java.util.List;

public class LottoGame {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) { // 생성자에 함께 작성하면 되지 않나? 그에 따라 Servic 클래스의 playLottoGame 메소드 수정 필요
        this.bonusNumber = bonusNumber;
    }
}
