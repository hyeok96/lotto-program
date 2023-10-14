package com.timber.lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputMoney() throws IOException {
        System.out.println("구입 금액을 입력해 주세요");
        return Integer.parseInt(br.readLine());
    }

    public int inputManualLottoNum(BigDecimal payment, BigDecimal lottoPrice) throws IllegalArgumentException, IOException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int numberOfLotto = Integer.parseInt(br.readLine());

        if (payment.compareTo(lottoPrice.multiply(new BigDecimal(numberOfLotto))) < 0) {
            throw new IllegalArgumentException("금액을 초과했습니다.");
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
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken().trim()));
        }
        return numbers;
    }

    public List<Integer> inputWinningLotto() throws IOException {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken().trim()));
        }
        return numbers;
    }

    public int inputBonusBall() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(br.readLine());
    }

}