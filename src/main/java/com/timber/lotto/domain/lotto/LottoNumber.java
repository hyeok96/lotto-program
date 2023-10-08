package com.timber.lotto.domain.lotto;

public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int value;


    public LottoNumber(int value) {
        if(value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalStateException("범위를 초과했습니다.");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
