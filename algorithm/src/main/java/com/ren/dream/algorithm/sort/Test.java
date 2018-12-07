package com.ren.dream.algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 任亚彬 on 2018-12-06.
 */

public class Test {
  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    int[] arr = generateRandomArray(20000, 1, 10000);
    int[] copyArr = copyArray(arr);
    int[] copyArr2 = copyArray(arr);

    test(Merge.class, copyArr);
    test(Quick.class, arr);
    test(QuickOptimize.class, copyArr2);
    test(QuickOptimize.class, copyArray(arr));
  }

  private static void test(Class<?> cl, int[] arr)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method sortMethod = cl.getMethod("sort", int[].class);

    long start = System.currentTimeMillis();
    sortMethod.invoke(null, (Object) arr);
    long end = System.currentTimeMillis();

    System.out.printf("%s %f，%s\n", cl.getSimpleName(), (end - start) / 1000f, isOrder(arr));
  }

  private static boolean isOrder(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) return false;
    }
    return true;
  }

  private static int[] copyArray(int[] arr) {
    int[] copy = new int[arr.length];
    System.arraycopy(arr, 0, copy, 0, arr.length);
    return copy;
  }

  private static int[] generateRandomArray(int length, int rangeL, int rangeR) {
    int[] aar = new int[length];
    for (int i = 0; i < length; i++) {
      aar[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
    }

    return aar;
  }
}
