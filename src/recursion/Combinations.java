package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
    	int array[] = new int[n];
    	for(int i = 1; i <= n; i++) {
    		array[i - 1] = i;
    	}
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	for(int i = 0; i < n; i++) {
    		List<List<Integer>> list = combine(array, i, 1, k);
    		for(List<Integer> l : list) {
    			result.add(l);
    		}
    	}
    	
    	return result;
    }
    
    private List<List<Integer>> combine(int[] array, int index, int count, int k) {
    	if(count == k) {
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(array[index]);
    		result.add(list);
    		return result;
    	}
    	else {
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
    		for(int i = index + 1; i < array.length; i++) {
        		if(array.length - i  < (k - count)) {
        			break;
        		}
        		
        		List<List<Integer>> list = combine(array, i, count + 1, k);
        		if(list != null) {
        			for(List<Integer> l : list) {
        				l.add(array[index]);
        				result.add(l);
        			}
        		}
        	}
        	
        	return result;
    	}
    }
    
    public static void main(String[] args) {
    	Combinations col = new Combinations();
    	List<List<Integer>> result = col.combine(2, 2);
    	for(List<Integer> l : result) {
			Integer[] a = l.toArray(new Integer[l.size()]);
			  System.out.println(Arrays.toString(a));
		}
	}
}
