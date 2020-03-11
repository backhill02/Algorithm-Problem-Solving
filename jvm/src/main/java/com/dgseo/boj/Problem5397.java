package com.dgseo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;

public class Problem5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append(solve(br.readLine()));
            if (i < n - 1) sb.append("\n");
        }

        System.out.print(sb);
    }

    public static String solve(String input) {
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    if (!left.isEmpty()) right.addFirst(left.pollLast());
                    break;
                case '>':
                    if (!right.isEmpty()) left.addLast(right.pollFirst());
                    break;
                case '-':
                    if (!left.isEmpty()) left.pollLast();
                    break;
                default:
                    left.add(c);
            }
        }

        sb.append(join(left));
        sb.append(join(right));

        return sb.toString();
    }

    private static String join(Collection<Character> c) {
        return c.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
