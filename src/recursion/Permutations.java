package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 *
 */
public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		boolean visited[] = new boolean[nums.length];
		
		List<List<Integer>> result = new ArrayList<List<Integer>>(); 
		for(int i = 0; i < nums.length; i++) {
			List<List<Integer>> list = permute(nums, i, visited);
			for(List<Integer> l : list) {
				result.add(l);
			}
		}
		return result;
    }
	
	private List<List<Integer>> permute(int[] nums, int index, boolean visited[]) {
		List<List<Integer>> result = new ArrayList<List<Integer>>(); 
		
		visited[index] = true;
		boolean isLeaf = true;
		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
				isLeaf = false;
				List<List<Integer>> list = permute(nums, i, visited);
				for(List<Integer> l : list) {
					l.add(nums[index]);
					result.add(l);
				}
			}
		}
		
		if(isLeaf) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[index]);
			result.add(list);
		}
		
		visited[index] = false;
		return result;
	}

	
	public static void main(String[] args) {
		Permutations sol =  new Permutations();
		int nums[] = {1,2,3, 4};
		List<List<Integer>> result = sol.permute(nums);
    	for(List<Integer> l : result) {
			Integer[] a = l.toArray(new Integer[l.size()]);
			  System.out.println(Arrays.toString(a));
		}
	}
}
