package com.dgseo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem7490 {

    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            solution(new Stack<>(), Integer.parseInt(br.readLine()));
            if (t < testCnt - 1) {
                results.add("\n");
            }
        }
        results.forEach(System.out::print);
    }

    public static void solution(Stack<String> op, int n) {
        if (op.size() == n - 1) {
            int sum = 0;
            StringBuilder num = new StringBuilder();
            for (int i = 1; i < n; i++) {
                num.append(i);
                if (!" ".equals(op.get(i - 1))) {
                    sum += Integer.parseInt(num.toString());
                    num = new StringBuilder();
                    num.insert(0, op.get(i - 1));
                }
            }
            num.append(n);
            sum += Integer.parseInt(num.toString());

            if (sum == 0) {
                StringBuilder result = new StringBuilder();
                for (int i = 1; i < n; i++) {
                    result.append(i);
                    result.append(op.get(i - 1));
                }
                result.append(n).append("\n");
                results.add(result.toString());
            }

            return;
        }
        op.push(" ");
        solution(op, n);
        op.pop();

        op.push("+");
        solution(op, n);
        op.pop();

        op.push("-");
        solution(op, n);
        op.pop();
    }
}
