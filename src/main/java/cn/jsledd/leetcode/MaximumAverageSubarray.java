package cn.jsledd.leetcode;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * @version 1.0
 * @ClassName : MaximumAverageSubarray
 * @Description : 643. 子数组最大平均数 I
 * @Author : JSLEDD
 * @Date: 2021-02-04 12:06
 */
public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3,23};
        int k = 4;
        double maxAverage = new MaximumAverageSubarray().findMaxAverage1(nums, k);
        System.out.println(maxAverage);
    }

    public double findMaxAverage1(int[] nums, int k) {
        int sum = 0;
        //将索引时 0 - K-1的加上
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int subsum = sum;
        for (int i = k; i < nums.length; i++) {
            subsum = subsum - nums[i - k] + nums[i];
            sum = Math.max(sum, subsum);
        }
        return sum * 1.0 / k;
    }
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
