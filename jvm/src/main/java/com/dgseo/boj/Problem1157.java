package com.dgseo.boj;

import java.util.Scanner;

public class Problem1157 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    int[] arr = new int[26];

    for (char c : str.toCharArray()) {
      if (c < 97) {
        arr[c - 65]++;
      } else {
        arr[c - 97]++;
      }
    }

    int result = 0;
    int cnt = 0;
    boolean duplication = false;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > cnt) {
        cnt = arr[i];
        result = i;
        duplication = false;
      } else if (arr[i] == cnt) {
        duplication = true;
      }
    }

    if (duplication) {
      System.out.println("?");
    } else {
      System.out.println((char) (result + 65));
    }

    sc.close();
  }
}
