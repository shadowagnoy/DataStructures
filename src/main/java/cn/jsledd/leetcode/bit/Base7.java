package cn.jsledd.leetcode.bit;

/**
 * @version 1.0
 * @ClassName : Base7
 * @Description : 面试题 17.14. 最小K个数
 * @Author : JSLEDD
 * @Date: 2021-09-03 12:30
 */
public class Base7 {
    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(-7));
        System.out.println(18&0xf);
    }

    public String convertToBase7(int num) {
        boolean isPositive = true;
        if (num < 0) {
            num *= -1;
            isPositive = false;
        }
        StringBuilder db = new StringBuilder();
        while (num != 0) {
            db.append(num % 7);
            num /= 7;
        }
        if (!isPositive) {
            db.append("-");
        }
        return db.reverse().toString();
    }
}
