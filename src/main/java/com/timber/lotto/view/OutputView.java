package com.timber.lotto.view;

import com.timber.lotto.domain.Statistics;
import com.timber.lotto.domain.lotto.Lotto;
import com.timber.lotto.domain.rank.Rank;

import java.util.List;

public class OutputView {

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto);
        }
    }

    public void printStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("--------------");
        statistics.entries().forEach(entry -> {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();

            int match = rank.getMatch();
            String isBonus = rank.isBonus() ? "보너스 볼 일치" : "";
            String prize = rank.getPrize().toString();

            System.out.printf("%d개 일치, %s (%s) - %d개%n",match ,isBonus ,prize, count);

        });
    }
}
