package com.dgseo.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {
    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> ranks = Arrays.stream(scores)
                .boxed()
                .distinct()
                .collect(Collectors.toList());

        int[] ret = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            int aliceScore = alice[i];
            if (aliceScore >= ranks.get(0)) {
                ret[i] = 1;
            } else if (aliceScore < ranks.get(ranks.size() - 1)) {
                ret[i] = ranks.size() + 1;
            } else {
                ret[i] = getRank(ranks, 0, ranks.size() - 1, aliceScore);
            }
        }
        return ret;
    }

    private static int getRank(List<Integer> ranks, int l, int r, int score) {
        if (r - l <= 1) {
            return r + 1;
        }
        int mid = (l + r) / 2;
        if (ranks.get(l) >= score && score >= ranks.get(mid)) {
            return getRank(ranks, l, mid, score);
        } else if (ranks.get(mid) >= score && score >= ranks.get(r)) {
            return getRank(ranks, mid, r, score);
        } else {
            return -1;
        }
    }
}
