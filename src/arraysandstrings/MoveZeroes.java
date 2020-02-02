package arraysandstrings;

import java.util.Arrays;

public class MoveZeroes {
	
	 public void moveZeroes(int[] nums) {
		 
		 if(nums == null)
			 return;
		 
		 int i = 0;
		 while(i < nums.length) {
			 if(nums[i] == 0) {
				 int nonZeroIndex = getNextNonZeroIndex(nums, i);
				 if(nonZeroIndex >= 0) {
					 swap(nums, i, nonZeroIndex);
				 }
			 }
			 
			 i++;
		 }
	 }
	 
	 private int getNextNonZeroIndex(int nums[], int from) {
		 for(int i = from + 1; i < nums.length; i++) {
			 if(nums[i] != 0)
				 return i;
		 }
		 
		 return -1;
	 }
	 
	 private void swap(int nums[], int i, int j) {
		 int temp =  nums[i];
		 nums[i] = nums[j];
		 nums[j] = temp;
	 }
	 
	public static void main(String[] args) {
		MoveZeroes sol = new MoveZeroes();
		int[] nums = {0,1,0,3,12};
		sol.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
