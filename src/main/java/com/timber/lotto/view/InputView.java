package com.timber.lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputMoney() throws IOException {
        System.out.println("구입 금액을 입력해 주세요");
        return Integer.parseInt(br.readLine());
    }

    public int inputManualLottoNum(BigDecimal payment, int lottoPrice ) throws IOException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int numberOfLotto = Integer.parseInt(br.readLine());
        try {
            if(lottoPrice * numberOfLotto > new BigDecimal(String.valueOf(payment)).intValue() ) {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("금액을 초과했습니다.");
        }
        return numberOfLotto;
    }

    public List<List<Integer>> inputManualLottos(int manualLottoNum) throws IOException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoNum; i++) {
            lottos.add(inputManualLotto());
        }
        return lottos;
    }

    private List<Integer> inputManualLotto() throws IOException {
        List<Integer> lotto = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        while (st.hasMoreTokens()) {
            try {
                if (lotto.size() == 6) {
                    throw new Exception();
                }
                lotto.add(Integer.parseInt(st.nextToken().trim()));

            } catch (Exception e) {
                System.out.println("6자리만 입력해 주세요");
            };
        }
        return lotto;
}


}
