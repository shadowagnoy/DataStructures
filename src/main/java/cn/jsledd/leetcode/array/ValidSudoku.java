package cn.jsledd.leetcode.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName : ValidSudoku
 * @Description : 36. 有效的数独
 * @Author : JSLEDD
 * @Date: 2021-02-08 09:28
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char board[][] = {
                {'9', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char b[] = {'5', '5', '.', '.', '7', '.', '.', '.', '.'};
        boolean validSudoku = new ValidSudoku().isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        //因为数独中不可能出现0，我们将1-9  修改成0-8，节省数组内存
        int rows[][] = new int[9][9];//记录每行的值和个数
        int cols[][] = new int[9][9];//记录每列的值和个数
        int boxs[][] = new int[9][9];//记录每个3*3 方块中的值和个数
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char b = board[x][y];
                if (b != 46) {
                    int num = b - '1';
                    int boxindex = (x / 3) * 3 + y / 3;
                    if (rows[x][num] != 0) return false;
                    if (cols[y][num] != 0) return false;
                    if (boxs[boxindex][num] != 0) return false;
                    rows[x][num] = 1;
                    cols[y][num] = 1;
                    boxs[boxindex][num] = 1;
                }
            }
        }
        return true;
    }
}
