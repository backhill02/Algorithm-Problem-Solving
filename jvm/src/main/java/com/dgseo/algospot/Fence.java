package com.dgseo.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fence {
    private static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < testCnt; t++) {
            int fenceCnt = Integer.parseInt(br.readLine());
            heights = new int[fenceCnt];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int f = 0; f < fenceCnt; f++) {
                heights[f] = Integer.parseInt(st.nextToken());
            }
            result.append(solve(0, heights.length - 1)).append("\n");
        }
        System.out.print(result.toString());
    }

    private static int solve(int left, int right) {
        if (left == right) return heights[left];
        int mid = (left + right) / 2;
        int ret = Math.max(solve(left, mid), solve(mid + 1, right));
        int low = mid, high = mid + 1;
        int height = Math.min(heights[low], heights[high]);
        ret = Math.max(ret, height * 2);
        while (low > left || high < right) {
            if (high < right && (low == left || heights[low - 1] < heights[high + 1])) {
                high++;
                height = Math.min(height, heights[high]);
            } else {
                low--;
                height = Math.min(height, heights[low]);
            }
            ret = Math.max(ret, (high - low + 1) * height);
        }
        return ret;
    }
}
