package cn.jsledd.sparsearray;

import java.util.Collections;

/**
 * @version 1.0
 * @ClassName : SparseArray
 * @Description : 稀疏数组
 * @Author : JSLEDD
 * @Date: 2016-06-01 17:58
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个简单的二维数组
        int array[][] = new int[8][8];
        array[1][2] = 1;
        array[2][3] = 2;
        array[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //转换成稀疏数组
        int[][] sparseArray = convertToSparseArray(array);
        //打印转换后的稀疏数组
        System.out.println("二维数组转成的稀疏数组~~");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //稀疏数组还原成普通数组
        System.out.println("稀疏数组还原成普通数组~~");
        int[][] array2 = convertToArrayfromSparseArray(sparseArray);
        //打印转换后的稀疏数组
        for (int[] row : array2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * @param array 普通的数组
     * @return int[][]
     * @throws
     * @description 将普通的数组转换成稀疏数组
     * @author JSLEDD
     * @date 2016/1/1 18:42
     */
    public static int[][] convertToSparseArray(int[][] array) {
        //得到非0数据
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        //将非0的数放入稀疏数组
        //count：标识第几个非0数
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        return sparseArray;
    }
    /**
     *
     * @param sparseArray  稀疏数组
     * @description 将稀疏数组还原成普通的数组
     * @author JSLEDD
     * @date 2016/1/1 19:36
     * @return int[][]
     * @throws
     */
    public static int[][] convertToArrayfromSparseArray(int[][] sparseArray){
        int rowlength = sparseArray[0][0];
        int collength = sparseArray[0][1];
        int [][] array = new int[rowlength][collength];
        for (int i = 1; i < sparseArray.length; i++) {
            int [] row = sparseArray[i];
            array[row[0]][row[1]] = row[2];
        }
        return array;
    }

}
