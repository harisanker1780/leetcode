package hashtable;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	public boolean containsDuplicate(int[] nums) {
        
		if(nums == null)
			return false;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i< nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		ContainsDuplicate sol = new ContainsDuplicate();
		int[] input = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(sol.containsDuplicate(input));
	}
}
