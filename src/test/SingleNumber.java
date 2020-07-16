package test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if(map.containsKey(num)) {
				map.remove(num);
			} else {
				map.put(num, num);
			}
		}
		
		Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
		return entry.getKey();
	}
	
	public static void main(String[] args) {
		int a[] = {4,1,2,1,2};
		SingleNumber sol = new SingleNumber();
		System.out.println(sol.singleNumber(a));
	}
}
