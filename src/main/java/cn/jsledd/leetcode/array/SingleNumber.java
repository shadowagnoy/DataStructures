package cn.jsledd.leetcode.array;

/**
 * @version 1.0
 * @ClassName : SingleNumber
 * @Description : 136. 只出现一次的数字
 * @Author : JSLEDD
 * @Date: 2021-02-07 14:45
 */
public class SingleNumber {
    public static void main(String[] args) {
        int nums[] = {1, 2, 4, 1, 2, 4, 6};
        int i = new SingleNumber().singleNumber(nums);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) {
            r = r ^ n;
        }
        return r;
    }
}
