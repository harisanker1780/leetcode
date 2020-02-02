package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        
		if(nums1 == null || nums2 == null)
			return null;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums1.length; i++) {
			if(map.containsKey(nums1[i])) {
				int count = map.get(nums1[i]);
				map.put(nums1[i], count + 1);
			}
			else {
				map.put(nums1[i], 1);
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i])) {
				int count = map.get(nums2[i]);
				if(count > 0) {
					result.add(nums2[i]);
				}
				
				if(count == 1) {
					map.remove(nums2[i]);
				}
				else {
					map.put(nums2[i], count - 1);
				}
			}
		}
		
		int[] array = new int[result.size()];
		for(int i = 0; i < result.size(); i++) {
			array[i] = result.get(i);
		}
		return array;
    }
	
	public static void main(String[] args) {
		IntersectionOfTwoArraysII sol = new IntersectionOfTwoArraysII();
		//int[] nums1 = {1,2,2,1}, nums2 = {2, 2};
		int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(sol.intersect(nums1, nums2)));
	}
}
