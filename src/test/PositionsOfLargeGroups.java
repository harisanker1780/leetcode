package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

 

Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
 

Note:  1 <= S.length <= 1000
 *
 */
public class PositionsOfLargeGroups {
	
	public List<List<Integer>> largeGroupPositions(String S) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(S == null)
			return result;
		
		char[] array = S.toCharArray();
		int i = 0;
		while(i < array.length) {
			int j = i + 1;
			while(j < array.length && array[j] == array[j - 1]) {
				j++;
			}
			
			if(j - i >= 3) {
				List<Integer> list = Arrays.asList(i, j - 1);
				result.add(list);
			}
			i = j;
		}
		
		return result;
    }
}
