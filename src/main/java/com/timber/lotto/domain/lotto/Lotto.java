package com.timber.lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(LottoGenerator lottoGenerator) {

        this.numbers = lottoGenerator.generate();
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalStateException(String.format("%d자리가 아닙니다", NUMBER_SIZE));
        }
    }


    public int compare(Lotto lotto) {
        Set<LottoNumber> intersect = new HashSet<>(this.numbers);
        intersect.retainAll(lotto.numbers);
        return intersect.size();
    }

    ;

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    ;


    @Override
    public String toString() {
        return numbers.toString();
    }
}
