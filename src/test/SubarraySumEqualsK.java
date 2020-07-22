package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 */
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		
		if(nums == null)
			return 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			sum  = sum + nums[i];
			
			if(sum == k) {
				count++;
			} 
			
			if(map.containsKey(sum - k)) {
				count = count + map.get(sum - k);
			}
			
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
			
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		SubarraySumEqualsK sol = new SubarraySumEqualsK();
		int[] nums = {1, 1, 1};
		//int[] nums = {-1, -1, 1};
		//int[] nums = {0,0,0,0,0,0,0,0,0,0};// 55
		System.out.println(sol.subarraySum(nums, 2));
	}
}
