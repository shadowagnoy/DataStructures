package cn.jsledd.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @ClassName : ContainsDuplicate
 * @Description : 217. 存在重复元素
 * @Author : JSLEDD
 * @Date: 2021-02-07 12:12
 */
public class ContainsDuplicate {
    /**
     *
     * @param nums 数组
     * @description 存在重复的元素
     * @author JSLEDD
     * @date 2021/2/7 12:13
     * @return boolean
     * @throws
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
