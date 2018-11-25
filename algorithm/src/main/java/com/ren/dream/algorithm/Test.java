package com.ren.dream.algorithm;

/**
 * Created by 任亚彬 on 2018-11-25.
 */

public class Test {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 1, 2, 2, 3, 4, 5, 3, 5 };

    int hah = findOnlyOne(arr);
    System.out.println(hah);
  }

  private static int findOnlyOne(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 0) {
        temp = temp + arr[i];
      } else {
        temp = temp - arr[i];
      }
    }

    return temp;
  }
}
