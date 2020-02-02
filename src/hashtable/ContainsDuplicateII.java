package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
		if(nums == null)
			return false;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				if(Math.abs(index - i) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		ContainsDuplicateII sol = new ContainsDuplicateII();
		/*int[] nums = {1,2,3,1};
		int k = 3;*/
		
		/*int[] nums = {1,0,1,1};
		int k = 1;*/
		
		/*int[] nums = {1,2,3,1,2,3};
		int k = 2;*/
		int[] nums = {2, 2};
		int k = 3;
		
		System.out.println(sol.containsNearbyDuplicate(nums, k));
	}
}
