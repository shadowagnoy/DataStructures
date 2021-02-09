package cn.jsledd.leetcode.array;

/**
 * @version 1.0
 * @ClassName : MoveZeroes
 * @Description : 283. 移动零
 * @Author : JSLEDD
 * @Date: 2021-02-08 08:44
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1, 1, 2, 0, 0,4, 2, 0, 0, 2, 9};
        new MoveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + "");
        }
        char a= '.';
        System.out.println(a);
    }

    public void moveZeroes(int[] nums) {
        int indexzero = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                if(i > indexzero){
                    nums[indexzero] = num;
                    nums[i] = 0;
                }
                indexzero++;
            }
        }
    }
}
