package com.timber.lotto.domain.rank;

public class Criteria {
    private final int match;
    private final boolean bonus;

    public Criteria(int match, boolean bonus) {
        this.match = match;
        this.bonus = bonus;
    }

    public static Criteria of(int match, boolean bonus) {
        return new Criteria(match, bonus);
    }

}
