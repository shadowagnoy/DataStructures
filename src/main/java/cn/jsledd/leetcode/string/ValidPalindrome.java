package cn.jsledd.leetcode.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @version 1.0
 * @ClassName : ValidPalindrome
 * @Description : 125. 验证回文串
 * @Author : JSLEDD
 * @Date: 2021-02-09 11:01
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = ".,";
        boolean palindrome = new ValidPalindrome().isPalindrome(s);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int li = 0;
        int ri = length - 1;
        while (length > 1) {
            char leftChar = chars[li];
            char rightChar = chars[ri];
            while (!Character.isLetterOrDigit(leftChar)) {
                if (li >= ri) return true;//代表循环结束了 左右都指向一个非字符
                leftChar = chars[++li];
                length--;
            }
            while (!Character.isLetterOrDigit(rightChar)) {
                if (li >= ri) return true;
                rightChar = chars[--ri];
                length--;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
            li++;
            length -= 2;
            ri--;
        }
        return true;
    }
}
