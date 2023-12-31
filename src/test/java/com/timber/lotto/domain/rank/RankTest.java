package com.timber.lotto.domain.rank;

import com.timber.lotto.domain.Money;
import com.timber.lotto.domain.rank.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void rankTest() {
       assertEquals(Money.of(2_000_000_000), Rank.FIRST.getPrize());
    }

    @Test
    void findTest () {
        Rank actual = Rank.of(Criteria.of(6, false));

        assertEquals(Rank.FIRST, actual);
    }




}