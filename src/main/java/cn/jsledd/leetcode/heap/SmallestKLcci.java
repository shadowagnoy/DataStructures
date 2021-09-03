package cn.jsledd.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @ClassName : DeleteNodeInALinkedList
 * @Description : 面试题 17.14. 最小K个数
 * @Author : JSLEDD
 * @Date: 2021-09-03 10:30
 */
public class SmallestKLcci {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 8, 5, 2};
        int k = 3;
        SmallestKLcci smallestKLcci = new SmallestKLcci();
        Arrays.stream(smallestKLcci.smallestK(arr, k)).forEach(System.out::println);
    }

    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (arr.length == 0) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        for (int x = k; x < arr.length; x++) {
            if (arr[x] < pq.peek()) {
                pq.poll();
                pq.offer(arr[x]);
            }
        }
        for (int y = 0; y < k; y++) {
            res[y] = pq.poll();
        }
        return res;
    }
}
