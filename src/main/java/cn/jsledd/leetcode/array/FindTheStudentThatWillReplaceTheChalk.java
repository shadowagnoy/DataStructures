package cn.jsledd.leetcode.array;


/**
 * @version 1.0
 * @ClassName : FindTheStudentThatWillReplaceTheChalk
 * @Description : 1894. 找到需要补充粉笔的学生编号
 * @Author : JSLEDD
 * @Date: 2021-09-10 20:40
 */
public class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        System.out.println(new FindTheStudentThatWillReplaceTheChalk().chalkReplacer(new int[]{1, 2, 3, 4}, 23));
    }

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += chalk[i];
        }
        k %= total;
        int res = -1;
        for (int x = 0; x < n; x++) {
            if (k < chalk[x]) {
                res = x;
                break;
            }
            k -= chalk[x];
        }
        return res;
    }

    public int chalkReplacer1(int[] chalk, int k) {
        int nums = chalk.length;
        if (nums == 1) {
            return 0;
        }
        int i = 0;
        while (true) {
            if (chalk[i] > k) {
                return i;
            } else if (chalk[i] == k) {
                return (i + 1) % nums;
            } else {
                k -= chalk[i];
                i = (i + 1) % nums;
            }
        }
    }
}
