package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static int numberParser(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> correctNumbersParser(String input) {
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split(","))
              .map(Integer::parseInt)
              .forEach(numbers::add);
        return numbers;
    }
}
