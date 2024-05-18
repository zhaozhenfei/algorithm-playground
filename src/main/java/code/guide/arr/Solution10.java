package code.guide.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenfei7 on 2024/5/18.
 */

/**
 * 未排序数组中累加和为给定值的最长子数组系列问题
 */
public class Solution10 {
    public int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int length = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                length = Math.max(length, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return length;
    }
}
