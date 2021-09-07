package cn.jsledd.leetcode.bit;

/**
 * @version 1.0
 * @ClassName : BestTimeToBuyAndSellStock_ii
 * @Description : 191. 位1的个数
 * @Author : JSLEDD
 * @Date: 2021-09-06 14:02
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(2));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            n = n &(n-1);
            res ++;
        }
        return res;
    }
}
