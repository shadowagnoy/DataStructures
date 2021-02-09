package cn.jsledd.leetcode.string;

import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName : ValidAnagram
 * @Description : 242. 有效的字母异位词
 * @Author : JSLEDD
 * @Date: 2021-02-09 10:44
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = new ValidAnagram().isAnagram(s, t);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.equals(schars, tchars);
    }
}
