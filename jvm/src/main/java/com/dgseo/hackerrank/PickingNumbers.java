package com.dgseo.hackerrank;

import java.util.List;

public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        int result = 0;
        int maxIndex = 100;
        int[] arr = new int[maxIndex];

        for (Integer num : a) {
            arr[num]++;
        }

        for (int i = 0; i < maxIndex - 1; i++) {
            result = Math.max(result, arr[i] + arr[i + 1]);
        }

        return result;
    }
}
