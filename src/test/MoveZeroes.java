package test;

import java.util.Arrays;

/**
 * 
 *Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int zeroPos = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0 && zeroPos == -1) {
				zeroPos = i;
			}
			
			if(nums[i] != 0 && zeroPos != -1) {
				swap(nums, i, zeroPos);
				zeroPos++;
			}
		}
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		MoveZeroes sol = new MoveZeroes();
		int a[] = {0,1,0,3,12, 8, 0, 1, 2,3};
		int a1[] = {1, 2, 3, 4};
		int a2[] = {0, 0, 0, 0, 1, 2, 3, 4};
		sol.moveZeroes(a1);
		System.out.println(Arrays.toString(a1));
	}

}
