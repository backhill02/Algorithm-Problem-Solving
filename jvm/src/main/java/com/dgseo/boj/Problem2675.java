package com.dgseo.boj;

import java.util.Scanner;

public class Problem2675 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();

    String[] lines = new String[n];
    for (int i = 0; i < n; i++) {
      lines[i] = sc.nextLine();
    }

    for (String line : lines) {
      String[] data = line.split(" ");
      for (char c : data[1].toCharArray()) {
        for (int i = 0; i < Integer.parseInt(data[0]); i++) {
          System.out.print(c);
        }
      }
      System.out.println();
    }

    sc.close();
  }
}
