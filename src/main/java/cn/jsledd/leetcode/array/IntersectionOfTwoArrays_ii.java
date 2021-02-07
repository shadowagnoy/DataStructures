package cn.jsledd.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @ClassName : IntersectionOfTwoArrays_ii
 * @Description : 350. 两个数组的交集 II
 * @Author : JSLEDD
 * @Date: 2021-02-07 15:07
 */
public class IntersectionOfTwoArrays_ii {
    public static void main(String[] args) {
        int nums1[] = {4, 9, 5};
        int nums2[] = {9, 4, 9, 8, 4};
        int[] intersect = new IntersectionOfTwoArrays_ii().intersect(nums1, nums2);
        for (int num : intersect) {
            System.out.println(num);
        }
    }

    /**
     * @param nums1
     * @param nums2
     * @return int[]
     * @throws
     * @description 借用HashMap 记录次数
     * @author JSLEDD
     * @date 2021/2/7 15:09
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer orDefault = map.getOrDefault(num, 0) + 1;
            map.put(num, orDefault);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            Integer count = map.getOrDefault(num, 0);
            if (count > 0) {//判断是不是再数组2中存在
                intersection[index++] = num;
                count--;
                if (count > 0) {//判断数组中 是不是还有
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @description 双指针方式解决
     * @author JSLEDD
     * @date 2021/2/7 16:12
     * @return int[]
     * @throws
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int n1index = 0;
        int n2index = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        while (n1index < length1 && n2index < length2) {
            if (nums1[n1index] > nums2[n2index]) {
                n2index++;
            } else if (nums1[n1index] < nums2[n2index]) {
                n1index++;
            } else {
                intersection[index++] = nums1[n1index];
                n2index++;
                n1index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
