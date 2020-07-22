package test;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {
	
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length  == 0)
			return true;
		
		int maxSkipIndex = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				maxSkipIndex = Math.max(maxSkipIndex, i + nums[i]);
			} else {
				if(i >= maxSkipIndex) {
					 return i == nums.length - 1;
				}
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		JumpGame sol = new JumpGame();
		int nums[] = {2,3,1,1,4};
		//int nums[] = {3,2,1,0,4};
		//int nums[] = {0};
		System.out.println(sol.canJump(nums));
	}

}
