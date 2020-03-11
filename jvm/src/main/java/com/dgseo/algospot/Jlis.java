package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jlis {

    private static int n, m;
    private static int[][] cache = new int[101][101];
    private static int[] A, B;
    private static final long MIN = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            sb.append(jlis(-1, -1) - 2).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int jlis(int indexA, int indexB) {
        int ret = cache[indexA + 1][indexB + 1];
        if (ret != -1) return ret;
        ret = 2;

        long a = indexA == -1 ? MIN : A[indexA];
        long b = indexB == -1 ? MIN : B[indexB];
        long maxElement = Math.max(a, b);

        for (int nextA = indexA + 1; nextA < n; nextA++) {
            if (maxElement < A[nextA]) ret = Math.max(ret, jlis(nextA, indexB) + 1);
        }

        for (int nextB = indexB + 1; nextB < m; nextB++) {
            if (maxElement < B[nextB]) ret = Math.max(ret, jlis(indexA, nextB) + 1);
        }

        return cache[indexA + 1][indexB + 1] = ret;
    }
}
