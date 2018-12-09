package com.ren.dream.algorithm.sort;

import com.ren.dream.structure.heap.MaxHeap;

/**
 * Created by 任亚彬 on 2018-12-09.
 * 借助数据结构：最大堆
 */

public class Heap2 {
  public static void sort(int[] src) {
    MaxHeap maxHeap = new MaxHeap(src);
    for (int i = src.length - 1; i >= 0; i--) {
      src[i] = maxHeap.extractItem();
    }
  }
}
