package com.timber.lotto.domain;

import java.math.BigDecimal;

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
}
