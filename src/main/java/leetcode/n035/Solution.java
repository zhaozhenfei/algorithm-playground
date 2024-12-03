package leetcode.n035;

/**
 * Created by zhenfei7 on 2024/6/3.
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 1;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        if (nums[mid] > target) {
            return mid;
        } else {
            return mid + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6};
        int traget1 = 5;
        searchInsert(arr1, traget1);
    }
}
