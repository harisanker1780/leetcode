package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		
        if(nums1 == null || nums2 == null)
        	return null;
        
        Set<Integer> set1 = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
        	set1.add(nums1[i]);
        }
        
        Set<Integer> set2 = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; i++) {
        	if(set1.contains(nums2[i])) {
        		set2.add(nums2[i]);
        	}
        }
        
        int[] result = new int[set2.size()];
        Iterator<Integer> itr = set2.iterator();
        int i = 0;
        while(itr.hasNext()) {
        	result[i++] = itr.next();
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		IntersectionOfTwoArrays sol = new IntersectionOfTwoArrays();
		int nums1[] = {4,9,5};
		int nums2[] = {9,4,9,8,4};
		
		System.out.println(Arrays.toString(sol.intersection(nums1, nums2)));
	}
}
