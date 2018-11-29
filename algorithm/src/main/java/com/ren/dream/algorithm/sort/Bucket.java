package com.ren.dream.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 任亚彬 on 2018-11-29.
 * 桶排序
 */

public class Bucket {
  public static void main(String[] args) {
    int[] test = new int[30];
    for (int i = 0; i < test.length; i++) {
      test[i] = (int) (Math.random() * 100);
    }
    System.out.println(Arrays.toString(test));

    bucketSort(test);
    System.out.println(Arrays.toString(test));
  }

  private static void bucketSort(int[] src) {
    // 1. 找最大、最小值
    int min = src[0];
    int max = src[0];
    for (int c : src) {
      if (c < min) {
        min = c;
      } else if (c > max) {
        max = c;
      }
    }

    // 2. 生成桶
    int bucketCount = src.length;
    List<List<Integer>> bucketArray = new ArrayList<List<Integer>>(bucketCount);
    for (int c : src) {
      bucketArray.add(null);
    }

    // 3. 放入桶中
    int bucketCapacity = (max - min) / bucketCount + 1;
    for (int c : src) {
      int index = (c - min) / bucketCapacity;
      if (null == bucketArray.get(index)) {
        bucketArray.set(index, new ArrayList<Integer>());
      }
      bucketArray.get(index).add(c);
    }

    // 4. 各个桶排序，并合并
    List<Integer> result = new ArrayList<Integer>();
    for (List<Integer> bucket : bucketArray) {
      if (bucket != null) {
        insertSort(bucket);
        result.addAll(bucket);
      }
    }

    // 5. copy
    for (int i = 0; i < src.length; i++) {
      src[i] = result.get(i);
    }
  }

  private static void insertSort(List<Integer> bucket) {
    if (bucket.isEmpty()) {
      return;
    }

    // 插入排序
    for (int i = 1; i < bucket.size(); i++) {
      int current = bucket.get(i);
      int insertIndex = i - 1;
      for (; insertIndex >= 0; insertIndex--) {
        if (bucket.get(insertIndex) <= current) break;

        // swap
        int temp = bucket.get(insertIndex);
        bucket.set(insertIndex, bucket.get(insertIndex + 1));
        bucket.set(insertIndex + 1, temp);
      }

      // 插入
      bucket.set(insertIndex + 1, current);
    }
  }
}
