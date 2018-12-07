package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-26.
 * 快速排序
 */

public class QuickOptimize {
  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 3);
    }
    System.out.println(Arrays.toString(test));

    quickSort(test, 0, test.length - 1);
    System.out.println(Arrays.toString(test));
  }

  public static void sort(int[] src) {
    quickSort(src, 0, src.length - 1);
  }

  private static void quickSort(int[] src, int l, int r) {
    if (l < r) {
      int pivotIndex = partitionOptimize(src, l, r);
      quickSort(src, l, pivotIndex - 1);
      quickSort(src, pivotIndex + 1, r);
    }
  }

  private static int partitionOptimize(int[] src, int l, int r) {
    swap(src, l, (int) (Math.random() * (r - l + 1) + l));

    int pivot = src[l];

    // [l+1,i)<=pivot,(j,r]>=pivot
    int i = l + 1;
    int j = r;

    while (true) {
      while (i <= r && src[i] < pivot) {
        i++;
      }

      while (j >= l + 1 && src[j] > pivot) {
        j--;
      }

      if (i > j) {
        break;
      }
      swap(src, i, j);
      i++;
      j--;
    }

    swap(src, l, j);
    return j;
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];
    src[i] = src[j];
    src[j] = temp;
  }
}
