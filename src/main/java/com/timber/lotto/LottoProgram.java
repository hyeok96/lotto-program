package com.timber.lotto;

import com.timber.lotto.domain.lotto.*;
import com.timber.lotto.domain.Money;
import com.timber.lotto.view.InputView;
import com.timber.lotto.view.OutputView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoProgram {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() throws IOException {
        Money money = new Money(inputView.inputMoney());

        // manual
        int manualLottoNum = inputView.inputManualLottoNum(money.getValue(), Lotto.LOTTO_PRICE);
        money.spend(Lotto.LOTTO_PRICE.multiply(BigDecimal.valueOf(manualLottoNum)));

        // auto
        int autoLottoNum = money.count(Lotto.LOTTO_PRICE);
        money.spend(Lotto.LOTTO_PRICE.multiply(BigDecimal.valueOf(autoLottoNum)));

        // sum
        List<Lotto> allLottos = new ArrayList<>();
        allLottos.addAll(getManualLottos(manualLottoNum));
        allLottos.addAll(getAutoLottos(autoLottoNum));

        System.out.println(allLottos);

        List<Integer> lastWinningLottoNumbers = inputView.inputWinningLotto();
        int bonusBall = inputView.inputBonusBall();
        WinningLotto lastWinningLotto = getwinningLotto(lastWinningLottoNumbers, bonusBall);
    }

    private List<Lotto> getManualLottos(int count) throws IOException {
        List<List<Integer>> inputManualLottos = inputView.inputManualLottos(count);
        return inputManualLottos.stream()
                .map(ManualLottoGenerator::new)
                .map(Lotto::new)
                .toList();
    }

    private List<Lotto> getAutoLottos(int count) {
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoLottos.add(new Lotto(new AutoLottoGenerator()));
        }
        return autoLottos;
    }

    private WinningLotto getwinningLotto(List<Integer> lastWinnigLottoNumbers, int bonusBall) {
        return new WinningLotto(new ManualLottoGenerator(lastWinnigLottoNumbers), new LottoNumber(bonusBall));
    }
}