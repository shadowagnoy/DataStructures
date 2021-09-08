package cn.jsledd.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @ClassName : IPO
 * @Description : 502. IPO
 * @Author : JSLEDD
 * @Date: 2021-09-08 12:45
 */
public class IPO {

    public static void main(String[] args) {
        System.out.println(new IPO().findMaximizedCapital(2, 0, new int[]{1, 2}, new int[]{0, 1}));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = profits.length;
        int[][] ps = new int[length][2];
        for (int i = 0; i < length; i++) {
            ps[i][0] = capital[i];
            ps[i][1] = profits[i];
        }
        //按启动至今从小到大排序
        Arrays.sort(ps, (a, b) -> a[0] - b[0]);
        //生成一个大顶堆
        int curr = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            while (curr < length && w >= ps[curr][0]) {
                pq.add(ps[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w+= pq.poll();
            } else {
                break;
            }
        }
        return w;
    }
}
