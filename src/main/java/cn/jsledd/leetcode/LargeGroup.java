package cn.jsledd.leetcode;

/*在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。

        例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。

        分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。

        我们称所有包含大于或等于三个连续字符的分组为 较大分组 。

        找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。

         

        示例 1：

        输入：s = "abbxxxxzzy"
        输出：[[3,6]]
        解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
        示例 2：

        输入：s = "abc"
        输出：[]
        解释："a","b" 和 "c" 均不是符合要求的较大分组。
        示例 3：

        输入：s = "abcdddeeeeaabbbcd"
        输出：[[3,5],[6,9],[12,14]]
        解释：较大分组为 "ddd", "eeee" 和 "bbb"
        示例 4：

        输入：s = "aba"
        输出：[]
         
        提示：

        1 <= s.length <= 1000
        s 仅含小写英文字母*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @ClassName : LargeGroup
 * @Description : 较大分组的位置
 * @Author : JSLEDD
 * @Date: 2021-01-05 10:55
 */
public class LargeGroup {
    /**
     *
     * @param s 字符串
     * @description 本人使用方法
     * @author JSLEDD
     * @date 2021/1/5 12:11
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @throws
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        char flagchar = 'A';
        int flaglength = 1;
        int flagstart = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != flagchar) {
                if (flaglength >= 3) {
                    list.add(Arrays.asList(flagstart, i-1));
                }
                flaglength = 1;
                flagstart = i;
                flagchar = c;
            } else {
                flaglength++;
                if (i == s.length() - 1) {
                    if (flaglength >= 3) {
                        flaglength = 1;
                        list.add(Arrays.asList(flagstart, i));
                    }
                }
            }
        }
        return list;
    }

    /**
     *
     * @param s 官方方法
     * @description
     * @author JSLEDD
     * @date 2021/1/5 12:11
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @throws
     */
    public List<List<Integer>> largeGroupPositions_1(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }

    /**
     *
     * @param s 字符串
     * @description 其他方法推荐
     * @author JSLEDD
     * @date 2021/1/5 12:15
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @throws 
     */
    public List<List<Integer>> largeGroupPositions_2(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;//相同字符串左边边界
        int length = s.length();
        while (left < length) {
            int count = 0;//相同字符串的长度
            //统计相同字符串的长度
            while (left + count < length && s.charAt(left) == s.charAt(left + count))
                count++;
            //如果长度大于等于3，就把他加入到res中
            if (count >= 3)
                res.add(Arrays.asList(left, left + count - 1));
            //更新下一个字符串的左边边界
            left = left + count;
        }
        return res;
    }
    
    public static void main(String[] args) {
        LargeGroup largeGroup = new LargeGroup();
        List<List<Integer>> abccccdeeef = largeGroup.largeGroupPositions("aaa");
        System.out.println(abccccdeeef);
    }
}
