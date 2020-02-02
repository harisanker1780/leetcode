package arraysandstrings;

public class MaxConsecutiveOnes {
	
	public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null)
        	return 0;
        
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 1) {
        		count++;
        		if(count > maxCount) {
        			maxCount = count;
        		}
        	}
        	else {
        		count = 0;
        	}
        }
        
        return maxCount;
    }
	
	public static void main(String[] args) {
		MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
		int[] input = {1,1,0,1,1,1};
		System.out.println(sol.findMaxConsecutiveOnes(input));
	}
}
