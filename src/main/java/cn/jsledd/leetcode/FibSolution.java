package cn.jsledd.leetcode;

/**
 * @version 1.0
 * @ClassName : FibSolution
 * @Description : 509. 斐波那契数
 * @Author : JSLEDD
 * @Date: 2021-01-05 15:22
 */
public class FibSolution {
    public int fib(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        FibSolution fibSolution = new FibSolution();
        System.out.println(fibSolution.fib(4));
    }
}
