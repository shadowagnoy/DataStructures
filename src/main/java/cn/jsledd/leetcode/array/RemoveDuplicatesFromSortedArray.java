package cn.jsledd.leetcode.array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @version 1.0
 * @ClassName : RemoveDuplicatesFromSortedArray
 * @Description : 26. 删除排序数组中的重复项
 * @Author : JSLEDD
 * @Date: 2021-02-04 15:43
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1,2};
        int i = new RemoveDuplicatesFromSortedArray().removeDuplicates1(nums);
        System.out.println(i);
    }

    /**
     * @param nums 数组
     * @return int
     * @throws
     * @description 不排序的数组,只返回个数
     * @author JSLEDD
     * @date 2021/2/4 16:31
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int re = length;
        for (int x = 0; x < length - 1; x++) {
            for (int y = x + 1; y < length; y++) {
                if (nums[x] == nums[y]) {
                    re--;
                    break;
                }
            }
        }
        return re;
    }

    /**
     * @param nums 数组
     * @return int 对数组返回有特殊要求
     * @throws
     * @description 排序数组
     * @author JSLEDD
     * @date 2021/2/4 16:32
     */
    public int removeDuplicates1(int[] nums) {
        int i = 0;//前一元素的指针
        for (int x = 1; x < nums.length; x++) {
            if (nums[i] != nums[x]) {
                i++;
                nums[i] = nums[x];
            }
        }
        return i;
    }

}
