package com.ren.dream.algorithm;

/**
 * Created by 任亚彬 on 2018-11-25.
 */

public class Test {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 2, 1, 3, 6, 6, 3 };

    int hah = findOnlyOne(arr);
    System.out.println(hah);
  }

  private static int findOnlyOne(int[] arr) {
    // 1. 找到最大的数
    int max = 0;
    for (int c : arr) {
      if (c > max) {
        max = c;
      }
    }

    // 2. 计数
    int temp[] = new int[max + 1];
    for (int c : arr) {
      temp[c]++;
    }

    // 2. 找到值为1的下标，，即为单数的值
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == 1) {
        return i;
      }
    }

    return -1;
  }
}
