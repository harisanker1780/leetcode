package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	 public int[] twoSum(int[] nums, int target) {
	    
		 if(nums == null)
			 return null;
		 
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int i = 0; i < nums.length; i++) {
			 if(map.containsKey(target - nums[i])) {
				 int i1 = map.get(target - nums[i]);
				 int i2 = i;
				 return new int[] {i1, i2};
			 }
			 else { 
				 map.put(nums[i], i);
			 }
		 }
		 
		 return null;
	 }
	 
	public static void main(String[] args) {
		TwoSum sol = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(sol.twoSum(nums, target)));
	}
}
