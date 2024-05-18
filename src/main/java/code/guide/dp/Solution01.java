package code.guide.dp;

/**
 * Created by zhenfei7 on 2024/5/19.
 */

/**
 * 斐波那契数列问题的递归和动态规划
 * 给定整数N，返回斐波那契数列的第N项。（斐波那契数列为1，1，2，3，5，8，…，）
 *
 * 补充问题 1：给定整数 N，代表台阶数，一次可以跨 2个或者 1个台阶，返回有多少种走法。
 */
public class Solution01 {

    /**
     * 0(2ⁿ)的方法
     * @param n
     * @return
     */
    public int f1(int n) {
        if(n <1){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }
}
