package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-12-03.
 * 三路快排
 */

public class ThreeWayQuick {
  public static void main(String[] args) {
    int[] test = new int[100];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    threeWayQuickSort(test, 0, test.length - 1);
    System.out.println(Arrays.toString(test));
  }

  private static void threeWayQuickSort(int[] src, int start, int end) {
    if (start >= end) {
      return;
    }
    // 1. parition
    int[] indexs = threePartition(src, start, end);
    // 2. 递归快排
    threeWayQuickSort(src, start, indexs[0]);
    threeWayQuickSort(src, indexs[1], end);
  }

  private static int[] threePartition(int[] src, int start, int end) {
    // 1. 选pivot
    int pivot = src[end];

    // 2. 处理
    // i:正在处理
    // y:最后一个小于pivot
    // z:第一个大于pivot
    int i = start;
    int y = start - 1;
    int z = end + 1;

    while (i < z) {
      if (src[i] < pivot) {
        swap(src, i++, ++y);
      } else if (src[i] > pivot) {
        swap(src, i, --z);
      } else {
        i++;
      }
    }

    // 3. 返回
    return new int[] { y, z };
  }

  private static void swap(int[] src, int i, int j) {
    int temp = src[i];
    src[i] = src[j];
    src[j] = temp;
  }
}
