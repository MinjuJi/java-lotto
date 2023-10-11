package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.utils.Utils;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Service {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_LEAST_AMOUNT = 1_000; // 변수명 수정 필요
    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;

    Buyer buyer; // 접근제어자 안 붙이는 이유
    LottoGame lottoGame;

    public void initBuyer() {
        buyer = new Buyer(getInputAmount());
    }

    public int getInputAmount() {
        InputMessage.inputAmount();
        String userInput = readLine().trim(); // trim() 하는 이유
        return Utils.stringToInteger(userInput);
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
        List<Integer> numbers = new ArrayList<>(Utils.generateRandomUniqueNumber(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH));
        Utils.sortListNaturalOrder(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getInputWinningNumbers() {
        InputMessage.inputWinningNumbers();
        return Utils.stringToIntegerList(readLine().trim());
    }

    public int getInputBonusNumber() {
        InputMessage.inputBonusNumber();
        return Utils.stringToInteger(readLine().trim());
    }

    public void playLottoGame() {
        lottoGame = new LottoGame(getInputWinningNumbers());
        lottoGame.setBonusNumber(getInputBonusNumber());
    }

    public int countCorrectLottoNumbers(Lotto lotto) {
        return Utils.countSameElements(lottoGame.getWinningNumbers(), lotto.getNumbers());
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers()
                    .contains(lottoGame.getBonusNumber());
    }

    public void checkBuyerLotteries() { // result가 메소드 내에서만 존재하지 않나?
        HashMap<Rank, Integer> result = buyer.getLottoResult();

        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            Rank rank = determineLottoRank(lotto);
            result.put(rank, result.getOrDefault(rank, COUNT_ZERO) + COUNT_ONE);
        }
    }

    public Rank determineLottoRank(Lotto lotto) {
        int correctCount = countCorrectLottoNumbers(lotto);
        boolean correctBonusNumber = containsBonusNumber(lotto);

        for (Rank rank : Rank.values()) {
            if (correctCount == rank.getCount() && correctBonusNumber == rank.getIsBonus()) {
                return rank;
            }
        }
        return Rank.NO_RANK;
    }


    public void showGameResult() {
        OutputMessage.winningStatistics();
        OutputMessage.showRankResult(buyer.getLottoResult());
        OutputMessage.showYieldResult(buyer.getYield());
    }
}
