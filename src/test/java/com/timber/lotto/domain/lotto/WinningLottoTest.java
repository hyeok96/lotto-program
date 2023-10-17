package com.timber.lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    void cunstructor_winnigLotto () {
        LottoGenerator lottoGenerator = new ManualLottoGenerator(List.of(1,2,3,4,5,6));
        LottoNumber lottoNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lottoGenerator, lottoNumber);
    }


}