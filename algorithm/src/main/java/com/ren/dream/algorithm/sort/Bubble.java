package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-21.
 * 冒泡排序
 */

public class Bubble {
  public static void main(String[] args) {
    int[] test = new int[100];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    bubbleSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void bubbleSort(int[] src) {
    for (int i = 0; i < src.length - 1; i++) {
      for (int j = 0; j < src.length - i - 1; j++) {
        if (src[j] > src[j + 1]) {
          swap(src, j, j + 1);
        }
      }
    }
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];
    src[i] = src[j];
    src[j] = temp;
  }
}
