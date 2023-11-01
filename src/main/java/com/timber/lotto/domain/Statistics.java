package com.timber.lotto.domain;

import com.timber.lotto.domain.rank.Rank;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Statistics {
    private final Map<Rank, Integer> board;

    public Statistics() {
        board = new HashMap<>();
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> board.put(rank, 0));
    }

    public void add(Rank rank) {
        if(rank.equals(Rank.NONE)) return;
        Integer computed = board.computeIfPresent(rank, (k, v) -> v + 1);
        if(computed == null) {
            throw new  IllegalStateException("연산에 실패했습니다.");
        }
    }

    public List<Map.Entry<Rank, Integer>> entries () {
        return board.entrySet().stream()
                .sorted((comparing(o -> o.getKey().getPrize())))
                .toList();
    }

}
