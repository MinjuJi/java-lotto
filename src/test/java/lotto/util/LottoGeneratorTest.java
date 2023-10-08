package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void lottoGeneratorTest() {
        // given
        final int LOTTO_SIZE = 6;

        // when
        List<Integer> numbers = LottoGenerator.generatorLottoNumbers();

        // then
        assertThat(numbers.size()).isEqualTo(LOTTO_SIZE);
    }
}
