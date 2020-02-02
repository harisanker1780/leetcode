package hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		
		if(nums == null)
			return -1;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int value = map.get(nums[i]);
				map.put(nums[i], value + 1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		
		Iterator<Integer> itr = map.keySet().iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			int value = map.get(key);
			if(value == 1) {
				return key;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		SingleNumber sol = new SingleNumber();
		int[] input = {4,1,2,1,2};
		System.out.println(sol.singleNumber(input));
	}
}
