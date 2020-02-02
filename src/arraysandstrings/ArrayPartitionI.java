package arraysandstrings;

import java.util.Arrays;

public class ArrayPartitionI {
	
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for(int i = 0; i < nums.length; i = i + 2) {
			sum += Math.min(nums[i], nums[i + 1]); 
		}
		
		return sum;
    }
	
	public static void main(String[] args) {
		ArrayPartitionI sol = new ArrayPartitionI();
		int[] input = {1,4,3,2};
		System.out.println(sol.arrayPairSum(input));
	}
}
