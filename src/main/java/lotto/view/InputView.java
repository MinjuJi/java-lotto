package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;
import lotto.exception.UserException;
import lotto.util.InputParser;

import java.util.List;

public class InputView {
    private final OutputView outputView = new OutputView();
    private final InputParser parser = new InputParser();
    private final UserException userException = new UserException();
    private final LottoException lottoException = new LottoException();

    public int askBuyingPrice() {
        try {
            String input = Console.readLine();
            userException.validateBuyingPrice(input);
            return InputParser.numberParser(input);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return askBuyingPrice();
        }
    }

    public List<Integer> askWinningNumbers() {
        try {
            String input = Console.readLine();
            lottoException.validateWinningNumbers(input);
            return InputParser.correctNumbersParser(input);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return null; // return askWinningNumbers(); 하면 안 되나?
        }
    }

    public int askBonusNumber(List<Integer> numbers) {
        try {
            String input = Console.readLine();
            lottoException.validateBonusNumber(input, numbers);
            return InputParser.numberParser(input);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return askBonusNumber(numbers);
        }
    }
}
