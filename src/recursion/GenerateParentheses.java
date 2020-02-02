package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 
 *
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		
		if(n <= 0) {
			return result;
		}
		
		List<String> list = generateParenthesis(n - 1, n);
		for(String s : list) {
			result.add("(" + s);
		}
		
        return result;
    }
	
	private List<String> generateParenthesis(int left, int right) {
		
		if(left > right || left < 0 || right < 0) {
			return null;
		}
		
		if(left == 0 && right == 0) {
			List<String> result = new ArrayList<String>();
			result.add("");
			return result;
		}
		
		List<String> result = new ArrayList<String>();
		List<String> list = generateParenthesis(left - 1, right);
		if(list != null) {
			for(String s : list) {
				result.add("(" + s);
			}
		}
		
		list = generateParenthesis(left, right - 1);
		if(list != null) {
			for(String s : list) {
				result.add(")" + s);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		GenerateParentheses sol = new GenerateParentheses();
		List<String> list = sol.generateParenthesis(4);
		for(String s : list) {
			System.out.println(s);
		}
	}
}
