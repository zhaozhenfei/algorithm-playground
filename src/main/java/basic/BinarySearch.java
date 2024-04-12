package basic;

/**
 * Created by zhenfei7 on 2024/4/12.
 */
public class BinarySearch {

    public static void main(String[] args) {

        binarySearch();
        System.out.println(1/2);
    }

    private static void binarySearch() {
        int[] arr = {1, 2, 3};
        int target = 3;

        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        //注意点：1.循环退出条件是 left <= right，而不是 left < right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            System.out.println(target + " is not found");
        } else {
            System.out.println(target + " is found, index: " + index);
        }
    }
}
