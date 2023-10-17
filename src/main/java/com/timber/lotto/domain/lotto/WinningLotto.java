package com.timber.lotto.domain.lotto;

import com.timber.lotto.domain.rank.Criteria;

public class WinningLotto {

    private static final int BONUS_MATCH = 5;

    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(LottoGenerator lottoGenerator, LottoNumber bonusBall) {
        this.lotto = new Lotto(lottoGenerator);
        this.bonusBall = bonusBall;
    }

    public Criteria compare(Lotto lotto) {
        int match = this.lotto.compare(lotto);
        if (match == BONUS_MATCH) {
            return Criteria.of(match, lotto.contains(bonusBall));
        }
        return Criteria.of(match, false);
    }
}