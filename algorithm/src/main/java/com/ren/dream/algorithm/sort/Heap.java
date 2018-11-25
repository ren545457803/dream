package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-23.
 * 堆排序
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

  private static void heapSort(int[] src) {
    // 调整堆，从最后一个父结点开始
    for (int i = src.length / 2 - 1; i >= 0; i--) {
      max_heapify(src, i, src.length - 1);
    }

    for (int j = src.length - 1; j > 0; j--) {
      swap(src, 0, j);
      max_heapify(src, 0, j - 1);
    }
  }

  private static void max_heapify(int[] src, int start, int end) {
    int dad = start;
    while (true) {
      int son = dad * 2 + 1;
      if (son > end) break;

      if (son + 1 <= end && src[son + 1] > src[son]) {
        son++;
      }

      if (src[dad] >= src[son]) {
        return;
      }
      swap(src, dad, son);
      dad = son;
    }
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];
    src[i] = src[j];
    src[j] = temp;
  }
}
