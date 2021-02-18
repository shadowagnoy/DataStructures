package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : ImplementStrstr
 * @Description : 28. 实现 strStr()
 * @Author : JSLEDD
 * @Date: 2021-02-10 08:34
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        String haystack = "aabaaabaaac", needle = "baaaba";
        int i = new ImplementStrstr().strStr(haystack, needle);
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] subchars = needle.toCharArray();
        int length = chars.length;
        int sublength = subchars.length;
        if (length < sublength) return -1;
        if (sublength == 0) return 0;
        int subindex = 0;
        int index = 0;
        int f = -1;
        while (index <= length - 1) {
            char subchar = subchars[subindex];
            char aChar = chars[index];
            if (subchar == aChar) {
                if (subindex == 0) {
                    f = index;
                }
                if (sublength == subindex + 1) return f;
                subindex++;
                index++;
            } else {
                index = f != -1 && subindex != 0 ? f + 1 :index +1;
                subindex = 0;
            }
        }
        return -1;
    }
}
