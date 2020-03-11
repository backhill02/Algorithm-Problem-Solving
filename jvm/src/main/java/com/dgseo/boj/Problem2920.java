package com.dgseo.boj;

import java.util.Scanner;

public class Problem2920 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] numbers = sc.nextLine().split(" ");

    int[] arr = new int[8];
    int aCnt = 0, dCnt = 0;
    for (int i = 0; i < numbers.length; i++) {
      int n = Integer.valueOf(numbers[i]);

      arr[i] = n;
      if (arr[i] == i + 1) {
        aCnt++;
      } else if (arr[i] == 8 - i) {
        dCnt++;
      }
    }

    String result;
    if (aCnt == 8) {
      result = "ascending";
    } else if (dCnt == 8) {
      result = "descending";
    } else {
      result = "mixed";
    }

    System.out.println(result);

    sc.close();
  }
}
