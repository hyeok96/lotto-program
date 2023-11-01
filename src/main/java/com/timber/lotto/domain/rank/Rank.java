package com.timber.lotto.domain.rank;

import com.timber.lotto.domain.Money;

import java.util.Arrays;

public enum Rank implements Comparable<Rank> {
    NONE(Criteria.of(0, false), Money.of(0)),
    FIFTY(Criteria.of(3, false), Money.of(5_000)),
    FOURTH(Criteria.of(4, false), Money.of(50_000)),
    THIRD(Criteria.of(5, false), Money.of(1500000)),
    SECOND(Criteria.of(5, true), Money.of(30_000_000)),
    FIRST(Criteria.of(6, false), Money.of(2_000_000_000)),
    ;

    private final Criteria criteria;
    private final Money prize;

    Rank(Criteria criteria, Money prize) {
        this.criteria = criteria;
        this.prize = prize;
    }


    public static Rank of(Criteria criteria) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.criteria.equals(criteria))
                .findFirst()
                .orElse(NONE);
    }

    public int getMatch() {
        return criteria.getMatch();
    }

    public boolean isBonus() {
        return criteria.isBonus();
    }

    public Money getPrize() {
        return prize;
    }

}


