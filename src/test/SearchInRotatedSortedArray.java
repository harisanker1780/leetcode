package test;

/**
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1 
 *
 */
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		else
			return search(nums, target, 0, nums.length - 1);
    }
	
	public int search(int[] nums, int target, int start, int end) {
		if(start > end)
			return -1;
		
		int mid = (end + start) / 2;
		
		if(target == nums[mid])
			return mid;
		
		if(nums[start] <= nums[mid]) {
			if(target >= nums[start] && target <= nums[mid])
				return search(nums, target, start, mid - 1);
			else
				return search(nums, target, mid + 1, end);
		} else {
			if((target >= nums[mid] && target <= nums[end])) {
				return search(nums, target, mid + 1, end);
			} else {
				return search(nums, target, start, mid - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
		//int nums[] = {4,5,6,7,0,1,2};
		//int nums[] = {1};
		int nums[] = {1, 3};
		System.out.println(sol.search(nums, 3));
	}
}
