package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *
 */
public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null)
			return result;
		
		result.add(new ArrayList<Integer>());
		
		int subsetLength = 1;
		int arrayLength = nums.length;
		while(subsetLength <= arrayLength) {
			for(int startIndex = 0; startIndex <= (arrayLength - subsetLength); startIndex++) {
				List<Integer> subset = new ArrayList<Integer>();
				for(int i = startIndex; i < (startIndex + subsetLength); i++) {
					subset.add(nums[i]);
				}
				result.add(subset);
			}
			
			subsetLength++;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		Subsets sol = new Subsets();
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = sol.subsets(nums);
		for(List<Integer> subset : result) {
			System.out.println(Arrays.toString(subset.toArray()));
		}
	}
}
