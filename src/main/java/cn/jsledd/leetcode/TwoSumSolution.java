package cn.jsledd.leetcode;
/*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        你可以按任意顺序返回答案。

         

        示例 1：

        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        示例 2：

        输入：nums = [3,2,4], target = 6
        输出：[1,2]
        示例 3：

        输入：nums = [3,3], target = 6
        输出：[0,1]
         

        提示：

        2 <= nums.length <= 103
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        只会存在一个有效答案*/

import java.util.HashMap;

/**
 * @version 1.0
 * @ClassName : TwoSum
 * @Description : 1. 两数之和
 * @Author : JSLEDD
 * @Date: 2021-01-05 13:37
 */
public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int f = 0;
        //将第一个值加入到map 集合
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] re_array = {map.get(target - nums[i]), i};
                return re_array;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int array[] = {1, 1, 8, 4, 5, 6};
        int[] ints = twoSumSolution.twoSum(array, 9);
        for (int a :
                ints) {
            System.out.println(a);
        }
    }
}
