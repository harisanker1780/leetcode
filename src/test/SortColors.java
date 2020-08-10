package test;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 *
 */
public class SortColors {
	
	public void sortColors(int[] nums) {
        
		int zeroIndex = 0;
		int twoIndex = nums.length - 1;
		
		int index = 0;
		while(index <= twoIndex && zeroIndex < twoIndex) {
			if(nums[index] == 0) {
				nums[index] = nums[zeroIndex];
				nums[zeroIndex] = 0;
				zeroIndex++;
				index++;
			} else if(nums[index] == 2) {
				nums[index] = nums[twoIndex];
				nums[twoIndex] = 2;
				twoIndex--;
			} else {
				index++;
			}
		}
    }
	
	public static void main(String[] args) {
		SortColors sol = new SortColors();
		//int[] nums = {2,0,2,1,1,0};
		//int[] nums = {0,0,2,1,1,0};
		int[] nums = {0, 1, 1, 1, 2, 0 };
		sol.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
