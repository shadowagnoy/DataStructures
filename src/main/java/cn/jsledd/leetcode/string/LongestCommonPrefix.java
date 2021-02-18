package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : LongestCommonPrefix
 * @Description : 14. 最长公共前缀
 * @Author : JSLEDD
 * @Date: 2021-02-18 10:34
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"1","2"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        int length = strs.length;
        if (length == 0) return "";
        if (length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        boolean falg = true;
        int index = 0;
        while (falg) {
            int length1 = strs[0].length();
            if (length1 == 0) return "";
            if(length1-1 < index) return strs[0];
            char prechar = strs[0].charAt(index);
            for (int i = 1; i < length; i++) {
                if (index == strs[i].length()) {
                    falg = false;
                    break;
                } else {
                    char c = strs[i].charAt(index);
                    if (prechar != c) {
                        falg = false;
                        break;
                    }
                }
            }
            index++;
            if (falg) sb.append(prechar);

        }
        return sb.toString();
    }
}
