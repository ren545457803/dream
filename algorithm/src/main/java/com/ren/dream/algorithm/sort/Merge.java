package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-25.
 * 归并排序
 */

public class Merge {
  public static void main(String[] args) {
    int[] test = new int[10];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    mergeSort(test, 0, test.length - 1);
    System.out.println(Arrays.toString(test));
  }

  private static void mergeSort(int[] src, int start, int end) {
    if (start >= end) return;
    int middle = (start + end) / 2;

    mergeSort(src, start, middle);
    mergeSort(src, middle + 1, end);

    merge(src, start, middle, end);
  }

  private static void merge(int[] src, int start, int middle, int end) {
    // 1. 将src存入两个临时子数组
    int leftSize = middle - start + 1;
    int rightSize = end - middle;
    int[] lArray = new int[leftSize];
    for (int i = 0; i < leftSize; i++) {
      lArray[i] = src[i + start];
    }
    int[] rArray = new int[rightSize];
    for (int i = 0; i < rightSize; i++) {
      rArray[i] = src[middle + i + 1];
    }

    // 2. 开始遍历两个子数组，比较
    int leftIndex = 0;
    int rightIndex = 0;
    int srcIndex = start;

    while (leftIndex < leftSize && rightIndex < rightSize) {
      if (lArray[leftIndex] < rArray[rightIndex]) {
        src[srcIndex] = lArray[leftIndex];
        leftIndex++;
      } else {
        src[srcIndex] = rArray[rightIndex];
        rightIndex++;
      }
      srcIndex++;
    }

    // 3. 子数组有多余的，放入src
    while (leftIndex < leftSize) {
      src[srcIndex] = lArray[leftIndex];
      leftIndex++;
      srcIndex++;
    }
    while (rightIndex < rightSize) {
      src[srcIndex] = rArray[rightIndex];
      rightIndex++;
      srcIndex++;
    }
  }
}
