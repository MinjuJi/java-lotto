package lotto.validation;

public class Validation {
    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException();
        }
    }
}
