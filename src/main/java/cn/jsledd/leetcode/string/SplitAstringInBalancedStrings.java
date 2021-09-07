package cn.jsledd.leetcode.string;

/**
 * @version 1.0
 * @ClassName : BestTimeToBuyAndSellStock_ii
 * @Description : 1221. 分割平衡字符串
 * @Author : JSLEDD
 * @Date: 2021-09-07 14:02
 */
public class SplitAstringInBalancedStrings {

    public static void main(String[] args) {
        System.out.println(new SplitAstringInBalancedStrings().balancedStringSplit("LRLRLR"));
    }
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int d = 0,res=0;
        for(char i :chars){
            if(i =='L'){
                d++;
            }
            else{
                d--;
            }
            if(d == 0){
                res++;
            }
        }
        return res;
    }
}
