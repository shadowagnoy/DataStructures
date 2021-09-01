package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : CountAndSay
 * @Description : 165. 比较版本号
 * @Author : JSLEDD
 * @Date: 2021-09-01 12:39
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("1.0.02", "1.0.2"));
    }

    public int compareVersion(String version1, String version2) {
        int x = 0, y = 0;
        String[] version1array = version1.split("\\.");
        String[] version2array = version2.split("\\.");
        while (x < version1array.length || y < version2array.length) {
            int v1 = 0, v2 = 0;
            if (x < version1array.length) {
                v1 = Integer.parseInt(version1array[x++]);
            }
            if (y < version2array.length) {
                v2 = Integer.parseInt(version2array[y++]);
            }
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }
}
