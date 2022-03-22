package com.base.algo;

public class SortAll {

    /**
     * 1. 冒泡排序
     * 每轮循环确定最值；
     */
    public void bubbleSort(int[] nums){
        int temp;
        boolean isSort = false; //优化，发现排序好就退出
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {  //每次排序后能确定较大值
                if(nums[j] > nums[j+1]){
                    isSort = true;
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if(!isSort){
                return;
            } else {
                isSort = false;
            }
        }
    }

}
