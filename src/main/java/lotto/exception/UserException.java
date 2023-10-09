package lotto.exception;

public class UserException {

    public void validateBuyingPrice(String input) {
        checkContainsOnlyDigits(input);
        checkPriceIsNotZero(input);
        checkPrice(input);
    }

    private void checkContainsOnlyDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                exception("구입 금액은 숫자로 이루어져야 합니다.");
            }
        }
    }

    private void checkPriceIsNotZero(String input) {
        int price = Integer.parseInt(input);
        if (price == 0) {
            exception("구입 최소 금액은 1000원입니다.");
        }
    }

    private void checkPrice(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            exception("구입 금액은 1000원 단위입니다.");
        }
    }

    private void exception(String message) {
        throw new IllegalArgumentException(message);
    }
}
