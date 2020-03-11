package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {
    private static int pointer;
    private static String qt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ret = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; ++i) {
            pointer = 0;
            qt = br.readLine();
            ret.append(reverse()).append("\n");
        }
        System.out.print(ret);
    }

    private static String reverse() {
        if (qt.charAt(pointer) != 'x') {
            pointer++;
            return qt.charAt(pointer - 1) + "";
        } else {
            pointer++;
            String ul = reverse();
            String ur = reverse();
            String ll = reverse();
            String lr = reverse();
            return 'x' + ll + lr + ul + ur;
        }
    }
}
