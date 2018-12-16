package com.ren.dream.structure.heap;

import java.util.Arrays;

/**
 * Created by 任亚彬 on 2018-12-11.
 * 索引堆
 */

public class IndexMaxHeap {
  private int[] data;
  private int[] index;
  private int[] reverse;
  private int capacity;
  private int count;

  public static void main(String[] args) {
    int[] src = new int[10];

    for (int i = 0; i < src.length; i++) {
      src[i] = (int) (Math.random() * 10);
    }

    System.out.println(Arrays.toString(src));
    IndexMaxHeap indexHeap = new IndexMaxHeap(src.length);
    for (int item : src) {
      indexHeap.insert(item);
    }

    System.out.println("第一次");
    indexHeap.print();
    //int[] pp = new int[src.length];
    //for (int i = pp.length - 1; i >= 0; i--) {
    //  pp[i] = indexHeap.extractItem();
    //}
    //System.out.println(Arrays.toString(pp));


    indexHeap.change(4, 9);
    System.out.println("第二次");
    indexHeap.print();

    System.out.println("排序");
    int[] pp = new int[src.length];
    for (int i = pp.length - 1; i >= 0; i--) {
      pp[i] = indexHeap.extractItem();
    }
    System.out.println(Arrays.toString(pp));

    //int[] pp = new int[src.length];
    //for (int i = pp.length - 1; i >= 0; i--) {
    //  pp[i] = indexHeap.extractItem();
    //}
    //System.out.println(Arrays.toString(src));
    //System.out.println(Arrays.toString(pp));
  }

  private void print() {
    System.out.println(Arrays.toString(data));
    System.out.println(Arrays.toString(index));
    System.out.println(Arrays.toString(reverse));
  }

  public IndexMaxHeap(int capacity) {
    data = new int[capacity + 1];
    index = new int[capacity + 1];
    reverse = new int[capacity + 1];
    this.capacity = capacity;
    this.count = 0;
  }

  public void insert(int item) {
    if (count + 1 > capacity) throw new IllegalArgumentException("超过容量了");

    count++;
    data[count] = item;
    index[count] = count;
    reverse[count] = count;

    shiftUp(count);
  }

  private void shiftUp(int k) {
    while (k / 2 > 0) {
      if (data[index[k]] <= data[index[k / 2]]) {
        return;
      }

      swap(index, k, k / 2);
      reverse[index[k]] = k;
      reverse[index[k / 2]] = k / 2;
      k /= 2;
    }
  }

  private void swap(int[] index, int i, int j) {
    int temp = index[i];
    index[i] = index[j];
    index[j] = temp;
  }

  public int extractItem() {
    if (count < 1) throw new IllegalArgumentException("没有元素了");

    int result = data[index[1]];
    swap(index, 1, count);
    reverse[index[1]] = 1;
    reverse[index[count]] = 0;

    count--;
    shiftDown(1);

    return result;
  }

  private void shiftDown(int k) {
    while (2 * k <= count) {
      int maxIndex = 2 * k;
      if (maxIndex + 1 <= count && data[index[maxIndex + 1]] > data[index[maxIndex]]) {
        maxIndex++;
      }

      if (data[index[k]] >= data[index[maxIndex]]) {
        return;
      }

      swap(index, k, maxIndex);
      reverse[index[k]] = k;
      reverse[index[maxIndex]] = maxIndex;
      k = maxIndex;
    }
  }

  public int item(int i) {
    return data[i + 1];
  }

  public void change(int i, int item) {
    data[i + 1] = item;

    shiftUp(reverse[i + 1]);
    shiftDown(reverse[i + 1]);
  }
}
