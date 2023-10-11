package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final int CONTAIN = 1;
    private static final int NOT_CONTAIN = 0;
    private static final int COUNT_ZERO = 0;

    public static List<Integer> generateRandomUniqueNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static void sortListNaturalOrder(List<Integer> list) {
        Collections.sort(list);
    }

    public static List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(stringToIntArray(string))
                     .boxed()
                     .collect(Collectors.toList());
    }

    public static int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(","))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

// stringToIntegerList() 와 stringToIntArray()를 합친 메소드. 이게 더 간결하지 않나?
//    public static List<Integer> stringToIntegerList(String string) {
//        return Arrays.stream(string.split(","))
//                     .mapToInt(Integer::parseInt)
//                     .boxed()
//                     .collect(Collectors.toList());
//    }

    public static int countSameElements(List<Integer> list1, List<Integer> list2) {
        int count = COUNT_ZERO;
        for (int number : list2) {
            count += countContainsNumber(list1, number);
        }
        return count;
    }

    public static int countContainsNumber(List<Integer> list, int number) {
        if (list.contains(number)) {
            return CONTAIN;
        }
        return NOT_CONTAIN;
    }
}
