package com.timber.lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    final private List<Integer> lottoList;

    public Lotto (List<Integer> lottoList) {
        this.lottoList = lottoList;
    }

}
