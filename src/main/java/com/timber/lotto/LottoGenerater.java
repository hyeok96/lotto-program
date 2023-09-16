package com.timber.lotto;

import java.util.Random;

public class LottoGenerater {

    public final Random ramdom;

    public LottoGenerater() {
        this.ramdom = new Random();
    }

    public LottoGenerater(int seed) {
        this.ramdom = new Random(seed);
    }


    public  int gennerate() {
        return ramdom.nextInt(45) + 1;
    }

    public static void main(String[] args) {
        LottoGenerater lottoGenerater = new LottoGenerater();
//        LottoGennerater lottoGennerater2 = new LottoGennerater();

        System.out.println(lottoGenerater.gennerate());

    }

}
