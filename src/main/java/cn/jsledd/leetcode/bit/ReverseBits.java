package cn.jsledd.leetcode.bit;

/**
 * @version 1.0
 * @ClassName : BestTimeToBuyAndSellStock_ii
 * @Description : 190. 颠倒二进制位
 * @Author : JSLEDD
 * @Date: 2021-09-07 14:11
 */
public class ReverseBits {
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(11));
    }
}
