package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-23.
 * 堆排序：原地排序
 */

public class Heap {
  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    heapSort(test);
    System.out.println(Arrays.toString(test));
  }

  public static void sort(int[] src) {
    heapSort(src);
  }

  private static void heapSort(int[] src) {
    // 调整堆，从最后一个父结点开始
    int n = src.length;
    for (int i = (n - 1) / 2; i >= 0; i--) {
      shiftDown(src, i, n - 1);
    }

    for (int j = n - 1; j > 0; j--) {
      swap(src, 0, j);
      shiftDown(src, 0, j - 1);
    }
  }

  private static void shiftDown(int[] src, int start, int end) {
    while (start * 2 + 1 <= end) {
      int j = start * 2 + 1;
      if (j + 1 <= end && src[j + 1] > src[j]) {
        j++;
      }

      if (src[start] > src[j]) break;

      swap(src, start, j);
      start = j;
    }
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];
    src[i] = src[j];
    src[j] = temp;
  }
}
