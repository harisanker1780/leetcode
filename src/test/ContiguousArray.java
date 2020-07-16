package test;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	
	public int maxLength = 0;
	
	public int findMaxLength(int[] nums) {
		
		int max = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		map.put(0, -1);
		
		
		for(int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if(map.containsKey(count)) {
				int j = map.get(count);
				max = Math.max(max, (i - j));
			} else {
				map.put(count, i);
			}
		}
		
		return max;
	}
	
	
	/**
	 *	O(N^2) solution 
	 */
	public int findMaxLength2(int[] nums) {
		
		int numZeros = 0;
		int numOnes = 0;
		
		for(int num : nums) {
			if(num == 0) {
				numZeros++;
			} else {
				numOnes++;
			}
		}
		
		int i = 0;
		int j = nums.length - 1;
		while(i < nums.length && j >= 0) {
			if(nums[i] == 0) {
				numZeros--;
			} else {
				numOnes--;
			}
			
			if(numZeros == numOnes) {
				return (j - i) + 1;
			}
			
			i++;
			
			if(nums[j] == 0) {
				numZeros--;
			} else {
				numOnes--;
			}
			
			if(numZeros == numOnes) {
				return (j - i) + 1;
			}
			
			j--;
		}
		
		return 0;
	}
	
	/**
	 *	O(N^2) solution 
	 */
	public int findMaxLength1(int[] nums) {
		
		maxLength = 0;
        
		int numZeros = 0;
		int numOnes = 0;
		
		for(int num : nums) {
			if(num == 0) {
				numZeros++;
			} else {
				numOnes++;
			}
		}
		
		findMax(nums, 0, nums.length - 1, numZeros, numOnes);
		return maxLength;
    }
	
	private void findMax(int[] nums, int i, int j, int numZeros, int numOnes) {
		
		if(i == nums.length || j <= 0)
			return;
		
		int length = (j - i) + 1;
		if(numZeros == numOnes) {
			maxLength = Math.max(length, maxLength);
		}
		
		if(length > maxLength) {
			if(nums[i] == 0) {
				findMax(nums, i + 1, j, numZeros - 1, numOnes);
			} else {
				findMax(nums, i + 1, j, numZeros, numOnes - 1);
			}
			
			if(nums[j] == 0) {
				findMax(nums, i, j - 1, numZeros - 1, numOnes);
			} else {
				findMax(nums, i, j - 1, numZeros, numOnes - 1);
			}
		}
	}

	
	public static void main(String[] args) {
		ContiguousArray sol = new ContiguousArray();
		//int[] input = {1, 0, 0, 0, 0 , 1, 0, 0,1, 1};
		int[] input = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
		System.out.println(sol.findMaxLength(input));
	}
}
