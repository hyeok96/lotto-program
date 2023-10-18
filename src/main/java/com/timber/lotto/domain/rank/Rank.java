package com.timber.lotto.domain.rank;

import com.timber.lotto.domain.Money;

enum Rank {
    FIRST(Criteria.of(6, false), Money.of(2_000_000_000)),
    SECOND(Criteria.of(5, true), Money.of(30_000_000)),
    THIRD(Criteria.of(5, false), Money.of(1500000)),
    FOURTH(Criteria.of(4, false), Money.of(50_000)),
    FIFTY(Criteria.of(3, false), Money.of(5_000));


    private final Criteria criteria;
    private final Money price;

    Rank(Criteria criteria, Money price) {
        this.criteria = criteria;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}


