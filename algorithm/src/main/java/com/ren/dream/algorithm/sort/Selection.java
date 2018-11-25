package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-22.
 * 选择排序
 */

public class Selection {
  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    selectionSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void selectionSort(int[] src) {
    for (int i = 0; i < src.length; i++) {
      int smallestIndex = i;
      for (int j = i; j < src.length; j++) {
        if (src[j] < src[smallestIndex]) {
          smallestIndex = j;
        }
      }

      if (i != smallestIndex) {
        swap(src, i, smallestIndex);
      }
    }
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];

    src[i] = src[j];
    src[j] = temp;
  }
}
