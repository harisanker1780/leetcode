package test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
        Set<String> result = new LinkedHashSet<String>();
        char[] array = digits.toCharArray();
        char[][] letters = {
        		{'a', 'b', 'c'},
        		{'d', 'e', 'f'},
        		{'g', 'h', 'i'},
        		{'j', 'k', 'l'},
        		{'m', 'n', 'o'},
        		{'p', 'q', 'r', 's'},
        		{'t', 'u', 'v'},
        		{'w', 'x', 'y', 'z'}
        };
        
        if(array.length == 0) {
        	return result.stream().collect(Collectors.toList());
        }
        
        int[] index = new int[array.length];
        while(true) {
        	StringBuilder builder = new StringBuilder();
        	for(int i = 0; i < array.length; i++) {
        		char c = array[i];
        		builder.append(letters[c - '2'][index[i]]);
        	}
        	
        	result.add(builder.toString());
        	
        	boolean isComplete = true;
        	for(int i = index.length - 1; i >= 0; i--) {
        		if(index[i] < letters[array[i] - '2'].length - 1) {
        			isComplete = false;
        			index[i]++;
        			break;
        		} else {
        			index[i] = 0;
        		}
        	}
        	
        	if(isComplete) {
        		break;
        	}
        }
        
        return result.stream().collect(Collectors.toList());
    }
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
		List<String> result = sol.letterCombinations("");
		System.out.println(Arrays.toString(result.toArray()));
	}
}
