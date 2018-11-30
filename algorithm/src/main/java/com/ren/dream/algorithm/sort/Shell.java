package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-30.
 * 希尔排序
 */

public class Shell {
  public static void main(String[] args) {
    int[] test = new int[20];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    shellSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void shellSort(int[] src) {
    // 1. 初始化步长
    int stepSize = src.length / 2;

    // 2. 插入排序
    while (stepSize > 0) {
      for (int i = stepSize; i < src.length; i++) {
        int temp = src[i];

        int j = i;
        while (j >= stepSize && src[j - stepSize] > temp) {
          src[j] = src[j - stepSize];
          j -= stepSize;
        }
        src[j] = temp;
      }
      stepSize /= 2;
    }
  }
}
