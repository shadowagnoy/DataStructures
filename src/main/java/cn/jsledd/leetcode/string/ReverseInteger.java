package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : ReverseInteger
 * @Description : 7. 整数反转
 * @Author : JSLEDD
 * @Date: 2021-02-09 09:41
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int x = (int)Math.pow(2,31);
        int reverse = new ReverseInteger().reverse(x);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            if ((r * 10) / 10 != r) {//int 越界后会变成-1
                return 0;
            }
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}
