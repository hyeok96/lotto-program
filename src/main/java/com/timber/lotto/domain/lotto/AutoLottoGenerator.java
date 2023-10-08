package com.timber.lotto.domain.lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AutoLottoGenerator implements LottoGenerator {

    private final Random random = new Random();

    @Override
    public List<LottoNumber> generate() {
        return random.ints(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE + 1)
                .distinct()
                .limit(Lotto.NUMBER_SIZE)
                .sorted()
                .mapToObj(LottoNumber::new)
                .toList();
    }
}
