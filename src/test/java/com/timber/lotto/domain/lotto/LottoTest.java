package com.timber.lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void constructor_autoLottoGenerator() {
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator);
        System.out.println(lotto);
    }

    @Test
    void  constructor_manualLottoGenerator() {
        LottoGenerator lottoGenerator = new ManualLottoGenerator(List.of(1,3,4,34,24,6));
        Lotto lotto = new Lotto(lottoGenerator);
        System.out.println(lotto);
    }


}