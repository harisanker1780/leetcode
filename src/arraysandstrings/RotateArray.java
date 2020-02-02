package arraysandstrings;

import java.util.Arrays;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
        
		if(nums == null || nums.length == 0)
			return;
		
		while(k > 0) {
			int temp = nums[0];
			for(int i = 0; i < nums.length - 1; i++) {
				int tempNext = nums[i + 1];
				nums[i + 1] = temp;
				temp = tempNext;
			}
			
			nums[0] = temp;
			k--;
		}
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		
		RotateArray sol = new RotateArray();
		sol.rotate(nums, k);
		
		System.out.println(Arrays.toString(nums));
	}
}
