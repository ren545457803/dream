package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-26.
 * 快速排序
 */

public class Quick {
  public static void main(String[] args) {
    int[] test = new int[20];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    quickSort(test, 0, test.length - 1);
    System.out.println(Arrays.toString(test));
  }

  private static void quickSort(int[] src, int l, int r) {
    if (l < r) {
      int pivotIndex = partition(src, l, r);
      quickSort(src, l, pivotIndex - 1);
      quickSort(src, pivotIndex + 1, r);
    }
  }

  private static int partition(int[] src, int l, int r) {
    int pivot = src[l];

    // 保存最后一个比pivot小的下标
    int pivotIndex = l;
    // 1. 比pivot小的放左边，大的放右边
    for (int i = l + 1; i <= r; i++) {
      if (src[i] <= pivot) {
        swap(src, pivotIndex + 1, i);
        pivotIndex++;
      }
    }

    // 2. 对换pivot和最小的
    swap(src, l, pivotIndex);
    return pivotIndex;
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];
    src[i] = src[j];
    src[j] = temp;
  }
}
