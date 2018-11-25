package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-22.
 * 插入排序
 */

public class Insertion {
  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    insertionSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void insertionSort(int[] src) {
    for (int i = 1; i < src.length; i++) {
      for (int j = i; j > 0; j--) {
        if (src[j] > src[j - 1]) break;
        swap(src, j, j - 1);
      }
    }
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];

    src[i] = src[j];
    src[j] = temp;
  }
}
