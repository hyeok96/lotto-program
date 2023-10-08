package com.timber.lotto.domain.lotto;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(LottoGenerator lottoGenerator) {

        this.numbers = lottoGenerator.generate();
        if(numbers.size() != NUMBER_SIZE) {
            throw new IllegalStateException(String.format("%d자리가 아닙니다", NUMBER_SIZE));
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
