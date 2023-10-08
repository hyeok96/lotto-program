package com.timber.lotto;

import com.timber.lotto.domain.lotto.Lotto;
import com.timber.lotto.domain.Money;
import com.timber.lotto.domain.lotto.ManualLottoGenerator;
import com.timber.lotto.view.InputView;
import com.timber.lotto.view.OutputView;

import java.io.IOException;
import java.util.List;

public class LottoProgram {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() throws IOException {
        Money money = new Money(inputView.inputMoney());
        int manualLottoNum = inputView.inputManualLottoNum(money.getValue(), Lotto.LOTTO_PRICE);
        money.spend(manualLottoNum * Lotto.LOTTO_PRICE);

        List<Lotto> manualLottos = getManualLottos(manualLottoNum);
    }

    private List<Lotto> getManualLottos(int manualLottoNum) throws IOException {
        List<List<Integer>> inputManualLottos = inputView.inputManualLottos(manualLottoNum);
        return inputManualLottos.stream()
                .map(ManualLottoGenerator::new)
                .map(Lotto::new)
                .toList();
    }
}

