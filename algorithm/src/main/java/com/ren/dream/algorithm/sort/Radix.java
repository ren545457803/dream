package com.ren.dream.algorithm.sort;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-11-29.
 * 基数排序
 */

public class Radix {
  public static void main(String[] args) {
    int[] test = new int[20];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    radixSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void radixSort(int[] src) {
    // 1. 找基数位数
    int max = src[0];
    for (int c : src) {
      if (c > max) {
        max = c;
      }
    }
    int digitNum = (max + "").length();

    // 2. 按位排序
    for (int i = 0; i < digitNum; i++) {
      countSort(src, i);
    }
  }

  /**
   * 计数排序
   */
  private static void countSort(int[] src, int radix) {
    // 1. 计数
    int[] countArray = new int[10];
    for (int c : src) {
      int index = getIndex(c, radix);
      countArray[index]++;
    }

    // 2. 计算下标
    for (int i = 1; i < countArray.length; i++) {
      countArray[i] += countArray[i - 1];
    }

    // 3. 排序
    int[] result = new int[src.length];
    for (int i = src.length - 1; i >= 0; i--) {
      int countIndex = getIndex(src[i], radix);
      result[countArray[countIndex] - 1] = src[i];
      countArray[countIndex]--;
    }

    // 4. copy至源数组
    for (int i = 0; i < src.length; i++) {
      src[i] = result[i];
    }
  }

  private static int getIndex(int number, int radix) {
    String numberString = number + "";
    int numberLength = numberString.length();

    if (numberLength > radix) {
      String charIntString =
          numberString.substring(numberString.length() - radix - 1, numberString.length() - radix);
      return Integer.parseInt(charIntString);
    } else {
      return 0;
    }
  }
}
