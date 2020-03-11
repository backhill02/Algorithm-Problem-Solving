package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCard {
    private static int[][] cache = new int[101][101];
    private static String W, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            W = br.readLine();
            int fileNameCnt = Integer.parseInt(br.readLine());
            List<String> results = new ArrayList<>();
            for (int f = 0; f < fileNameCnt; f++) {
                for (int[] arr : cache) {
                    Arrays.fill(arr, -1);
                }
                S = br.readLine();
                if (match(0, 0) == 1)
                    results.add(S);
            }
            results.stream().sorted().forEach(System.out::println);
        }
    }

    private static int match(int w, int s) {
        if (cache[w][s] != -1) return cache[w][s];
        while (w < W.length() && s < S.length() &&
                (W.charAt(w) == S.charAt(s) || W.charAt(w) == '?')) {
            return cache[w][s] = match(w + 1, s + 1);
        }
        if (w == W.length()) return cache[w][s] = (s == S.length()) ? 1 : 0;
        if (W.charAt(w) == '*') {
            if (match(w + 1, s) == 1 || (s < S.length() && match(w, s + 1) == 1))
                return cache[w][s] = 1;
        }
        return cache[w][s] = 0;
    }
}
