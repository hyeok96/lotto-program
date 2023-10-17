package com.timber.lotto.view;

import com.timber.lotto.domain.lotto.Lotto;

import java.util.List;

public class OutputView {
    public void printNums(int manualLottoNum, int autoLottoNum) {
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.%n", manualLottoNum, autoLottoNum);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }
}