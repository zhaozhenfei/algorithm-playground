package leetcode.n069;

/**
 * Created by zhenfei7 on 2024/7/8.
 */

/**
 * x 的平方根
 */
public class Solution {


    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long temp = (long) mid * mid;
            if (temp == x) {
                return mid;
            } else if (temp > x) {
                high = mid - 1;
                res = mid - 1;
            } else {
                low = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
