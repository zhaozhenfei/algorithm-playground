package cartoon;

import java.util.Arrays;

/**
 * Created by zhenfei7 on 2024/4/23.
 */
public class QuickSort {

    /**
     * 以起始数据作为pivot（锚定节点）
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionPivotAtStartIndex(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 以结尾数据作为pivot（锚定节点）
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionPivotAtEndIndex(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int mark = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < pivot) {
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
                mark++;
            }
        }

        arr[endIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        //int pivot = partitionPivotAtStartIndex(arr, startIndex, endIndex);
        int pivot = partitionPivotAtEndIndex(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivot - 1);
        quickSort(arr, pivot + 1, endIndex);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 2, 5, 6, 11, 8, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
