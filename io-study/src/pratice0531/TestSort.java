package pratice0531;

public class TestSort {
    public static void quickSort(int[] array) {
        //此处为了代码简单区间设置成前闭后闭
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            //区间中有0个元素或者1个元素,此时不许要排序
            return;
        }
        //针对[left, right]区间进行整理
        //index返回值就是整理完毕后,left 和 right的重合位置, 知道这个位置才能进一步进行递归
        int index = partation(array, left, right);
        quickSortHelper(array,left, index - 1);
        quickSortHelper(array,index + 1, right);
    }

    private static int partation(int[] array, int left, int right) {
        int i = left;
        int j = right;
        //取最右侧元素为基准值
        int base = array[right];
        while (i < j) {
            //从左往右找比基准值大的元素
            while (i < j && array[i] <= base) {
                i++;
            }
            //当上面的循环结束时,此时i要么和j重合 要么i 就指向一个大于base的值
            while (i < j && array[j] >= base) {
                j--;
            }
            //当上面的循环结束时,此时i要么和j重合 要么j 就指向一个小于base的值

            //交换i和j的值
            swap(array, i, j);
        }
        //当i 和 j 重合的时候  最后一步 要把重合位置的元素和基准值交换
        swap(array, i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
