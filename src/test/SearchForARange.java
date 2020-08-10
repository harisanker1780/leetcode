package test;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non decreasing array.
-10^9 <= target <= 10^9
 *
 */
public class SearchForARange {
	
	public int[] searchRange(int[] nums, int target) {
        
		int index = searchTarget(nums, 0, nums.length - 1, target);
		
		if(index >= 0) {
			int start = index;
			while(start >= 0 && nums[start] == target)
				start--;
			
			int end = index;
			while(end < nums.length && nums[end] == target)
				end++;
			
			return new int[] {start + 1, end - 1};
		}
		
		return new int[]{-1, -1};
    }
	
	private int searchTarget(int[] nums, int start, int end, int target) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target)
				return mid;
			if(target < nums[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		SearchForARange sol = new SearchForARange();
		//int[] nums = {5,7,7,8,8,10};
		int[] nums = {};
		System.out.println(Arrays.toString(sol.searchRange(nums, 8)));
		System.out.println(Arrays.toString(sol.searchRange(nums, 6)));
	}

}
