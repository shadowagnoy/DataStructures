package cn.jsledd.leetcode.array;

/**
 * @version 1.0
 * @ClassName : RotateImage
 * @Description : 48. 旋转图像
 * @Author : JSLEDD
 * @Date: 2021-02-08 11:15
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new RotateImage().rotate(m2);
    }
    public static void printArray(int[][] matrix){
        System.out.println("------------");
        for(int x[]:matrix){
            for(int y:x){
                System.out.print(y + "\t");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int rowindex = 0;
        int colindex = 0;
        int length = matrix[0].length;
        int temp = 0;
        int i = 0;
        for (int y = 0; y < (length) / 2; y++) {//第几圈循环
            for (int k = y; k < length - y - 1; k++) {
                int prev = matrix[y][k];
                rowindex = y;
                colindex = k;
                int ttindex = 0;
                for (int x = 0; x < 4; x++) {
                    ttindex = rowindex;
                    rowindex = colindex;
                    colindex = length - 1 - ttindex;
                    temp = matrix[rowindex][colindex];
                    matrix[rowindex][colindex] = prev;
                    prev = temp;
                    System.out.println("prev="+i++);
                }
            }
        }

    }
}
