package com.dgseo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2748 {

    private static long[] cache = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(cache, -1L);
        System.out.print(solve(Integer.parseInt(br.readLine())));
    }

    private static long solve(int n) {
        if (cache[n] != -1) return cache[n];
        if (n < 2) {
            return cache[n] = n;
        } else {
            return cache[n] = solve(n - 2) + solve(n - 1);
        }
    }
}
