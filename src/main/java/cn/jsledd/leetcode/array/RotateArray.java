package cn.jsledd.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName : RotateArray
 * @Description : 189. 旋转数组
 * @Author : JSLEDD
 * @Date: 2021-02-05 10:08
 */
public class RotateArray {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6};
        new RotateArray().rotate1(nums, 3);
        for (int n:nums){
            System.out.print(n);
        }
    }

    /**
     * @param nums 数组
     * @param i    移动次数
     * @return void
     * @throws
     * @description 使用最简单的方法，再使用一个数组来记录转换后的数组
     * @author JSLEDD
     * @date 2021/2/5 10:08
     */
    private void rotate(int[] nums, int i) {
        int length = nums.length;
        int[] ints = Arrays.copyOf(nums, length);
        for (int x = 0; x < length; x++) {
            int i1 = (x + i) % length; //变换后的索引
            nums[i1] = ints[x];
        }
    }

    /**
     * @param nums 数组
     * @param i    移动次数
     * @return void
     * @throws
     * @description 环状替换
     * @author JSLEDD
     * @date 2021/2/7 10:16
     */
    private void rotate1(int[] nums, int k) {
        int length = nums.length;
        if (k % length  == 0 || length  == 1) return;
        int count = 0;//记录移动的次数
        for (int i = 0; count < length; i++) {//移动的次数需要覆盖全部元素
            int cu = i; //当前数组的索引
            int prev = nums[i];//上一个元素的值
            do {
                int next = (cu + k) % nums.length;//需要移动到的位置
                int temp = nums[next];//需要一开的变量
                nums[next] = prev;
                prev = temp;
                cu = next;
                count++;
            }
            while (i != cu);
        }
    }

    /**
     * @param nums
     * @param k
     * @return void
     * @throws
     * @description 环状替换 官方
     * @author JSLEDD
     * @date 2021/2/7 12:32
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
