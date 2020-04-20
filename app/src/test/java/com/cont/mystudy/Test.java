package com.cont.mystudy;

public class Test {

    @org.junit.Test
    public void test() {
        int[] array = {5, 6, 2, 4, 1, 8, 33, 14, 55, 46, 13};
//        int[] array = {2, 5, 9, 15, 55, 3, 4, 8, 12, 33};
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println();
//        maoPaoOrder(array);
//        selectedOrder(array);
//        quickSort(array, 0, array.length - 1);
//        insertSort(array);
//        shellSort(array, 3);
//        shellSort(array, 1);
//        mergeSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println();
//        System.out.println("key的下标是：" + banerySearch(array, 14));
    }

    /**
     * 归并排序
     */


    /**
     * 归并
     */


    /**
     * 希尔排序
     */
    public void shellSort(int[] array, int step) {
        if (array == null || array.length == 1) {
            return;
        }
        for (int i = 0; i < step; i++) {
            for (int j = step; j < array.length; j += step) {
                int index = j;
                int target = array[index];
                while (index > step - 1 && array[index - step] > target) {
                    array[index] = array[index - step];
                    index -= step;
                }
                array[index] = target;
            }
        }
    }


    /**
     * 插入排序
     */
    public void insertSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int index = i;
            int target = array[i];
            while (index > 0 && array[index - 1] > target) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = target;
        }
    }


    /**
     * 快速排序
     */
    public void quickSort(int[] array, int start, int end) {
        if (end - start < 1) return;
        int low = start;
        int high = end;
        int target = array[low];
        boolean leftToRight = false;
        Out:
        while (low < high) {
            if (leftToRight) {
                for (int i = low; i < high; i++) {
                    if (array[i] >= target) {
                        low = i;
                        array[high--] = array[i];
                        leftToRight = !leftToRight;
                        continue Out;
                    }
                }
                low = high;
            } else {
                for (int i = high; i > low; i--) {
                    if (array[i] <= target) {
                        high = i;
                        array[low++] = array[i];
                        leftToRight = !leftToRight;
                        continue Out;
                    }
                }
                high = low;
            }
        }
        array[low] = target;
        quickSort(array, start, low - 1);
        quickSort(array, low + 1, end);

    }

    /**
     * 二分查找
     */
    public int banerySearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (array[mid] > key) {
                end = mid;
            } else if (array[mid] < key) {
                start = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 选择排序
     */
    private void selectedOrder(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = length - 1; j > i; j--) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 冒泡
     */
    public void maoPaoOrder(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


}
