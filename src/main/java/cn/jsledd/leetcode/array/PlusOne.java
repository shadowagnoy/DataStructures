package cn.jsledd.leetcode.array;

/**
 * @version 1.0
 * @ClassName : PlusOne
 * @Description : 66. 加一
 * @Author : JSLEDD
 * @Date: 2021-02-07 17:02
 */
public class PlusOne {
    public static void main(String[] args) {
        int nums1[] = {9, 9, 9};
        int[] ints = new PlusOne().plusOne(nums1);
        for (int num : ints) {
            System.out.print(num);
        }
    }

    /**
     * @param digits
     * @return int[]
     * @throws
     * @description
     * @author JSLEDD
     * @date 2021/2/7 17:03
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            int i1 = digits[i] + 1;
            if (i1 == 10) {
                digits[i] = 0;
            } else {
                digits[i] = i1;
                return digits;
            }
        }
        int d[] = new int[digits.length + 1];
        d[0] = 1;
        return d;
    }
}
