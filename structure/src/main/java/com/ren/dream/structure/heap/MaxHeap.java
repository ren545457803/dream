package com.ren.dream.structure.heap;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-12-08.
 * 最大堆
 * 1. 完全二叉树
 * 2. 父结点 >= 子结点
 */

public class MaxHeap {
  // 为方便处理，下标从1开始
  private int[] heap;
  private int capacity;
  private int count;

  public static void main(String[] args) {
    int[] src = new int[10];
    for (int i = 0; i < src.length; i++) {
      src[i] = (int) (Math.random() * src.length);
    }

    MaxHeap maxHeap = new MaxHeap(src);
    //for (int i = 0; i < src.length; i++) {
    //  maxHeap.insertItem(src[i]);
    //}

    System.out.println(Arrays.toString(src));
    maxHeap.print();

    int[] sortArray = new int[src.length];
    for (int i = sortArray.length - 1; i >= 0; i--) {
      sortArray[i] = maxHeap.extractItem();
    }
    System.out.println(Arrays.toString(sortArray));
  }

  public MaxHeap(int capacity) {
    heap = new int[capacity + 1];
    this.capacity = capacity;
    count = 0;
  }

  public MaxHeap(int[] items) {
    heap = new int[items.length + 1];
    for (int i = 0; i < items.length; i++) {
      heap[i + 1] = items[i];
    }

    capacity = items.length;
    count = items.length;
    // 堆化
    heapify();
  }

  /**
   * 入堆
   */
  public void insertItem(int item) {
    if (count + 1 > capacity) throw new IllegalArgumentException("超过容量了");

    heap[++count] = item;
    shiftUp(count);
  }

  /**
   * 出堆
   */
  public int extractItem() {
    if (count < 1) throw new IllegalArgumentException("没有元素了，取什么还！！！");

    int result = heap[1];
    swap(heap, 1, count);
    count--;

    shiftDown(1);

    return result;
  }

  /**
   * 打印
   */
  private void print() {
    System.out.println(Arrays.toString(heap));
  }

  /**
   * 堆化
   */
  private void heapify() {
    for (int i = count / 2; i >= 1; i--) {
      shiftDown(i);
    }
  }

  /**
   * 将元素向上移动到合适位置
   *
   * @param k 需处理元素的下标
   */
  private void shiftUp(int k) {
    while (k / 2 >= 1) {
      if (heap[k] <= heap[k / 2]) {
        break;
      }

      swap(heap, k, k / 2);
      k /= 2;
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * 将元素向下调整
   *
   * @param k 元素下标
   */
  private void shiftDown(int k) {
    while (2 * k <= count) {
      int maxChild = 2 * k;
      if (maxChild + 1 <= count && heap[maxChild + 1] > heap[maxChild]) {
        maxChild++;
      }

      if (heap[k] >= heap[maxChild]) break;

      swap(heap, k, maxChild);
      k = maxChild;
    }
  }
}
