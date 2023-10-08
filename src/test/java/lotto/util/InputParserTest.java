package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    @DisplayName("Sting -> int 파싱 테스트")
    @Test
    void buyingPriceParserTest() {
        // given
        String input = "1000";
        final int PARSE_INT = 1000;

        // when
        int result = InputParser.numberParser(input);

        // then
        assertThat(result).isEqualTo(PARSE_INT);
    }

    @DisplayName("로또 당첨 번호 파싱 테스트")
    @Test
    void correctNumbersParserTest() {
        // given
        String input = "1,2,3,4,5,6";
        final List<Integer> PARSE_LIST_INTEGER = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> result = InputParser.correctNumbersParser(input);

        // then
        assertThat(result).isEqualTo(PARSE_LIST_INTEGER);
    }
}
