package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quantization {

    private static final int INF = 987654321;
    private static int n, s;
    private static int[] A, pSum, pSqSum;
    private static int[][] cache;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < testCnt; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            A = new int[n];
            pSum = new int[n];
            pSqSum = new int[n];
            cache = new int[101][11];
            for (int c = 0; c < 101; c++) {
                Arrays.fill(cache[c], -1);
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            preCalc();
            sb.append(quantize(0, s)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void preCalc() {
        Arrays.sort(A);
        pSum[0] = A[0];
        pSqSum[0] = A[0] * A[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + A[i];
            pSqSum[i] = pSqSum[i - 1] + (A[i] * A[i]);
        }
    }

    private static int minError(int lo, int hi) {
        int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo - 1]);
        int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo - 1]);
        int m = (int) (0.5 + (double) sum / (hi - lo + 1));
        return sqSum - 2 * m * sum + m * m * (hi - lo + 1);
    }

    private static int quantize(int from, int parts) {
        if (from == n) return 0;
        if (parts == 0) return INF;
        int ret = cache[from][parts];
        if (ret != -1) return ret;
        ret = INF;
        for (int partSize = 1; from + partSize <= n; partSize++) {
            ret = Math.min(ret, minError(from, from + partSize - 1) + quantize(from + partSize, parts - 1));
        }
        return cache[from][parts] = ret;
    }
}
