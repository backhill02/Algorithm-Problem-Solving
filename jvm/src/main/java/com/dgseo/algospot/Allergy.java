package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Allergy {
    private static int friendsCnt;
    private static int menuCount;
    private static String[][] canEatArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < testCnt; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            friendsCnt = Integer.parseInt(st.nextToken());
            menuCount = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int f = 0; f < friendsCnt; f++) {
                st.nextToken();
            }
            canEatArr = new String[50][50];
            for (int m = 0; m < menuCount; m++) {
                st = new StringTokenizer(br.readLine());
                int catEatCnt = Integer.parseInt(st.nextToken());
                for (int ce = 0; ce < catEatCnt; ce++) {
                    canEatArr[m][ce] = st.nextToken();
                }
            }
            System.out.println(selectMenu(new Stack<>(), 0));
        }
    }

    private static int selectMenu(Stack<Integer> selected, int menuIdx) {
        if (menuIdx == menuCount) {
            if (canEverybodyEat(selected)) {
                return selected.size();
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int result = selectMenu(selected, menuIdx + 1);
        selected.push(menuIdx);
        result = Math.min(result, selectMenu(selected, menuIdx + 1));
        selected.pop();
        return result;
    }

    private static boolean canEverybodyEat(Stack<Integer> selected) {
        Set<String> canEatSet = new HashSet<>();
        for (Integer menuIdx : selected) {
            for (String canEat : canEatArr[menuIdx]) {
                if (canEat != null) {
                    canEatSet.add(canEat);
                }
            }
        }
        return canEatSet.size() == friendsCnt;
    }
}
