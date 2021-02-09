package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : FirstUniqChar
 * @Description : 剑指 Offer 50. 第一个只出现一次的字符
 * @Author : JSLEDD
 * @Date: 2021-02-09 10:17
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";
        char c = new FirstUniqChar().firstUniqChar(s);
        System.out.println(c + "");
    }

    public char firstUniqChar(String s) {
        int zimu[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = chars[i] - 'a';
            zimu[i1] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (zimu[chars[i] - 'a'] == 1) return chars[i];
        }
        return ' ';
    }
}
