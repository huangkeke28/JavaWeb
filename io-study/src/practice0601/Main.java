package practice0601;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s1 = sc.next();
//            String s2 = sc.next();
//            System.out.println(number(s1, s2));
//        }
        Main main = new Main();
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        main.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    //快速排序 不稳定排序 O(NlogN)  O(1)
    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partation(array, left, right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1, right);

    }

    private int partation(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int number(String s1, String s2) {
        int count = 0;
        int len = s1.length();
        for (int i = 0; i <= len; i++) {
            String s = s1.substring(0, i) + s2 + s1.substring(i, len);
            if (isHuiWen(s)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isHuiWen(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
