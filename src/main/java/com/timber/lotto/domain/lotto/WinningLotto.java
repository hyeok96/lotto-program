package com.timber.lotto.domain.lotto;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public WinningLotto(LottoGenerator lottoGenerator, LottoNumber bonusBall) {
        this.winningNumbers = lottoGenerator.generate();
        this.bonusBall = bonusBall;
    }

}
