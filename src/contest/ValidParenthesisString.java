package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParenthesisString {
	
	public boolean checkValidString(String s) {
		
		if(s == null || s.length() == 0)
			return true;
		
		char[] array = s.toCharArray();
		List<Integer> indexList = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			char c = array[i];
			if(c == '*') {
				indexList.add(i);
			}
		}
		
		Integer[] indexArray = new Integer[indexList.size()];
		indexArray = indexList.toArray(indexArray);
		
		return isValidString(array, 0, '(', indexArray) || isValidString(array, 0, ')', indexArray);
	}
	
	private boolean isValidString(char[] array, int index, char value, Integer[] indexArray) {
		
		if(isValidString(array)) {
			return true;
		}
		
		if(index >= indexArray.length)
			return false;
		
		array[indexArray[index]] = value;
		boolean isValid = isValidString(array, index + 1, '(', indexArray)  || isValidString(array, index + 1, ')', indexArray);
		array[indexArray[index]] = '*';
		return isValid;
	}
	
	private boolean isValidString(char[] array) {
		Stack<Character> stack = new Stack<Character>();
        for(char c : array) {
        	if(c == '(') {
        		stack.push(c);
        	}
        	else if(c == ')') {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		else {
        			char p = stack.pop();
        			if(p != '(')
        			{
        				return false;
        			}
        		}
        	}
        }
        
        return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParenthesisString sol = new ValidParenthesisString();
		String input = "*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)";
		//String input = "((**))))";
		//String input = "()*()**()(())(()()(())*)()((()**))()()()(((*(((*)))(**(())))*()*))()(()()(()))()((())(*()())())()(*";
		//String input = "()(*";
		System.out.println(sol.checkValidString(input));
	}

}
