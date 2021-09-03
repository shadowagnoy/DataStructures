package cn.jsledd.leetcode.bit;

/**
 * @version 1.0
 * @ClassName : ConvertAnumberToHexadecimal
 * @Description : 405. 数字转换为十六进制数
 * @Author : JSLEDD
 * @Date: 2021-09-03 16:30
 */
public class ConvertAnumberToHexadecimal {

    public static void main(String[] args) {
        ConvertAnumberToHexadecimal convertAnumberToHexadecimal = new ConvertAnumberToHexadecimal();
        System.out.println(convertAnumberToHexadecimal.toHex(-26));
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            int temp = num & 0xf;
            sb.insert(0,a[temp]);
            num >>>= 4;
        }
        return sb.toString();
    }
}
