package arraysandstrings;

public class LargestNumberAtLeastTwiceofOthers {

	public int dominantIndex(int[] nums) {
        if(nums == null)
        	return -1;
        
        int largest = -1;
        int prevLargest = -1;
        int index = 1;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] > largest) {
        		prevLargest = largest;
        		largest = nums[i];
        		index = i;
        	}
        	if(nums[i] != largest && nums[i] > prevLargest) {
        		prevLargest = nums[i];
        	}
        }
        
        if((prevLargest * 2) <= largest){
        	return index;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		
		//int nums[] = {3, 6, 1, 0};
		int nums[] = {1, 2, 3, 4};
		
		LargestNumberAtLeastTwiceofOthers sol = new LargestNumberAtLeastTwiceofOthers();
		System.out.println(sol.dominantIndex(nums));
	}
}
