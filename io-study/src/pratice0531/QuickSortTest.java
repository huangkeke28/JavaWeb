package pratice0531;

import java.util.Arrays;

public class QuickSortTest {
    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partation(array, left, right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,  right);
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
                j--;  //    2 5 7 9 6 8
            }
            swap(array, i, j);
        }
        swap(array,i,right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 8};
        QuickSortTest qs = new QuickSortTest();
        qs.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
