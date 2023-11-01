package com.timber.lotto.domain.rank;

import java.util.Objects;

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

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria criteria = (Criteria) o;
        return match == criteria.match && bonus == criteria.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, bonus);
    }
}
