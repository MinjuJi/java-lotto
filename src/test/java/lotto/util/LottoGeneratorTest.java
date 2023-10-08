package lotto.util;

import lotto.domain.UserLotto;
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
        List<UserLotto> numbers = LottoGenerator.generatorUserLotto(3);

        // then
        assertThat(numbers.size()).isEqualTo(3);
    }
}
