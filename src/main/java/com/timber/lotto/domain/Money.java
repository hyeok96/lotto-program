package com.timber.lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money implements Comparable<Money> {
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public static Money of(int value) {
        return new Money(value);
    }


    public Money(int value) {
        this.value = new BigDecimal(value);
    }

    public void spend(int money) {
        this.value = value.subtract(new BigDecimal(money));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Money o) {
       return this.value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return value.toString() + "원";
    }
}
