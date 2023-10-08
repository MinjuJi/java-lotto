package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputParser;

import java.util.List;

public class InputView {
    public int askBuyingPrice() {
        try {
            String input = Console.readLine();
            // 예외처리
            return InputParser.numberParser(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askBuyingPrice();
        }
    }

    public List<Integer> askCorrectNumbers() {
        try {
            String input = Console.readLine();
            // 예외처리
            return InputParser.correctNumbersParser(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askCorrectNumbers();
        }
    }

    public int askBonusNumber() {
        try {
            String input = Console.readLine();
            // 예외처리
            return InputParser.numberParser(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askBonusNumber();
        }
    }


}
