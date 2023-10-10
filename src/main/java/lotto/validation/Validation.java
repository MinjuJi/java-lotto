package lotto.validation;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicationList(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLengthOfList(List<Integer> list, int length) {
        if (list.size() != length) {
            throw new IllegalArgumentException();
        }
    }
}
