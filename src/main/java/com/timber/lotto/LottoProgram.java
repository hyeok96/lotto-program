package com.timber.lotto;

import com.timber.lotto.domain.Lotto;
import com.timber.lotto.domain.Money;
import com.timber.lotto.view.InputView;
import com.timber.lotto.view.OutputView;

import java.io.IOException;

public class LottoProgram {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() throws IOException {
        Money money = new Money(inputView.inputMoney());
        int manualLottoNum = inputView.inputManualLottoNum(money.getValue(),  Lotto.LOTTO_PRICE);
        money.spend( manualLottoNum * Lotto.LOTTO_PRICE);
    }
}

