package pratice0531;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String A = sc.next();
//        String B = sc.next();
//        //int ret = result(A, B);
//        //System.out.println(ret);
//    }

//    private static int result(String a, String b) {
//        StringBuilder sb1 = new StringBuilder(a);
//        sb1.append(b);
//        StringBuilder sb2 = new StringBuilder(b);
//        sb2.append(a);
//
//
//    }

    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length  -1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partation(array, left, right);
        quickSortHelper(array,left, index - 1);
        quickSortHelper(array, index + 1,  right);
    }

    private int partation(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j) {
            while (i < j && array[i] >= base) {
                i++;
            }
            while (i < j && array[j] <= base) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array,i,right);
        return i;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        test.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    //[low, mid) 有序区间
    //[mid, high) 有序区间
    //把这两个有序区间合并成一个有序区间
    public static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0; // 记录当前output 数组中被放入多少个元素
        int cur1 = low;
        int cur2 = mid;
        while (cur1 < mid && cur2 < high) {
            //这里写成小于等于才能保证稳定性
            if (array[cur1] <= array[cur2]) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            } else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while (cur2 < high) {
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid, high);
        merge(array,low,mid,high);
    }
}
