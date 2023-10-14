package com.timber.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private BigDecimal value;

    public  BigDecimal getValue() {
        return value;
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
}