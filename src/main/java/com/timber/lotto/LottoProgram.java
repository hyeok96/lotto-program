package com.timber.lotto;

import com.timber.lotto.domain.lotto.*;
import com.timber.lotto.domain.Money;
import com.timber.lotto.view.InputView;
import com.timber.lotto.view.OutputView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoProgram {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() throws IOException {
        Money money = new Money(inputView.inputMoney());
        int manualLottoNum = inputView.inputManualLottoNum(money.getValue(), Lotto.LOTTO_PRICE);
        money.spend(manualLottoNum * Lotto.LOTTO_PRICE);

        List<Lotto> allLottos = new ArrayList<>();
        allLottos.addAll(getManualLottos(manualLottoNum));
        allLottos.addAll(getAutomaticLottos(money.getValue()));

        outputView.showLottos(allLottos);

        List<Integer> lastWinnigLottoNumbers = inputView.inputWinningLotto();
        int bonusBall = inputView.inputBonusBall();
        WinningLotto lastWinningLotto = getwinningLotto(lastWinnigLottoNumbers, bonusBall);
    }

    private List<Lotto> getManualLottos(int manualLottoNum) throws IOException {
        List<List<Integer>> inputManualLottos = inputView.inputManualLottos(manualLottoNum);
        return inputManualLottos.stream()
                .map(ManualLottoGenerator::new)
                .map(Lotto::new)
                .toList();
    }

    private List<Lotto> getAutomaticLottos(BigDecimal money) {
        List<Lotto> automaticLottos = new ArrayList<>();
        int numberOfAutomaticLotto = new BigDecimal(String.valueOf(money)).intValue() / Lotto.LOTTO_PRICE;
        for (int i = 0; i < numberOfAutomaticLotto; i++) {
            automaticLottos.add(new Lotto(new AutoLottoGenerator()));
        }
        return automaticLottos;
    }

    private WinningLotto getwinningLotto(List<Integer> lastWinnigLottoNumbers, int bonusBall) {
        return new WinningLotto(new ManualLottoGenerator(lastWinnigLottoNumbers), new LottoNumber(bonusBall));
    }
}

