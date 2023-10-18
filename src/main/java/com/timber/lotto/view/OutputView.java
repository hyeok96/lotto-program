package com.timber.lotto.view;

import com.timber.lotto.domain.lotto.Lotto;

import java.util.List;

public class OutputView {

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto);
        }
    }

}
