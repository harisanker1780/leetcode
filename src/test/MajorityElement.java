package test;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than [ n/2 ] times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 *
 */
public class MajorityElement {
	
	public int majorityElement(int[] nums) {
        
		int count = 0;
		Integer elem = null;
		
		for(int i = 0; i < nums.length; i++) {
			if(count == 0) {
				elem = nums[i];
			}
			
			count = elem == nums[i] ? count + 1 : count - 1;
		}
		
		return elem;
    }
	
	public static void main(String[] args) {
		MajorityElement sol =  new MajorityElement();
		//int[] nums = {3,2,3};
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(sol.majorityElement(nums));
	}

}
