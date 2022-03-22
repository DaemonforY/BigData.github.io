package com.base.algo;

import java.util.*;

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

    /**
     * 2. 选择排序
     * 每次选出最值，再交换到边上；
     */
    public void selectSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int index = i;
            int minNum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] < minNum){
                    minNum = nums[j];
                    index = j;
                }
            }
            if(index != i){
                nums[index] = nums[i];
                nums[i] = minNum;
            }
        }
    }

    /**
     * 3. 插入排序
     * 对循环的每个数找到属于自己的位置插入；
     */
    public void insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int insertNum = nums[i];
            while(j-1 >= 0 && nums[j-1] > insertNum){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = insertNum;
        }
    }

    /**
     * 4. 快速排序
     * 选一个基本值，小于它的放一边，大于它的放另一边；
     */
    public void quickSortDfs(int[] nums, int left, int right){
        if(left > right){
            return;
        }
        int l = left;
        int r = right;
        int baseNum = nums[left];
        while(l < r){
            //必须右边先走
            while(nums[r] >= baseNum && l < r){
                r--;
            }
            while(nums[l] <= baseNum && l < r){
                l++;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        nums[left] = nums[l];
        nums[l] = baseNum;
        quickSortDfs(nums, left, r-1);
        quickSortDfs(nums, l+1, right);
    }

    /**
     * 5. 归并排序
     * 分治算法；
     */

    //归
    public void mergeSortDfs(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int m = (l+r)/2;
        mergeSortDfs(nums, l, m);
        mergeSortDfs(nums, m+1, r);
        merge(nums, l, m, r);
    }
    //并
    private void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int l = left;
        int m = mid+1;
        int i = 0;
        while(l <= mid && m <= right){
            if(nums[l] < nums[m]){
                temp[i++] = nums[l++];
            } else {
                temp[i++] = nums[m++];
            }
        }
        while(l <= mid){
            temp[i++] = nums[l++];
        }
        while(m <= right){
            temp[i++] = nums[m++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    /**
     * 6. 希尔排序
     * 引入步长减少数字交换次数提高效率；
     */
//    6.1 希尔-冒泡排序（慢）
    public void shellBubbleSort(int[] nums){
        for (int step = nums.length/2; step > 0 ; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                for (int j = i-step; j >= 0; j -= step) {
                    if(nums[j] > nums[j+step]){
                        int temp = nums[j];
                        nums[j] = nums[j+step];
                        nums[j+step] = temp;
                    }
                }
            }
        }
    }

    //    6.2 希尔-插入排序（快）
    public void shellInsertSort(int[] nums) {
        for (int step = nums.length / 2; step > 0; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int j = i;
                int insertNum = nums[i];
                while (j - step >= 0 && nums[j - step] > insertNum) {
                    nums[j] = nums[j - step];
                    j -= step;
                }
                nums[j] = insertNum;
            }
        }
    }


    /**
     * 7. 堆排序
     * 大顶堆实现升序，每次将最大值移到堆的最后一个位置上；
     */
    public void heapSort2(int[] nums) {
        for(int i = nums.length/2-1; i >= 0; i--){
            sift(nums, i, nums.length);
        }
        for (int i = nums.length-1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            sift(nums, 0, i);
        }
    }
    private void sift(int[] nums, int parent, int len) {
        int value = nums[parent];
        for (int child = 2*parent +1; child < len; child = child*2 +1) {
            if(child+1 < len && nums[child+1] > nums[child]){
                child++;
            }
            if(nums[child] > value){
                nums[parent] = nums[child];
                parent = child;
            } else {
                break;
            }
        }
        nums[parent] = value;
    }


    /**
     * 8. 计数排序
     * 按顺序统计每个数出现次数；
     */
    public void countSort(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] countMap = new int[max-min+1];
        for(int num : nums){
            countMap[num-min]++;
        }
        int i = 0;
        int j = 0;
        while(i < nums.length && j < countMap.length){
            if(countMap[j] > 0){
                nums[i] = j+min;
                i++;
                countMap[j]--;
            } else {
                j++;
            }
        }
    }

    /**
     * 9. 桶排序
     * 类似计数排序，不同点在于统计的是某个区间（桶）里的数；
     */
    public void bucketSort(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketCount = (max-min)/nums.length+1;
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketList.add(new ArrayList<>());
        }

        for(int num : nums){
            int index = (num-min)/nums.length;
            bucketList.get(index).add(num);
        }
        for(List<Integer> bucket : bucketList){
            Collections.sort(bucket);
        }

        int j = 0;
        for(List<Integer> bucket : bucketList){
            for(int num : bucket){
                nums[j] = num;
                j++;
            }
        }
    }


    /**
     * 10. 基数排序
     * 按个、十、百位依次归类排序；
     */
    public  void radixSort(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        max -= min;
        int maxLen = (max+"").length();

        int[][] bucket = new int[nums.length][10];
        int[] bucketCount = new int[10];

        for (int i = 0, n = 1; i < maxLen; i++, n*=10) {
            for (int num : nums) {
                int digitVal = num / n % 10;
                bucket[bucketCount[digitVal]][digitVal] = num;
                bucketCount[digitVal]++;
            }
            int index = 0;
            for (int j = 0; j < bucketCount.length; j++) {
                if(bucketCount[j] > 0){
                    for (int k = 0; k < bucketCount[j]; k++) {
                        nums[index] = bucket[k][j];
                        index++;
                    }
                }
                bucketCount[j] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += min;
        }
    }


    /**
     * 11. 使用集合或 API
     *
     */
//    11.1 优先队列
    public void priorityQueueSort(int[] nums){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.offer(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
    }
//    11.2 Java API
    public void arraysApiSort(int[] nums){
        Arrays.sort(nums);
    }

    public static void main(String[] args) {

    }
}
