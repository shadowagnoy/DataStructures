package cn.jsledd.leetcode.array;


/**
 * @version 1.0
 * @ClassName : BestTimeToBuyAndSellStock_ii
 * @Description : 704. 二分查找
 * @Author : JSLEDD
 * @Date: 2021-09-06 09:02
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{1, 2, 4, 5,6,7,8}, 5));
    }
    public int search(int[] nums, int target) {
        int left = 0,rigth = nums.length-1;
        while(left<=rigth){
            int mid = (rigth - left)/2 + left;
            if(nums[mid] > target){
                rigth = mid-1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
