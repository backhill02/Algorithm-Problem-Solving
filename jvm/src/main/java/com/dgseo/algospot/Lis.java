package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lis {

    private static int n;
    private static int[] cache = new int[501];
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            arr = new int[500];
            Arrays.fill(cache, -1);
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(lis(-1) - 1).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int lis(int start) {
        int ret = cache[start + 1];
        if (ret != -1) return ret;
        ret = 1;
        for (int next = start + 1; next < n; next++) {
            if (start == -1 || arr[start] < arr[next]) ret = Math.max(ret, lis(next) + 1);
        }
        return cache[start + 1] = ret;
    }
}
