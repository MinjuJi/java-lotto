package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Service {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_LEAST_AMOUNT = 1_000; // 변수명 수정 필요
    private static final int LOTTO_MAX_AMOUNT = 100_000; // 변수명 수정 필요

    Buyer buyer; // 접근제어자 안 붙이는 이유
    LottoGame lottoGame;

    public void initBuyer() {
        buyer = new Buyer(getInputAmount());
    }

    public int getInputAmount() {
        InputMessage.inputAmount();
        int amount = Integer.parseInt(readLine().trim()); // trim() 하는 이유

        Validation.validateMultipleNumber(amount, LOTTO_LEAST_AMOUNT);
        Validation.validateExceedNumber(amount, LOTTO_MAX_AMOUNT);

        return amount;
    }

    public void buyAllLotto() {
        int count = (buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT); // 메소드로 분리
        for (int i = count; i > 0; i--) {
            buyOneLotto();
        }
    }

    public void buyOneLotto() {
        Lotto lotto = generateLottoNumber();
        buyer.buyLotto(lotto);
    }

    public void showBuyingResult() {
        OutputMessage.purchaseComplete(buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT); // 메소드로 분리
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            OutputMessage.lottoNumbers(lotto.getNumbers());
        }
    }

    public Lotto generateLottoNumber() {
        List<Integer> numbers = Utils.generateRandomUniqueNumber(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH);

        Validation.validateLengthOfList(numbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(numbers);
        Validation.validateListNumberInRange(numbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);

        Utils.sortListNaturalOrder(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getInputWinningNumbers() {
        InputMessage.inputWinningNumbers();
        String userInput = readLine().trim();

        Validation.validateListStringToInteger(Arrays.asList(userInput.split(",")));

        List<Integer> winningNumbers = Utils.stringToIntegerList(userInput);

        Validation.validateLengthOfList(winningNumbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateListNumberInRange(winningNumbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);

        return winningNumbers;
    }

    public int getInputBonusNumber() {
        InputMessage.inputBonusNumber();
        String userInput = readLine().trim();

        Validation.validateStringToInteger(userInput);

        int bonusNumber = Integer.parseInt(userInput);

        Validation.validateNumberInRange(bonusNumber, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);

        return bonusNumber;
    }

    public void playLottoGame() {
        lottoGame = new LottoGame(getInputWinningNumbers());
        int bonusNumber = getInputBonusNumber();

        Validation.validateDuplicatedNumberInList(lottoGame.getWinningNumbers(), bonusNumber);

        lottoGame.setBonusNumber(bonusNumber);
    }

    public int countCorrectLottoNumbers(Lotto lotto) {
        return Utils.countSameElements(lottoGame.getWinningNumbers(), lotto.getNumbers());
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers()
                    .contains(lottoGame.getBonusNumber());
    }
}
