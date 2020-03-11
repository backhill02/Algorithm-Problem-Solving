package com.dgseo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2447 {
    public static char[][] arr;

    public static void makeStarArray(int x, int y, int num) {
        if (num == 1) {
            arr[x][y] = '*';
            return;
        }
        int value = num / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) makeStarArray(x + (value * i), y + (value * j), value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        arr = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(arr[i], ' ');
        }
        makeStarArray(0, 0, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
