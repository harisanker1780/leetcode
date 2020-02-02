package arraysandstrings;

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
		int currentIndex = 0;
		int  i = 0;
		while(i < nums.length) {
			if(nums[i] > nums[currentIndex]) {
				currentIndex++;
				nums[currentIndex] = nums[i];
			}
			i++;
		}
		
		return currentIndex + 1;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
		//int nums[] = {1,1,2};
		int nums[] = {0,0,1,1,1,2,2,3,3,4};
		int length = sol.removeDuplicates(nums);
		for(int i = 0; i < length; i++) {
			System.out.println(nums[i] + " ");
		}
	}
}
