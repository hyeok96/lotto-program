package com.timber.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
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

    public void spend(BigDecimal money) {
        this.value = value.subtract(money);
    }

    public int count(BigDecimal price) {
        return value.divide(price, RoundingMode.FLOOR).intValue();
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
        return value != null ? value.hashCode() : 0;
    }
}