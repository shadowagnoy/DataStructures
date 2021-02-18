package cn.jsledd.leetcode.string;

import javafx.beans.binding.StringBinding;

/**
 * @version 1.0
 * @ClassName : CountAndSay
 * @Description : 38. 外观数列
 * @Author : JSLEDD
 * @Date: 2021-02-10 12:39
 */
public class CountAndSay {
    public static void main(String[] args) {
        String s = new CountAndSay().countAndSay(8);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String start = "1";
        while (1 < n--) {
            StringBuilder sb = new StringBuilder();
            char prechar = ' ';
            int count = 0;
            for (int i = 0; i < start.length(); i++) {
                char a = start.charAt(i);
                if (prechar != a && count != 0) {
                    sb.append("" + count + prechar);
                    count = 0;
                }
                prechar = a;
                count++;
            }
            sb.append("" + count + prechar);
            start = sb.toString();
        }
        return start;
    }
}
