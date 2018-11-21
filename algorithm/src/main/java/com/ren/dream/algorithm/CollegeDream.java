package com.ren.dream.algorithm;

/**
 * Created by 任亚彬 on 2018-11-20.
 * 99乘法表
 */

public class CollegeDream {
  public static void main(String[] args) {
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.printf("%d*%d=%-4d", j, i, i * j);
      }
      System.out.println();
    }
  }
}
