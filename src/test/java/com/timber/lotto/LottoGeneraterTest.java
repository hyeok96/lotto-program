package com.timber.lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneraterTest {

    private final LottoGenerater lottoerGennerater = new LottoGenerater(1);

    @Test
    void gennerate() {
        assertEquals(16, lottoerGennerater.gennerate());
        assertEquals(29, lottoerGennerater.gennerate());
    }
}