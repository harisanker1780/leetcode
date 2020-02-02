package stack;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		if(s == null)
			return true;
		
		Stack<Character> stack = new Stack<Character>(); 
        char[] array  = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
        	char c = array[i];
        	if(c == '(' || c == '{' || c == '[') {
        		stack.push(c);
        	}
        	else if(c == ')') {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		
        		char top = stack.pop();
        		if(top != '(') {
        			return false;
        		}
        	}
        	else if(c == ']') {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		
        		char top = stack.pop();
        		if(top != '[') {
        			return false;
        		}
        	}
        	else if(c == '}') {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		
        		char top = stack.pop();
        		if(top != '{') {
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		ValidParentheses sol = new ValidParentheses();
		
		System.out.println(sol.isValid("{[]}"));
	}
}
