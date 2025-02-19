package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Validation {

    public static void validateListNumberInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (int number : numbers) {
            validateNumberInRange(number, startInclusive, endInclusive);
        }
    }

    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            ErrorMessage.numberInRangeError(startInclusive, endInclusive);
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicationList(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            ErrorMessage.duplicationListError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateLengthOfList(List<Integer> list, int length) {
        if (list.size() != length) {
            ErrorMessage.lengthError(length);
            throw new IllegalArgumentException();
        }
    }

    public static void validateMultipleNumber(int dividend, int divisor) { // 메소드명, 인자명 수정 필요해보임
        if (dividend < divisor || dividend % divisor != 0) {
            ErrorMessage.multipleNumberError(divisor);
            throw new IllegalArgumentException();
        }
    }

    public static void validateExceedNumber(int number, int limitNumber) { // 메소드명, 인자명 수정 필요해보임
        if (number > limitNumber) {
            ErrorMessage.exceedError(limitNumber);
            throw new IllegalArgumentException();
        }
    }

    public static void validateListStringToInteger(List<String> list) {
        for (String string : list) {
            validateStringToInteger(string);
        }
    }

    public static void validateStringToInteger(String string) {
        if (!string.chars()
                   .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicatedNumberInList(List<Integer> list, int number) {
        if (list.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
