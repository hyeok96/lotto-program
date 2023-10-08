package com.timber.lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutoLottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new AutoLottoGenerator();
    @Test
    void generate() {
        List<LottoNumber> numbers = lottoGenerator.generate();
        assertEquals(Lotto.NUMBER_SIZE, numbers.size());
    }


}