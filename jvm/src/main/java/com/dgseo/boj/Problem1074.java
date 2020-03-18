package com.dgseo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1074 {

    private static int N;
    private static int R;
    private static int C;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        solve((int) Math.pow(2, N), 0, 0);
    }

    private static void solve(int n, int y, int x) {
        if (n == 2) {
            if (R == y && C == x) {
                System.out.println(result);
                return;
            }
            result++;
            if (R == y && C == x + 1) {
                System.out.println(result);
                return;
            }
            result++;
            if (R == y + 1 && C == x) {
                System.out.println(result);
                return;
            }
            result++;
            if (R == y + 1 && C == x + 1) {
                System.out.println(result);
                return;
            }
            result++;
            return;
        }
        solve(n / 2, y, x);
        solve(n / 2, y, x + n / 2);
        solve(n / 2, y + n / 2, x);
        solve(n / 2, y + n / 2, x + n / 2);
    }
}
