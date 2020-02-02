package arraysandstrings;

public class RemoveElement {
	
	public int removeElement(int[] nums, int val) {
        if(nums == null)
        	return 0;
        
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != val) {
        		nums[k] = nums[i];
        		k++;
        	}
        }
        
        return k;
    }
	
	public static void main(String[] args) {
		RemoveElement sol = new RemoveElement();
		
		/*int[] nums = {3,2,2,3};
		int val = 3;*/
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println(sol.removeElement(nums, val));
	}
}
