package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-28.
 * 计数排序
 */

public class Count {
  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 20);
    }
    System.out.println(Arrays.toString(test));

    countSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void countSort(int[] src) {
    // 1. 找最大值
    int max = 0;
    for (int c : src) {
      if (c > max) {
        max = c;
      }
    }

    // 2. count
    int temp[] = new int[max + 1];
    for (int c : src) {
      temp[c]++;
    }
    // 3. 计算count中的index
    for (int i = 1; i < temp.length; i++) {
      temp[i] += temp[i - 1];
    }

    // 4. 遍历src，排序
    int result[] = new int[src.length];
    for (int c : src) {
      result[temp[c] - 1] = c;
      temp[c]--;
    }

    // 5. copy
    for (int i = 0; i < src.length; i++) {
      src[i] = result[i];
    }
  }
}
