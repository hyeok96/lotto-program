package com.timber.lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int value;

    public LottoNumber(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalStateException("범위를 초과했습니다.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
