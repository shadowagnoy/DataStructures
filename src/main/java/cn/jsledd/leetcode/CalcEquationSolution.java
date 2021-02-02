package cn.jsledd.leetcode;
/*给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

        另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

        返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。

         

        注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @ClassName : CalcEquationSolution
 * @Description : 399. 除法求值
 * @Author : JSLEDD
 * @Date: 2021-01-06 15:53
 */
public class CalcEquationSolution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Double> stringIntHashMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> k1k2 = equations.get(i);
            String k1 = k1k2.get(0);
            String k2 = k1k2.get(1);
            double v = values[i];
            stringIntHashMap.put(k1 + ":" + k2, v);
            stringIntHashMap.put(k2 + ":" + k1, 1 / v);
        }
        return null;
    }

    public static void main(String[] args) {
        CalcEquationSolution calcEquationSolution = new CalcEquationSolution();

        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("a", "b"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"));
        double[] doubles = calcEquationSolution.calcEquation(equations, values, queries);
        for (double d :
                doubles) {
            System.out.println(d);
        }
    }
}
