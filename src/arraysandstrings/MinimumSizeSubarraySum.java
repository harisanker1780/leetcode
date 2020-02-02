package arraysandstrings;

public class MinimumSizeSubarraySum {
	
	public int minSubArrayLen(int s, int[] nums) {
        
		if(nums == null || nums.length == 0)
			return 0;
		
		int minLength = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		while(true) {
			if(sum < s) {
				if(end == nums.length) {
					break;
				}
				sum = sum + nums[end];
				end++;
			}
			else if(sum >= s) {
				if(start == end){
					return 1;
				}
				else {
					if(start == nums.length) {
						break;
					}
					int currentLength = end - start;
					if(currentLength < minLength) {
						minLength = currentLength;
					}
					sum = sum - nums[start];
					start++;
				}
			}
		}
		
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum sol = new MinimumSizeSubarraySum();
		int s = 7; 
		int[] nums = {2,3,1,2,4,3};
		System.out.println(sol.minSubArrayLen(s, nums));
	}
}
