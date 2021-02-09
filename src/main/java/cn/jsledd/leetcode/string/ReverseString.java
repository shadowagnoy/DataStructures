package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : ReverseString
 * @Description : 344. 反转字符串
 * @Author : JSLEDD
 * @Date: 2021-02-09 09:26
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l'};
        new ReverseString().reverseString(s);
        for (char a : s) {
            System.out.println("" + a + "\t");
        }
    }

    public void reverseString(char[] s) {
        char temp = ' ';
        for (int i = 0; i < s.length/2; i++){
            temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}
